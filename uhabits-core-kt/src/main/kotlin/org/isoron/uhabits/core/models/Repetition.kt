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

package org.isoron.uhabits.core.models

/**
 * A repetition indicates that the user has performed a certain habit at a
 * certain date.
 */
data class Repetition(
        /**
         * The timestamp corresponds to the days this repetition occurred. Time
         * of day must be midnight (UTC).
         */
        val timestamp: Long,
        /**
         * For boolean habits, this always equals Checkmark.CHECKED_EXPLICITLY.
         * For numerical habits, this number is stored in thousandths. That
         * is, if the user enters value 1.50 on the app, it is here stored as
         * 1500.
         */
        val value: Int)
