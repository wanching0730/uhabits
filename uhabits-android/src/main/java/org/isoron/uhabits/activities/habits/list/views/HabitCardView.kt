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

package org.isoron.uhabits.activities.habits.list.views

import android.content.*
import android.os.*
import android.os.Build.VERSION.*
import android.os.Build.VERSION_CODES.*
import android.text.*
import android.view.*
import android.view.ViewGroup.LayoutParams.*
import android.widget.*
import org.isoron.androidbase.utils.*
import org.isoron.androidbase.utils.InterfaceUtils.*
import org.isoron.uhabits.*
import org.isoron.uhabits.activities.common.views.*
import org.isoron.uhabits.core.models.*
import org.isoron.uhabits.core.preferences.*
import org.isoron.uhabits.core.utils.*
import org.isoron.uhabits.utils.*

class HabitCardView(
        context: Context,
        preferences: Preferences
) : FrameLayout(context),
    ModelObservable.Listener {

    var buttonCount
        get() = checkmarkPanel.buttonCount
        set(value) {
            checkmarkPanel.buttonCount = value
            numberPanel.buttonCount = value
        }

    var dataOffset = 0
        set(value) {
            field = value
            checkmarkPanel.dataOffset = value
            numberPanel.dataOffset = value
        }

    var habit: Habit? = null
        set(newHabit) {
            if (isAttachedToWindow) {
                field?.observable?.removeListener(this)
                newHabit?.observable?.addListener(this)
            }
            field = newHabit
            if (newHabit != null) copyAttributesFrom(newHabit)
        }

    var score
        get() = scoreRing.percentage.toDouble()
        set(value) {
            scoreRing.percentage = value.toFloat()
            scoreRing.precision = 1.0f / 16
        }

    var unit
        get() = numberPanel.units
        set(value) {
            numberPanel.units = value
        }

    var values
        get() = checkmarkPanel.values
        set(values) {
            checkmarkPanel.values = values
            numberPanel.values = values.map { it / 1000.0 }.toDoubleArray()
        }

    var threshold: Double
        get() = numberPanel.threshold
        set(value) {
            numberPanel.threshold = value
        }

    var onToggle: (Habit, Long) -> Unit = { _, _ -> }
    var onEdit: (Habit, Long) -> Unit = { _, _ -> }
    var onInvalidToggle: () -> Unit = {}
    var onInvalidEdit: () -> Unit = {}

    private var checkmarkPanel: CheckmarkPanelView
    private var numberPanel: NumberPanelView
    private var innerFrame: LinearLayout
    private var label: TextView
    private var scoreRing: RingView

    init {
        scoreRing = RingView(context).apply {
            val thickness = dpToPixels(context, 3f)
            val margin = dpToPixels(context, 8f).toInt()
            val ringSize = dpToPixels(context, 15f).toInt()
            layoutParams = LinearLayout.LayoutParams(ringSize, ringSize).apply {
                setMargins(margin, 0, margin, 0)
                gravity = Gravity.CENTER
            }
            setThickness(thickness)
        }

        label = TextView(context).apply {
            maxLines = 2
            ellipsize = TextUtils.TruncateAt.END
            layoutParams = LinearLayout.LayoutParams(0, WRAP_CONTENT, 1f)
            if (SDK_INT >= M) breakStrategy = Layout.BREAK_STRATEGY_BALANCED
        }

        checkmarkPanel = CheckmarkPanelView(context, preferences).apply {
            onToggle = { t ->
                triggerRipple(t)
                habit?.let { onToggle(it, t) }
            }
            onInvalidToggle = { this@HabitCardView.onInvalidToggle() }
        }

        numberPanel = NumberPanelView(context, preferences).apply {
            visibility = GONE
            onEdit = { t ->
                triggerRipple(t)
                habit?.let { onEdit(it, t) }
            }
            onInvalidEdit = { this@HabitCardView.onInvalidEdit() }
        }

        innerFrame = LinearLayout(context).apply {
            gravity = Gravity.CENTER_VERTICAL
            orientation = LinearLayout.HORIZONTAL
            layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
            if (SDK_INT >= LOLLIPOP) elevation = dpToPixels(context, 1f)

            addView(scoreRing)
            addView(label)
            addView(checkmarkPanel)
            addView(numberPanel)

            setOnTouchListener { v, event ->
                if (SDK_INT >= LOLLIPOP) v.background.setHotspot(event.x,
                                                                 event.y)
                false
            }
        }

        clipToPadding = false
        layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT)
        val margin = dpToPixels(context, 3f).toInt()
        setPadding(margin, 0, margin, margin)
        addView(innerFrame)
    }

    override fun onModelChange() {
        Handler(Looper.getMainLooper()).post {
            habit?.let { copyAttributesFrom(it) }
        }
    }

    override fun setSelected(isSelected: Boolean) {
        super.setSelected(isSelected)
        updateBackground(isSelected)
    }

    fun triggerRipple(timestamp: Long) {
        val today = DateUtils.getStartOfToday()
        val day = DateUtils.millisecondsInOneDay
        val offset = ((today - timestamp) / day).toInt() - dataOffset
        val button = checkmarkPanel.buttons[offset]
        val y = button.height / 2.0f
        val x = checkmarkPanel.x + button.x + (button.width / 2).toFloat()
        triggerRipple(x, y)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        habit?.observable?.addListener(this)
    }

    override fun onDetachedFromWindow() {
        habit?.observable?.removeListener(this)
        super.onDetachedFromWindow()
    }

    private fun copyAttributesFrom(h: Habit) {

        fun getActiveColor(habit: Habit): Int {
            val res = StyledResources(context)
            return when (habit.isArchived) {
                true -> res.getColor(R.attr.mediumContrastTextColor)
                false -> PaletteUtils.getColor(context, habit.color)
            }
        }

        val c = getActiveColor(h)
        label.apply {
            text = h.name
            setTextColor(c)
        }
        scoreRing.apply {
            color = c
        }
        checkmarkPanel.apply {
            color = c
            visibility = when (h.isNumerical) {
                true -> View.GONE
                false -> View.VISIBLE
            }
        }
        numberPanel.apply {
            color = c
            units = h.unit
            threshold = h.targetValue
            visibility = when (h.isNumerical) {
                true -> View.VISIBLE
                false -> View.GONE
            }
        }
    }

    private fun triggerRipple(x: Float, y: Float) {
        val background = innerFrame.background
        if (SDK_INT >= LOLLIPOP) background.setHotspot(x, y)
        background.state = intArrayOf(android.R.attr.state_pressed,
                                      android.R.attr.state_enabled)
        Handler().postDelayed({ background.state = intArrayOf() }, 25)
    }

    private fun updateBackground(isSelected: Boolean) {
        if (SDK_INT < LOLLIPOP) {
            val res = StyledResources(context)
            val background = when (isSelected) {
                true -> res.getDrawable(R.attr.selectedBackground)
                false -> res.getDrawable(R.attr.cardBackground)
            }
            innerFrame.setBackgroundDrawable(background)
            return
        }

        val background = when (isSelected) {
            true -> R.drawable.selected_box
            false -> R.drawable.ripple
        }
        innerFrame.setBackgroundResource(background)
    }
}
