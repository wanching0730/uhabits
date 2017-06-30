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

package org.isoron.uhabits.core.models

import org.isoron.uhabits.core.date.*

data class Streak(val start: Long, val end: Long) {
    fun compareLonger(other: Streak): Int {
        if (this.length != other.length)
            return this.length.compareTo(other.length)
        return this.end.compareTo(other.end)
    }

    fun compareNewer(other: Streak): Int {
        return this.end.compareTo(other.end)
    }

    val length: Long
        get() = (end - start) / MILLISECONDS_IN_ONE_DAY + 1
}
