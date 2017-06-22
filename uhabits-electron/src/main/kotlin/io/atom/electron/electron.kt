package io.atom.electron

class Options(var width: Int, var height: Int)

@JsModule("electron")
external abstract class Electron {
    open class BrowserWindow(args: Options)
    companion object {
        val app: dynamic
    }
}

external val __dirname: dynamic