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

import android.graphics.*
import android.support.test.filters.*
import android.support.test.runner.*
import org.isoron.uhabits.*
import org.isoron.uhabits.utils.*
import org.junit.*
import org.junit.runner.*
import java.io.*

@RunWith(AndroidJUnit4::class)
@MediumTest
class RingViewTest : BaseViewTest() {

    private lateinit var view: RingView

    @Before
    override fun setUp() {
        super.setUp()

        view = RingView(targetContext)
        view.percentage = 0.6f
        view.setText("60%")
        view.color = PaletteUtils.getAndroidTestColor(0)
        view.setBackgroundColor(Color.WHITE)
        view.setThickness(dpToPixels(3))
    }

    @Test
    @Throws(IOException::class)
    fun testRender_base() {
        measureView(view, dpToPixels(100), dpToPixels(100))
        assertRenders(view, BASE_PATH + "render.png")
    }

    @Test
    @Throws(IOException::class)
    fun testRender_withDifferentParams() {
        view.percentage = 0.25f
        view.color = PaletteUtils.getAndroidTestColor(5)

        measureView(view, dpToPixels(200), dpToPixels(200))
        assertRenders(view, BASE_PATH + "renderDifferentParams.png")
    }

    companion object {
        private val BASE_PATH = "common/RingView/"
    }
}
