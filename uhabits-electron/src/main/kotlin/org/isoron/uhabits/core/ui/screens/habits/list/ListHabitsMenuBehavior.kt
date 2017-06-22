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

package org.isoron.uhabits.core.ui.screens.habits.list

class Preferences {
    var showCompleted = false
    var showArchived = false
}

enum class HabitListOrder {
    BY_POSITION, BY_SCORE, BY_NAME, BY_COLOR
}

class ThemeSwitcher {
    fun toggleNightMode() {
    }
}

class MockAdapter : ListHabitsMenuBehavior.Adapter {
    override fun refresh() {
    }

    override fun setFilter(build: HabitMatcher) {
    }

    override fun setOrder(order: HabitListOrder) {
    }
}

class HabitMatcher

class ListHabitsMenuBehavior(
        private val screen: ListHabitsMenuBehavior.Screen,
        private val adapter: ListHabitsMenuBehavior.Adapter,
        private val preferences: Preferences,
        private val themeSwitcher: ThemeSwitcher
) {

    private var showCompleted: Boolean = false

    private var showArchived: Boolean = false

    init {

        showCompleted = preferences.showCompleted
        showArchived = preferences.showArchived
    }

    fun onCreateHabit() {
        screen.showCreateHabitScreen()
    }

    fun onViewFAQ() {
        screen.showFAQScreen()
    }

    fun onViewAbout() {
        screen.showAboutScreen()
    }

    fun onViewSettings() {
        screen.showSettingsScreen()
    }

    fun onToggleShowArchived() {
        showArchived = !showArchived
        preferences.showArchived = showArchived
        updateAdapterFilter()
    }

    private fun updateAdapterFilter() {
    }

    fun onToggleShowCompleted() {
        showCompleted = !showCompleted
        preferences.showCompleted = showCompleted
        updateAdapterFilter()
    }

    fun onSortByColor() {
        adapter.setOrder(HabitListOrder.BY_COLOR)
    }

    fun onSortByManually() {
        adapter.setOrder(HabitListOrder.BY_POSITION)
    }

    fun onSortByScore() {
        adapter.setOrder(HabitListOrder.BY_SCORE)
    }

    fun onSortByName() {
        adapter.setOrder(HabitListOrder.BY_NAME)
    }

    fun onToggleNightMode() {
        themeSwitcher.toggleNightMode()
        screen.applyTheme()
    }

    interface Adapter {
        fun refresh()

        fun setFilter(build: HabitMatcher)

        fun setOrder(order: HabitListOrder)
    }

    interface Screen {
        fun applyTheme()

        fun showAboutScreen()

        fun showCreateHabitScreen()

        fun showFAQScreen()

        fun showSettingsScreen()
    }
}
