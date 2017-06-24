package org.isoron.uhabits.electron.screens.habits.list

import kotlinx.html.*
import org.isoron.uhabits.core.widgets.*
import org.isoron.uhabits.electron.graphics.*
import org.w3c.dom.*
import react.*
import react.dom.*
import kotlin.browser.*
import kotlin.js.*

@JsName("launch")
fun launch() {
    ReactDOM.render(document.body) { ListHabitsScreen {} }
}

class State : RState
class Props : RProps()

class ListHabitsScreen : ReactDOMComponent<Props, State>() {
    companion object : ReactComponentSpec<ListHabitsScreen, Props, State>

    private val canvasId = Math.random().toString()

    init {
        state = State()
    }

    override fun ReactDOMBuilder.render() {
        canvas {
            id = canvasId
            width = "200px"
            height = "200px"
        }
    }

    override fun componentDidMount() {
        val canvas = document.getElementById(canvasId) as HTMLCanvasElement
        val ctx = canvas.getContext("2d") as CanvasRenderingContext2D
        val ring = RingView()
        ring.thickness = 10.0
        ring.percentage = 0.42
        ring.draw(HTMLCanvas(canvas, ctx))
    }
}