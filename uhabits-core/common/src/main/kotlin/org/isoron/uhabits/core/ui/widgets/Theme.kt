/*
 * Copyright (C) 2015-2017 Álinson Santos Xavier <isoron@gmail.com>
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

package org.isoron.uhabits.core.ui.widgets

import org.isoron.uhabits.core.graphics.*

interface Theme {
    val cardBackgroundColor: Color
    val highContrastTextColor: Color
    val mediumContrastTextColor: Color
    val lowContrastTextColor: Color
    val smallTextSize: Double
}

object LIGHT_THEME : Theme {
    override val cardBackgroundColor = Color(250, 250, 250)
    override val highContrastTextColor = Color(66, 66, 66)
    override val mediumContrastTextColor = Color(158, 158, 158)
    override val lowContrastTextColor = Color(224, 224, 224)
    override val smallTextSize = 14.0
}