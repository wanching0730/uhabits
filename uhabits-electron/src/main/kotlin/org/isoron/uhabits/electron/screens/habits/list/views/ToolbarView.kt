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