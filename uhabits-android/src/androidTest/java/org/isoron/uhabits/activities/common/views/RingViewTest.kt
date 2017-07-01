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

package org.isoron.uhabits.activities.common.views

import android.support.test.filters.*
import android.support.test.runner.*
import org.isoron.uhabits.*
import org.isoron.uhabits.activities.*
import org.isoron.uhabits.core.graphics.*
import org.isoron.uhabits.core.ui.widgets.*
import org.junit.*
import org.junit.runner.*

@RunWith(AndroidJUnit4::class)
@MediumTest
class RingViewTest : BaseViewTest() {

    private val BASE_PATH = "common/RingView"

    @Test
    fun testRender_base() {
        val ring = RingWidget(LIGHT_THEME).apply {
            percentage = 0.6
            text = "60%"
            thickness = 3.0
            primaryColor = Color(211, 47, 47)
        }

        val view = AndroidView(targetContext, ring)
        measureView(view, dpToPixels(100), dpToPixels(100))
        assertRenders(view, "$BASE_PATH/render.png")
    }

    @Test
    fun testRender_withDifferentParams() {
        val ring = RingWidget(LIGHT_THEME).apply {
            LIGHT_THEME
            percentage = 0.25
            text = "60%"
            thickness = 3.0
            primaryColor = Color(175, 180, 43)
        }

        val view = AndroidView(targetContext, ring)
        measureView(view, dpToPixels(200), dpToPixels(200))
        assertRenders(view, "$BASE_PATH/renderDifferentParams.png")
    }
}
