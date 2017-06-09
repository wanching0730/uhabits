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
import android.view.View.MeasureSpec.*
import org.isoron.androidbase.utils.*
import org.isoron.androidbase.utils.InterfaceUtils.*
import org.isoron.uhabits.*
import org.isoron.uhabits.activities.*
import org.isoron.uhabits.core.models.Checkmark.*
import org.isoron.uhabits.core.preferences.*
import org.isoron.uhabits.utils.*
import org.isoron.uhabits.utils.AttributeSetUtils.*

class CheckmarkButtonView(context: Context) : View(context), View.OnClickListener, View.OnLongClickListener {

    var color: Int = Color.BLACK
    var value: Int = 0
    var preferences: Preferences? = null
    var onToggle: () -> Unit = {}
    var onInvalidToggle: () -> Unit = {}

    private var drawer = Drawer(context)

    init {
        isFocusable = false
        setOnClickListener(this)
        setOnLongClickListener(this)

        if (context is HabitsActivity) {
            preferences = context.appComponent.preferences
        }
    }

    constructor(ctx: Context, attrs: AttributeSet) : this(ctx) {
        val paletteColor = getIntAttribute(ctx, attrs, "color", 0)
        this.color = PaletteUtils.getAndroidTestColor(paletteColor)
        this.value = getIntAttribute(ctx, attrs, "value", 0)
    }

    fun performToggle() {
        onToggle()
        value = if (value == CHECKED_EXPLICITLY) UNCHECKED else CHECKED_EXPLICITLY
        performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
        postInvalidate()
    }

    override fun onLongClick(v: View): Boolean {
        performToggle()
        return true
    }

    override fun onClick(v: View) {
        if (preferences!!.isShortToggleEnabled) performToggle()
        else onInvalidToggle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawer.draw(canvas)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val height = resources.getDimensionPixelSize(R.dimen.checkmarkHeight)
        val width = resources.getDimensionPixelSize(R.dimen.checkmarkWidth)
        super.onMeasure(makeMeasureSpec(width, EXACTLY), makeMeasureSpec(height, EXACTLY))
    }

    private inner class Drawer(context: Context) {

        private val rect = RectF()
        private val styledRes = StyledResources(context)
        private val lowContrastColor: Int

        private val paint = TextPaint().apply {
            typeface = getFontAwesome(context)
            isAntiAlias = true
            textAlign = Paint.Align.CENTER
            textSize = getDimension(context, R.dimen.smallTextSize)
        }

        init {
            lowContrastColor = styledRes.getColor(R.attr.lowContrastTextColor)
        }

        fun draw(canvas: Canvas) {
            paint.color = if (value == CHECKED_EXPLICITLY) color else lowContrastColor
            val id = if (value == UNCHECKED) R.string.fa_times else R.string.fa_check
            val label = resources.getString(id)
            val em = paint.measureText("m")

            rect.set(0f, 0f, width.toFloat(), height.toFloat())
            rect.offset(0f, 0.4f * em)
            canvas.drawText(label, rect.centerX(), rect.centerY(), paint)
        }
    }
}
