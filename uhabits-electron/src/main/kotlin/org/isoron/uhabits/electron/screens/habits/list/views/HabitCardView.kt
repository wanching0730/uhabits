package org.isoron.uhabits.electron.screens.habits.list.views

import kotlinx.html.*
import org.isoron.uhabits.core.graphics.*
import react.*
import react.dom.*

class HabitCardView : ReactDOMComponent<HabitCardView.Props, HabitCardView.State>() {
    init {
        state = State()
    }

    override fun ReactDOMBuilder.render() {
        div(classes = "card") {
            RingView {
                size = "15px"
                color = props.color
            }
            span(classes = "title") {
                unsafe {
                    raw("<span style='color: ${props.color.toJsString()}'>Habit</span>")
                }
            }
        }
    }

    class State : RState
    class Props(var color: Color) : RProps()
    companion object : ReactComponentSpec<HabitCardView, Props, State>
}