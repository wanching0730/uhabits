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

package org.isoron.uhabits.core.widgets

import org.isoron.uhabits.core.graphics.*
import platform.*

class RingWidget {
    var precision = 1 / 16.0
    var percentage = 1.0
    var thickness = 0.0
    var textSize = 12.0
    var primaryColor = Color(200, 80, 0)
    var backgroundColor = Color(255, 255, 255)
    var inactiveColor = Color(200, 200, 200)
    var text = ""

    private var paint = Paint()
    private var rect = Rect()

    fun draw(canvas: Canvas) {
        val diameter = minOf(canvas.width(), canvas.height())
        paint.color = primaryColor
        rect.set(0.0, 0.0, diameter, diameter)

        val angle = 360.0 * (percentage / precision).round() * precision
        canvas.drawWedge(rect, - 90.0, angle, paint)

        paint.color = inactiveColor
        canvas.drawWedge(rect, angle - 90, 360 - angle, paint)

        if (thickness > 0) {
            paint.color = (backgroundColor)
            rect.inset(thickness, thickness)
            canvas.drawWedge(rect, 0.0, 360.0, paint)

            paint.color = primaryColor
            paint.textSize = textSize
            canvas.drawText(text, rect.centerX(), rect.centerY(), paint)
        }
    }
}
