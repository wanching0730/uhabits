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

package org.isoron.uhabits.core.ui.widgets

import org.isoron.uhabits.core.graphics.*
import platform.*

interface View {
    fun draw(canvas: Canvas)
}

class RingWidget(theme: Theme) : View {
    var precision: Double = 0.01
    var percentage: Double = 1.0
    var thickness: Double = 0.0
    var text: String = ""
    var textSize: Double = theme.smallTextSize
    var grey: Color = theme.lowContrastTextColor
    var primaryColor: Color = Color(255, 0, 0)
    var backgroundColor: Color = theme.cardBackgroundColor
    var typeface: Typeface = Typeface.REGULAR

    private val paint = Paint()
    private val rect = Rect()

    override fun draw(canvas: Canvas) {
        rect.set(0.0, 0.0, canvas.width(), canvas.height())
        paint.color = backgroundColor
        canvas.drawRect(rect, paint)

        val diameter = minOf(canvas.width(), canvas.height())
        paint.color = primaryColor
        rect.set(0.0, 0.0, diameter, diameter)

        val angle = 360.0 * (percentage / precision).round() * precision
        canvas.drawWedge(rect, -90.0, angle, paint)

        paint.color = grey
        canvas.drawWedge(rect, angle - 90, 360 - angle, paint)

        if (thickness > 0) {
            paint.color = (backgroundColor)
            rect.inset(thickness, thickness)
            canvas.drawWedge(rect, 0.0, 360.0, paint)

            paint.typeface = typeface
            paint.color = primaryColor
            paint.textSize = textSize
            canvas.drawText(text, rect.centerX(), rect.centerY(), paint)
        }
    }
}
