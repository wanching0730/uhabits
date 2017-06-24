package org.isoron.uhabits.core.graphics

data class Color(val red: Int, val green: Int, val blue: Int) {
    fun toJsString() = "rgb($red, $green, $blue)"
}