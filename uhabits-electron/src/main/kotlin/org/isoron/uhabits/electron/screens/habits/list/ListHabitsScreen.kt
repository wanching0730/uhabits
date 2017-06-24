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