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

/**
 * Indicates that there was a repetition at the timestamp.
 */
const val CHECKED_EXPLICITLY = 2

/**
 * Indicates that there was no repetition at the timestamp, but one was
 * not expected in any case, due to the frequency of the habit.
 */
const val CHECKED_IMPLICITLY = 1

/**
 * Indicates that there was no repetition at the timestamp, even though
 * a repetition was expected.
 */
const val UNCHECKED = 0

/**
 * A Checkmark represents the completion status of the habit for a given day.
 *
 * While repetitions simply record that the habit was performed at a given date,
 * a checkmark provides more information, such as whether a repetition was
 * expected at that day or not.
 *
 * Checkmarks are computed automatically from the list of repetitions.
 */
data class Checkmark(
        val timestamp: Long,
        /**
         * The value of the checkmark. For boolean habits, this equals
         * either UNCHECKED, CHECKED_EXPLICITLY, or CHECKED_IMPLICITLY.
         * For numerical habits, this number is stored in thousandths.
         * That is, if the user enters value 1.50 on the app, it is
         * stored as 1500.
         */
        val value: Int) {

    fun compareNewer(other: Checkmark): Int {
        return this.timestamp.compareTo(other.timestamp)
    }
}
