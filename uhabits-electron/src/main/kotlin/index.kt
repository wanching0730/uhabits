import io.atom.electron.*

external val render_process: dynamic

fun main(args : Array<String>) {
    if(jsTypeOf(render_process) != "undefined") return

    var win: dynamic
    Electron.app.on("ready") {
        win = Electron.BrowserWindow(Options(width = 800, height = 600))
        win.loadURL("file://${__dirname}/main.html")
        win.on("close") {
            win = null
            Unit
        }
    }
}


