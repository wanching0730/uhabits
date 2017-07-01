/*
 * Copyright (C) 2015-$today-year Álinson Santos Xavier <isoron@gmail.com>
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

package org.isoron.uhabits.activities

import android.content.*
import android.graphics.*
import android.text.*
import org.isoron.uhabits.core.graphics.*
import org.isoron.uhabits.core.graphics.Canvas
import org.isoron.uhabits.core.graphics.Color
import org.isoron.uhabits.core.graphics.Paint
import org.isoron.uhabits.core.graphics.Rect

fun Color.toInt(): Int {
    return android.graphics.Color.rgb(this.red, this.green, this.blue)
}

fun Int.toColor(): Color {
    return Color(android.graphics.Color.red(this),
                 android.graphics.Color.green(this),
                 android.graphics.Color.blue(this))
}

fun Rect.copyTo(rectf: RectF, density: Double) {
    rectf.set((this.left * density).toFloat(),
              (this.top * density).toFloat(),
              (this.right * density).toFloat(),
              (this.bottom * density).toFloat())
}

class AndroidCanvas(var context: Context) : Canvas {
    val recti = android.graphics.Rect()

    val rectf = RectF()
    lateinit var canvas: android.graphics.Canvas
    val density = context.resources.displayMetrics.density.toDouble()
    var pCanvas: TextPaint = TextPaint().apply {
        isAntiAlias = true
    }

    override fun drawWedge(rect: Rect,
                           startAngle: Double,
                           endAngle: Double,
                           paint: Paint) {
        pCanvas.color = paint.color.toInt()
        rect.copyTo(rectf, density)
        canvas.drawArc(rectf, startAngle.toFloat(), endAngle.toFloat(), true,
                       pCanvas)
    }

    override fun drawText(text: String, x: Double, y: Double, paint: Paint) {
        pCanvas.textSize = dpToPixels(paint.textSize)
        pCanvas.color = paint.color.toInt()
        pCanvas.textAlign = android.graphics.Paint.Align.LEFT
        pCanvas.getTextBounds(text, 0, text.length, recti)

        val dx = when (paint.textAlign) {
            TextAlign.LEFT -> 0.0f
            TextAlign.RIGHT -> -(recti.right - recti.left).toFloat()
            TextAlign.CENTER -> -(recti.right - recti.left) / 2.0f
        }

        val dy = when (paint.textBase) {
            TextBaseLine.BOTTOM -> 0.0f
            TextBaseLine.MIDDLE -> recti.height() / 2.0f - recti.bottom
        }

        canvas.drawText(text, dpToPixels(x) + dx, dpToPixels(y) + dy, pCanvas)
    }

    override fun drawRect(rect: Rect, paint: Paint) {
        rect.copyTo(rectf, density)
        pCanvas.color = paint.color.toInt()
        canvas.drawRect(rectf, pCanvas)
    }

    override fun width(): Double {
        return pixelsToDp(canvas.width.toDouble())
    }

    override fun height(): Double {
        return pixelsToDp(canvas.height.toDouble())
    }

    private fun pixelsToDp(pixels: Double): Double {
        return pixels / density
    }

    private fun dpToPixels(dips: Double): Float {
        return (dips * density).toFloat()
    }
}
