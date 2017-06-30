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

import platform.*

/**
 * Represents how strong a habit is at a certain date.
 */
data class Score(
        /**
         * Timestamp of the day to which this score applies. Time of day should be
         * midnight (UTC).
         */
        val timestamp: Long,
        /**
         * Value of the score.
         */
        val value: Double) {

    fun compareNewer(other: Score): Int {
        return timestamp.compareTo(other.timestamp)
    }

    companion object {
        /**
         * Given the frequency of the habit, the previous score, and the value of
         * the current checkmark, computes the current score for the habit.
         *
         * The frequency of the habit is the number of repetitions divided by the
         * length of the interval. For example, a habit that should be repeated 3
         * times in 8 days has frequency 3.0 / 8.0 = 0.375.

         * @param frequency the frequency of the habit
         * @param previousScore the previous score of the habit
         * @param checkmarkValue the value of the current checkmark
         * @return the current score
         */
        fun compute(frequency: Double,
                    previousScore: Double,
                    checkmarkValue: Double): Double {
            val multiplier = 0.5.pow(frequency / 13.0)
            var score = previousScore * multiplier
            score += checkmarkValue * (1 - multiplier)
            return score
        }
    }
}
