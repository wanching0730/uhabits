package io.atom.electron

@JsModule("electron")
external abstract class Electron {
    open class BrowserWindow(args: dynamic)
    companion object {
        val app: dynamic
    }
}

external val __dirname: dynamic