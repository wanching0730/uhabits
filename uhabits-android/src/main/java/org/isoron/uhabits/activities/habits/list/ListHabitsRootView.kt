/*
 * Copyright (C) 2016 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package org.isoron.uhabits.activities.habits.list

import android.content.*
import android.os.Build.VERSION.*
import android.os.Build.VERSION_CODES.*
import android.support.v7.widget.Toolbar
import android.view.*
import android.view.ViewGroup.LayoutParams.*
import android.widget.*
import android.widget.RelativeLayout.*
import org.isoron.androidbase.activities.*
import org.isoron.androidbase.utils.*
import org.isoron.androidbase.utils.InterfaceUtils.*
import org.isoron.uhabits.*
import org.isoron.uhabits.activities.common.views.*
import org.isoron.uhabits.activities.habits.list.views.*
import org.isoron.uhabits.core.models.*
import org.isoron.uhabits.core.preferences.*
import org.isoron.uhabits.core.tasks.*
import org.isoron.uhabits.core.ui.screens.habits.list.*
import org.isoron.uhabits.core.utils.*
import javax.inject.*

fun RelativeLayout.addBelow(
        view: View,
        subject: View,
        w: Int,
        h: Int,
        applyCustomRules: (params:RelativeLayout.LayoutParams) -> Unit = {}
) {
    view.layoutParams = RelativeLayout.LayoutParams(w, h).apply {
        addRule(BELOW, subject.id)
        applyCustomRules(this)
    }
    view.id = View.generateViewId()
    this.addView(view)
}

fun RelativeLayout.addAtBottom(view: View, w: Int, h: Int) {
    view.layoutParams = RelativeLayout.LayoutParams(w, h).apply {
        addRule(ALIGN_PARENT_BOTTOM)
    }
    view.id = View.generateViewId()
    this.addView(view)
}

fun RelativeLayout.addAtTop(view: View, w: Int, h: Int) {
    view.layoutParams = RelativeLayout.LayoutParams(w, h).apply {
        addRule(ALIGN_PARENT_TOP)
    }
    view.id = View.generateViewId()
    this.addView(view)
}

@ActivityScope
class ListHabitsRootView @Inject constructor(
        @ActivityContext context: Context,
        hintListFactory: HintListFactory,
        private val listAdapter: HabitCardListAdapter,
        private val runner: TaskRunner,
        preferences: Preferences,
        midnightTimer: MidnightTimer
) : BaseRootView(context), ModelObservable.Listener, TaskRunner.Listener {

    val listView: HabitCardListView
    val llEmpty: ViewGroup
    val tbar: Toolbar
    val progressBar: ProgressBar
    val hintView: HintView
    val header: HeaderView

    init {
        val sr = StyledResources(context)
        tbar = inflate(context, R.layout.toolbar, null) as Toolbar
        header = HeaderView(context, preferences, midnightTimer)
        listView = HabitCardListView(context, listAdapter)
        llEmpty = EmptyListView(context)
        progressBar = ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal).apply {
            visibility = GONE
            isIndeterminate = true
        }

        val hints = resources.getStringArray(R.array.hints)
        val hintList = hintListFactory.create(hints)
        hintView = HintView(context, hintList)

        addView(RelativeLayout(context).apply {
            background = sr.getDrawable(R.attr.windowBackgroundColor)
            layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT)

            addAtTop(tbar, MATCH_PARENT, sr.getDimension(R.attr.actionBarSize))
            addBelow(header, tbar, MATCH_PARENT, WRAP_CONTENT)
            addBelow(listView, header, MATCH_PARENT, MATCH_PARENT)
            addBelow(llEmpty, header, MATCH_PARENT, MATCH_PARENT)
            addBelow(progressBar, header, MATCH_PARENT, WRAP_CONTENT) {
                it.topMargin = dpToPixels(context, -6.0f).toInt()
            }
            addAtBottom(hintView, MATCH_PARENT, WRAP_CONTENT)

            if (SDK_INT < LOLLIPOP) {
                addBelow(ShadowView(context), tbar, MATCH_PARENT, WRAP_CONTENT)
                addBelow(ShadowView(context), header, MATCH_PARENT, WRAP_CONTENT)
            }
        }, MATCH_PARENT, MATCH_PARENT)

        listAdapter.setListView(listView)
        initToolbar()
    }

    override fun getToolbar(): Toolbar {
        return tbar
    }

    override fun onModelChange() {
        updateEmptyView()
    }

    override fun onTaskFinished(task: Task) {
        updateProgressBar()
    }

    override fun onTaskStarted(task: Task) {
        updateProgressBar()
    }

    fun setController(controller: ListHabitsController,
                      menu: ListHabitsSelectionMenu) {
        val listController = HabitCardListController(listAdapter)

        listController.setHabitListener(controller)
        listController.setSelectionListener(menu)
        listView.setController(listController)
        menu.setListController(listController)
        header.setScrollController(object : ScrollableChart.ScrollController {
            override fun onDataOffsetChanged(newDataOffset: Int) {
                listView.setDataOffset(newDataOffset)
            }
        })
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        runner.addListener(this)
        updateProgressBar()
        listAdapter.observable.addListener(this)
    }

    override fun onDetachedFromWindow() {
        listAdapter.observable.removeListener(this)
        runner.removeListener(this)
        super.onDetachedFromWindow()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        val count = getCheckmarkCount()
        header.setButtonCount(count)
        header.setMaxDataOffset(Math.max(MAX_CHECKMARK_COUNT - count, 0))
        listView.setCheckmarkCount(count)
        super.onSizeChanged(w, h, oldw, oldh)
    }

    private fun getCheckmarkCount(): Int {
        val nameWidth = getDimension(context, R.dimen.habitNameWidth)
        val labelWidth = Math.max((measuredWidth / 3).toFloat(), nameWidth)
        val buttonWidth = getDimension(context, R.dimen.checkmarkWidth)
        return Math.min(MAX_CHECKMARK_COUNT, Math.max(0, ((measuredWidth - labelWidth) / buttonWidth).toInt()))
    }

    private fun updateEmptyView() {
        llEmpty.visibility = if (listAdapter.itemCount > 0) View.GONE else View.VISIBLE
    }

    private fun updateProgressBar() {
        postDelayed({
                        val activeTaskCount = runner.activeTaskCount
                        val newVisibility = if (activeTaskCount > 0) View.VISIBLE else View.GONE
                        if (progressBar.visibility != newVisibility)
                            progressBar.visibility = newVisibility
                    }, 500)
    }

    companion object {
        val MAX_CHECKMARK_COUNT = 60
    }
}
