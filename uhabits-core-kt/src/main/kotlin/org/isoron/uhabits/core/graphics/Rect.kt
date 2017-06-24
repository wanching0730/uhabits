package org.isoron.uhabits.core.graphics

class Rect {
    var top = 0.0
    var bottom = 0.0
    var right = 0.0
    var left = 0.0

    fun set(left: Double, top: Double, right: Double, bottom: Double) {
        this.left = left
        this.right = right
        this.top = top
        this.bottom = bottom
    }

    fun inset(dx: Double, dy: Double) {
        this.left += dx
        this.right -= dx
        this.top += dy
        this.bottom -= dy
    }

    fun centerX() = (left + right) / 2
    fun centerY() = (top + bottom) / 2
    fun width() = right - left
    fun height() = bottom - top
}