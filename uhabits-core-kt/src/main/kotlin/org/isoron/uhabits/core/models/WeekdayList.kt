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

data class WeekdayList(private val packedList: Int) {

    fun toArray(): BooleanArray {
        val weekdays = BooleanArray(7)
        var current = 1
        for (i in 0..6) {
            if (packedList and current != 0) weekdays[i] = true
            current = current shl 1
        }
        return weekdays
    }

    fun toInteger(): Int = packedList
    fun isEmpty() = (packedList == 0)

    companion object {
        val EVERY_DAY = WeekdayList(127)

        fun fromArray(weekdays: BooleanArray): WeekdayList {
            var current = 1
            var packedList = 0
            for (i in 0..6) {
                if (weekdays[i]) packedList = packedList or current
                current = current shl 1
            }
            return WeekdayList(packedList)
        }
    }
}
