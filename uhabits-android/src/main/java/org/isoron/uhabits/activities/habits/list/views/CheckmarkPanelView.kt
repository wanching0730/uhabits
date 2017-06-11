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
import org.isoron.uhabits.core.models.Checkmark.*
import org.isoron.uhabits.core.utils.*
import org.isoron.uhabits.utils.AttributeSetUtils.*
import org.isoron.uhabits.utils.PaletteUtils.*
import java.lang.Math.*
import java.util.*

class CheckmarkPanelView(
        context: Context
) : ButtonPanelView<CheckmarkButtonView>(context) {

    var values = IntArray(0)
        set(values) {
            field = values
            setupButtons()
        }

    var color = 0
        set(value) {
            field = value
            setupButtons()
        }

    var onInvalidToggle: () -> Unit = {}
        set(value) {
            field = value
            setupButtons()
        }

    var onToggle: (Long) -> Unit = {}
        set(value) {
            field = value
            setupButtons()
        }

    constructor(ctx: Context, attrs: AttributeSet) : this(ctx) {
        val paletteColor = getIntAttribute(ctx, attrs, "color", 0)
        color = getAndroidTestColor(paletteColor)
        buttonCount = getIntAttribute(ctx, attrs, "button_count", 5)
        if (isInEditMode) initEditMode()
    }

    private fun initEditMode() {
        val values = IntArray(buttonCount)
        values.map { min(2, Random().nextInt(4)) }
        this.values = values
    }

    override fun createButton() = CheckmarkButtonView(context)

    @Synchronized
    override fun setupButtons() {
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
