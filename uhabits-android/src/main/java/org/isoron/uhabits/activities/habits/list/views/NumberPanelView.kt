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
import org.isoron.uhabits.core.preferences.*
import org.isoron.uhabits.core.utils.*
import org.isoron.uhabits.utils.AttributeSetUtils.*
import org.isoron.uhabits.utils.PaletteUtils.*
import java.util.*

class NumberPanelView(context: Context) : LinearLayout(context), Preferences.Listener {

    var values = DoubleArray(0)
        set(values) {
            field = values
            setupButtons()
        }

    var threshold = 0.0
        set(value) {
            field = value
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

    var units = ""
        set(value) {
            field = value
            setupButtons()
        }

    var dataOffset = 0
        set(value) {
            field = value
            setupButtons()
        }

    var onInvalid: () -> Unit = {}
        set(value) {
            field = value
            setupButtons()
        }

    var onEdit: (Long) -> Unit = {}
        set(value) {
            field = value
            setupButtons()
        }

    var preferences: Preferences? = null
    var buttons = mutableListOf<NumberButtonView>()

    init {
        if (context is HabitsActivity) {
            preferences = context.appComponent.preferences
        }
    }

    constructor(ctx: Context, attrs: AttributeSet) : this(ctx) {
        val paletteColor = getIntAttribute(ctx, attrs, "color", 0)
        color = getAndroidTestColor(paletteColor)
        buttonCount = getIntAttribute(ctx, attrs, "button_count", 5)
        threshold = getIntAttribute(ctx, attrs, "threshold", 1).toDouble()
        units = getAttribute(ctx, attrs, "unit", "min") ?: ""

        if (isInEditMode) initEditMode()
    }

    fun initEditMode() {
        val values = DoubleArray(buttonCount)
        for (i in 0..buttonCount - 1)
            values[i] = Random().nextDouble() * (threshold * 3)
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
        repeat(buttonCount) { buttons.add(NumberButtonView(context)) }

        removeAllViews()
        if (reverse) buttons.reversed().forEach { addView(it) }
        else buttons.forEach { addView(it) }
        setupButtons()
        requestLayout()
    }

    @Synchronized
    private fun setupButtons() {
        val day = DateUtils.millisecondsInOneDay
        val today = DateUtils.getStartOfToday()

        buttons.forEachIndexed { index, button ->
            val timestamp = today - index * day
            button.value = when {
                index + dataOffset < values.size -> values[index + dataOffset]
                else -> 0.0
            }
            button.color = color
            button.threshold = threshold
            button.units = units
            button.onEdit = { onEdit(timestamp) }
            button.onInvalidEdit = { onInvalid() }
        }
    }
}
