/*
 * Copyright (C) 2015-2017 Álinson Santos Xavier <isoron@gmail.com>
 *
 * This file is part of Loop Habit Tracker.
 *
 * Loop Habit Tracker is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 *
 * Loop Habit Tracker is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for
 * more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program. If not, see <http://www.gnu.org/licenses/>.
 */

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

