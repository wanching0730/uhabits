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
import org.isoron.uhabits.core.tasks.*
import org.isoron.uhabits.core.ui.screens.habits.list.*
import org.isoron.uhabits.tasks.*
import java.io.*
import javax.inject.*

@ActivityScope
class ListHabitsController @Inject constructor(
        private val behavior: ListHabitsBehavior,
        private val adapter: HabitCardListAdapter,
        private val screen: ListHabitsScreen,
        private val taskRunner: TaskRunner,
        private val importTaskFactory: ImportDataTaskFactory,
        private val exportDBFactory: ExportDBTaskFactory
) : HabitCardListController.HabitListener {

    fun onExportDB() {
        taskRunner.execute(exportDBFactory.create { filename ->
            if (filename != null) screen.showSendFileScreen(filename)
            else screen.showMessage(R.string.could_not_export)
        })
    }

    fun onImportData(file: File, onFinished: () -> Unit) {
        taskRunner.execute(importTaskFactory.create(file) { result ->
            if (result == ImportDataTask.SUCCESS) {
                adapter.refresh()
                screen.showMessage(R.string.habits_imported)
            } else if (result == ImportDataTask.NOT_RECOGNIZED) {
                screen.showMessage(R.string.file_not_recognized)
            } else {
                screen.showMessage(R.string.could_not_import)
            }
            onFinished()
        })
    }

    override fun onHabitReorder(from: Habit, to: Habit) {
        behavior.onReorderHabit(from, to)
    }

    fun onStartup() = behavior.onStartup()
    fun onRepairDB() = behavior.onRepairDB()
    fun onExportCSV() = behavior.onExportCSV()
    fun onSendBugReport() = behavior.onSendBugReport()
    override fun onEdit(h: Habit, t: Long) = behavior.onEdit(h, t)
    override fun onToggle(h: Habit, t: Long) = behavior.onToggle(h, t)
    override fun onInvalidEdit() = screen.showMessage(R.string.long_press_to_edit)
    override fun onInvalidToggle() = screen.showMessage(R.string.long_press_to_toggle)
    override fun onHabitClick(h: Habit) = behavior.onClickHabit(h)
}
