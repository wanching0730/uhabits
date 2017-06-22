package org.isoron.uhabits.electron.screens.habits.list

import kotlinx.html.*
import kotlinx.html.js.*
import org.isoron.uhabits.core.ui.screens.habits.list.*
import react.*
import react.dom.*
import kotlin.browser.*

@JsName("launch")
fun launch() {
    ReactDOM.render(document.body) { ListHabitsScreen {} }
}

class ListHabitsScreen
    : ReactDOMComponent<ListHabitsScreen.Props, ListHabitsScreen.State>(),
      ListHabitsMenuBehavior.Screen {

    var behavior = ListHabitsMenuBehavior(this, MockAdapter(), Preferences(), ThemeSwitcher())

    override fun applyTheme() {

    }

    override fun showAboutScreen() {
        window.alert("Showing about screen")
    }

    override fun showCreateHabitScreen() {
    }

    override fun showFAQScreen() {
        window.alert("Showing FAQ")
    }

    override fun showSettingsScreen() {
    }

    companion object : ReactComponentSpec<ListHabitsScreen, Props, State>

    init {
        state = State()
    }

    override fun ReactDOMBuilder.render() {
        div {
            button {
                + "About"
                onClickFunction = { behavior.onViewAbout() }
            }
            button {
                + "FAQ"
                onClickFunction = { behavior.onViewFAQ() }
            }
        }
    }

    class State : RState
    class Props : RProps()
}