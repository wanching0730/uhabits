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

package org.isoron.uhabits.core.graphics

class Rect {
    var top = 0.0
    var bottom = 0.0
    var right = 0.0
    var left = 0.0

    fun set(left: Double, top: Double, right: Double, bottom: Double) {
        this.left = left
        this.right = right
        this.top = top
        this.bottom = bottom
    }

    fun inset(dx: Double, dy: Double) {
        this.left += dx
        this.right -= dx
        this.top += dy
        this.bottom -= dy
    }

    fun centerX() = (left + right) / 2
    fun centerY() = (top + bottom) / 2
    fun width() = right - left
    fun height() = bottom - top
}