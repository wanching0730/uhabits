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

package org.isoron.uhabits.electron.screens.habits.list.views

import kotlinx.html.*
import react.*
import react.dom.*

class ToolbarView : ReactDOMComponent<ToolbarView.Props, ToolbarView.State>() {

    init {
        state = State()
    }

    override fun ReactDOMBuilder.render() {
        div {
            div(classes = "mdc-toolbar mdc-toolbar--fixed") {
                div(classes = "mdc-toolbar__row") {
                    section(classes = "mdc-toolbar__section mdc-toolbar__section--align-start") {
                        span(classes = "mdc-toolbar__title") {
                            +"Habits"
                        }
                    }
                    section(classes = "mdc-toolbar__section mdc-toolbar__section--align-end") {
                        a(href = "#", classes = "material-icons mdc-toolbar__icon") { +"filter_list" }
                        a(href = "#", classes = "material-icons mdc-toolbar__icon") { +"add" }
                        a(href = "#", classes = "material-icons mdc-toolbar__icon") { +"more_vert" }
                    }
                }
            }
            div(classes = "mdc-toolbar-fixed-adjust") {}
        }
    }

    class State : RState
    class Props : RProps()
    companion object : ReactComponentSpec<ToolbarView, Props, State>
}