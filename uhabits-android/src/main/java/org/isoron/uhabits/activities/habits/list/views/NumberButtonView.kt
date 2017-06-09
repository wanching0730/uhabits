/*
 * Copyright (C) 2016 Álinson Santos Xavier <isoron@gmail.com>
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

package org.isoron.uhabits.activities.habits.list.views

import android.content.*
import android.graphics.*
import android.text.*
import android.util.*
import android.view.*
import android.view.View.*
import org.isoron.androidbase.utils.*
import org.isoron.androidbase.utils.InterfaceUtils.*
import org.isoron.uhabits.*
import org.isoron.uhabits.activities.*
import org.isoron.uhabits.core.preferences.*
import org.isoron.uhabits.utils.AttributeSetUtils.*
import org.isoron.uhabits.utils.PaletteUtils.*
import java.text.*

private val BOLD_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.BOLD)
private val NORMAL_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL)

fun Double.toShortString(): String = when {
    this >= 1e9 -> String.format("%.1fG", this / 1e9)
    this >= 1e8 -> String.format("%.0fM", this / 1e6)
    this >= 1e7 -> String.format("%.1fM", this / 1e6)
    this >= 1e6 -> String.format("%.1fM", this / 1e6)
    this >= 1e5 -> String.format("%.0fk", this / 1e3)
    this >= 1e4 -> String.format("%.1fk", this / 1e3)
    this >= 1e3 -> String.format("%.1fk", this / 1e3)
    this >= 1e2 -> DecimalFormat("#").format(this)
    this >= 1e1 -> DecimalFormat("#.#").format(this)
    else -> DecimalFormat("#.##").format(this)
}

class NumberButtonView(context: Context) : View(context), OnClickListener, OnLongClickListener {

    var color: Int = 0
    var value: Double = 0.0
    var threshold: Double = 0.0
    var units: String = ""

    var onEdit: () -> Unit = {}
    var onInvalidEdit: () -> Unit = {}
    var preferences: Preferences? = null
    private var drawer: Drawer = Drawer(context)

    init {
        setOnClickListener(this)
        setOnLongClickListener(this)
    }

    constructor(ctx: Context, attrs: AttributeSet) : this(ctx) {
        val color = getIntAttribute(ctx, attrs, "color", 0)
        val value = getIntAttribute(ctx, attrs, "value", 0)
        val threshold = getIntAttribute(ctx, attrs, "threshold", 1)
        val unit = getAttribute(ctx, attrs, "unit", "min")

        this.color = getAndroidTestColor(color)
        this.threshold = threshold.toDouble()
        this.value = value.toDouble()
        if (unit != null) this.units = unit

        if (ctx is HabitsActivity) {
            preferences = ctx.appComponent.preferences
        }
    }

    override fun onClick(v: View) {
        if (preferences!!.isShortToggleEnabled) onEdit()
        else onInvalidEdit()
    }

    override fun onLongClick(v: View): Boolean {
        onEdit()
        return true
    }

    override fun onDraw(canvas: Canvas) {
        drawer.draw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = getDimension(context, R.dimen.checkmarkWidth).toInt()
        val height = getDimension(context, R.dimen.checkmarkHeight).toInt()
        setMeasuredDimension(width, height)
    }

    private inner class Drawer(context: Context) {

        private val em: Float
        private val rect: RectF = RectF()
        private val sr = StyledResources(context)

        private val lightGrey: Int
        private val darkGrey: Int

        private val pRegular: TextPaint = TextPaint().apply {
            textSize = getDimension(context, R.dimen.smallerTextSize)
            typeface = NORMAL_TYPEFACE
            isAntiAlias = true
            textAlign = Paint.Align.CENTER
        }

        private val pBold: TextPaint = TextPaint().apply {
            textSize = getDimension(context, R.dimen.smallTextSize)
            typeface = BOLD_TYPEFACE
            isAntiAlias = true
            textAlign = Paint.Align.CENTER
        }

        init {
            em = pBold.measureText("m")
            lightGrey = sr.getColor(R.attr.lowContrastTextColor)
            darkGrey = sr.getColor(R.attr.mediumContrastTextColor)
        }

        fun draw(canvas: Canvas) {
            val activeColor = when {
                value == 0.0 -> lightGrey
                value < threshold -> darkGrey
                else -> color
            }

            val label = value.toShortString()
            pBold.color = activeColor
            pRegular.color = activeColor

            rect.set(0f, 0f, width.toFloat(), height.toFloat())
            canvas.drawText(label, rect.centerX(), rect.centerY(), pBold)

            rect.offset(0f, 1.2f * em)
            canvas.drawText(units, rect.centerX(), rect.centerY(), pRegular)
        }
    }
}
