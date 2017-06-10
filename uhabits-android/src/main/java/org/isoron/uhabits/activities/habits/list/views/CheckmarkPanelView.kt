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
import android.util.*
import android.view.View.MeasureSpec.*
import android.widget.*
import org.isoron.androidbase.utils.InterfaceUtils.*
import org.isoron.uhabits.*
import org.isoron.uhabits.activities.*
import org.isoron.uhabits.core.models.Checkmark.*
import org.isoron.uhabits.core.preferences.*
import org.isoron.uhabits.core.utils.*
import org.isoron.uhabits.utils.AttributeSetUtils.*
import org.isoron.uhabits.utils.PaletteUtils.*
import java.lang.Math.*
import java.util.*

class CheckmarkPanelView(
        context: Context
) : LinearLayout(context),
    Preferences.Listener {

    var values = IntArray(0)
        set(values) {
            field = values
            setupButtons()
        }

    var buttonCount = 0
        set(value) {
            field = value
            inflateButtons()
        }

    var color = 0
        set(value) {
            field = value
            setupButtons()
        }

    var dataOffset = 0
        set(value) {
            field = value
            setupButtons()
        }

    var onToggle: (Long) -> Unit = {}
        set(value) {
            field = value
            setupButtons()
        }

    var onInvalidToggle: () -> Unit = {}
        set(value) {
            field = value
            setupButtons()
        }

    var preferences: Preferences? = null
    var buttons = mutableListOf<CheckmarkButtonView>()

    init {
        if (context is HabitsActivity) {
            preferences = context.appComponent.preferences
        }
    }

    constructor(ctx: Context, attrs: AttributeSet) : this(ctx) {
        val paletteColor = getIntAttribute(ctx, attrs, "color", 0)
        this.color = getAndroidTestColor(paletteColor)
        buttonCount = getIntAttribute(ctx, attrs, "button_count", 5)

        if (isInEditMode) initEditMode()
    }

    private fun initEditMode() {
        val values = IntArray(buttonCount)
        values.map { min(2, Random().nextInt(4)) }
        this.values = values
    }

    override fun onCheckmarkSequenceChanged() {
        inflateButtons()
    }

    public override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        preferences?.addListener(this)
    }

    public override fun onDetachedFromWindow() {
        preferences?.removeListener(this)
        super.onDetachedFromWindow()
    }

    override fun onMeasure(widthSpec: Int, heightSpec: Int) {
        val buttonWidth = getDimension(context, R.dimen.checkmarkWidth)
        val buttonHeight = getDimension(context, R.dimen.checkmarkHeight)
        val width = buttonWidth * buttonCount
        super.onMeasure(makeMeasureSpec(width.toInt(), EXACTLY),
                        makeMeasureSpec(buttonHeight.toInt(), EXACTLY))
    }

    @Synchronized
    private fun inflateButtons() {
        val reverse = preferences?.isCheckmarkSequenceReversed ?: false

        buttons.clear()
        repeat(buttonCount) { buttons.add(CheckmarkButtonView(context)) }

        removeAllViews()
        if (reverse) buttons.reversed().forEach { addView(it) }
        else buttons.forEach { addView(it) }
        setupButtons()
        requestLayout()
    }

    @Synchronized
    private fun setupButtons() {
        val today = DateUtils.getStartOfToday()
        val day = DateUtils.millisecondsInOneDay

        buttons.forEachIndexed { index, button ->
            val timestamp = today - index * day
            button.value = when {
                index + dataOffset < values.size -> values[index + dataOffset]
                else -> UNCHECKED
            }
            button.color = color
            button.onToggle = { onToggle(timestamp) }
            button.onInvalidToggle = { onInvalidToggle() }
        }
    }
}
