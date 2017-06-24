package org.isoron.uhabits.core.graphics

interface Canvas {
    fun drawWedge(rect: Rect,
                  startAngle: Double,
                  endAngle: Double,
                  paint: Paint)

    fun drawText(text: String, x: Double, y: Double, paint: Paint)
    fun width(): Double
    fun height(): Double
}