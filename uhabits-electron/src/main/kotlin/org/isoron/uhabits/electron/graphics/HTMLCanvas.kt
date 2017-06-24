package org.isoron.uhabits.electron.graphics

import org.isoron.uhabits.core.graphics.*
import org.w3c.dom.*
import kotlin.js.*

class HTMLCanvas(
        private val canvas: HTMLCanvasElement,
        private val context: CanvasRenderingContext2D
) : Canvas {

    override fun height() = canvas.height.toDouble()
    override fun width() = canvas.width.toDouble()

    override fun drawWedge(rect: Rect,
                           startAngle: Double,
                           endAngle: Double,
                           paint: Paint) {
        val cx = rect.centerX()
        val cy = rect.centerY()
        context.fillStyle = paint.color.toJsString()
        context.beginPath()
        context.moveTo(cx, cy)
        val start = startAngle / 180 * Math.PI
        val end = endAngle / 180 * Math.PI
        context.ellipse(x = cx,
                        y = cy,
                        radiusX = rect.width() / 2,
                        radiusY = rect.height() / 2,
                        rotation = start,
                        startAngle = 0.0,
                        endAngle = end)
        context.moveTo(cx, cy)
        context.fill()
    }

    override fun drawText(text: String, x: Double, y: Double, paint: Paint) {
    }
}

