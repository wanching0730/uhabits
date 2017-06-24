package org.isoron.uhabits.electron.screens.habits.list.views

import kotlinx.html.*
import org.isoron.uhabits.core.graphics.*
import org.isoron.uhabits.core.widgets.*
import org.isoron.uhabits.electron.graphics.*
import org.w3c.dom.*
import react.*
import react.dom.*
import kotlin.browser.*
import kotlin.js.*

class RingView : ReactDOMComponent<RingView.Props, RingView.State>() {
    private val canvasId = Math.random().toString()

    init {
        state = State()
    }

    override fun ReactDOMBuilder.render() {
        canvas {
            id = canvasId
            width = props.size
            height = props.size
        }
    }

    override fun componentDidMount() {
        val canvas = document.getElementById(canvasId) as HTMLCanvasElement
        val ctx = canvas.getContext("2d") as CanvasRenderingContext2D
        val ring = RingWidget()
        ring.thickness = 3.0
        ring.percentage = 0.42
        ring.primaryColor = props.color
        ring.draw(HTMLCanvas(canvas, ctx))
    }

    class State : RState
    class Props(var size: String,
                var color: Color) : RProps()
    companion object : ReactComponentSpec<RingView, Props, State>
}