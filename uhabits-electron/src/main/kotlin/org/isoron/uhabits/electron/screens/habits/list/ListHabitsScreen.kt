package org.isoron.uhabits.electron.screens.habits.list

import kotlinx.html.*
import org.isoron.uhabits.core.models.*
import react.*
import react.dom.*
import kotlin.browser.*

@JsName("launch")
fun launch() {
    ReactDOM.render(document.body) { ListHabitsScreen {} }
}

class State : RState
class Props : RProps()

class ListHabitsScreen : ReactDOMComponent<Props, State>() {
    companion object : ReactComponentSpec<ListHabitsScreen, Props, State>

    init {
        state = State()
        val rep = Repetition(100, 200)
    }

    override fun ReactDOMBuilder.render() {
        div {
            button {
                +"About"
            }
            button {
                +"FAQ"
            }
            +(Repetition(100, 200)).toString()
        }
    }
}