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

package org.isoron.uhabits.electron.screens.habits.list

import kotlinx.html.*
import org.isoron.uhabits.core.graphics.*
import org.isoron.uhabits.electron.screens.habits.list.views.*
import react.*
import react.dom.*
import kotlin.browser.*
import kotlin.js.*

@JsName("launch")
fun launch() {
    ReactDOM.render(document.body) { ListHabitsScreen {} }
}

class ListHabitsScreen
    : ReactDOMComponent<ListHabitsScreen.Props, ListHabitsScreen.State>() {

    private val canvasId = Math.random().toString()

    init {
        state = State()
    }

    override fun ReactDOMBuilder.render() {
        div {
            ToolbarView { }
            HabitCardView { color = Color(233, 30, 99) }
            HabitCardView { color = Color(46, 125, 50) }
            HabitCardView { color = Color(69, 39, 160) }
        }
    }

    class State : RState
    class Props : RProps()
    companion object : ReactComponentSpec<ListHabitsScreen, Props, State>
}