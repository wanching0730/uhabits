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

package org.isoron.uhabits.activities.habits.list

import org.isoron.androidbase.activities.*
import org.isoron.uhabits.*
import org.isoron.uhabits.activities.habits.list.views.*
import org.isoron.uhabits.core.models.*
import org.isoron.uhabits.core.ui.screens.habits.list.*
import javax.inject.*

@ActivityScope
class ListHabitsController @Inject constructor(
        private val behavior: ListHabitsBehavior,
        private val screen: ListHabitsScreen
) : HabitCardListController.HabitListener {

    override fun onHabitReorder(from: Habit, to: Habit) {
        behavior.onReorderHabit(from, to)
    }

    override fun onEdit(h: Habit, t: Long) = behavior.onEdit(h, t)
    override fun onToggle(h: Habit, t: Long) = behavior.onToggle(h, t)
    override fun onInvalidEdit() = screen.showMessage(R.string.long_press_to_edit)
    override fun onInvalidToggle() = screen.showMessage(R.string.long_press_to_toggle)
    override fun onHabitClick(h: Habit) = behavior.onClickHabit(h)
}
