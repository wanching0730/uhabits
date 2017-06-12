/*
 * Copyright (C) 2017 Álinson Santos Xavier <isoron@gmail.com>
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
import android.view.*
import android.view.ViewGroup.LayoutParams.*
import android.widget.*
import org.isoron.androidbase.activities.*
import org.isoron.androidbase.utils.*
import org.isoron.uhabits.*

class EmptyListView(context: Context) : LinearLayout(context) {

    init {
        val sr = StyledResources(context)

        visibility = BaseRootView.GONE
        gravity = Gravity.CENTER
        orientation = VERTICAL

        addView(TextView(context).apply {
            text = resources.getString(R.string.fa_star_half_o)
            typeface = InterfaceUtils.getFontAwesome(context)
            textSize = InterfaceUtils.spToPixels(context, 40.0f)
            gravity = Gravity.CENTER
            setTextColor(sr.getColor(R.attr.mediumContrastTextColor))
        }, MATCH_PARENT, WRAP_CONTENT)

        addView(TextView(context).apply {
            text = resources.getString(R.string.no_habits_found)
            gravity = Gravity.CENTER
            setPadding(0, InterfaceUtils.dpToPixels(context, 20.0f).toInt(), 0, 0)
            setTextColor(sr.getColor(R.attr.mediumContrastTextColor))
        }, MATCH_PARENT, WRAP_CONTENT)
    }
}