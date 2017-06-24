package org.isoron.uhabits.core.graphics

enum class TextAlign {
    LEFT, RIGHT, CENTER
}

enum class TextBaseLine {
    BOTTOM, MIDDLE
}

class Paint {
    var color = Color(0, 0, 0)
    var textSize = 10.0
    var textAlign = org.isoron.uhabits.core.graphics.TextAlign.CENTER
    var textBase = org.isoron.uhabits.core.graphics.TextBaseLine.MIDDLE
}