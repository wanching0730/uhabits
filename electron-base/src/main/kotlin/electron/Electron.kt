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

@file:Suppress("INTERFACE_WITH_SUPERCLASS",
               "OVERRIDING_FINAL_MEMBER",
               "RETURN_TYPE_MISMATCH_ON_OVERRIDE",
               "CONFLICTING_OVERLOADS", "unused")

package electron

import org.w3c.dom.*
import org.w3c.files.*
import kotlin.js.*

external interface GlobalEvent
external interface Buffer

external var __dirname: dynamic

@JsModule("electron")
external abstract class Electron {
    companion object {
        var app: App
        var autoUpdater: AutoUpdater
        var clipboard: Clipboard
        var contentTracing: ContentTracing
        var crashReporter: CrashReporter
        var desktopCapturer: DesktopCapturer
        var dialog: Dialog
        var globalShortcut: GlobalShortcut
        var ipcMain: IpcMain
        var ipcRenderer: IpcRenderer
        var nativeImage: NativeImage
        var net: Net
        var remote: Remote
        var screen: Screen
        var session: Session
        var shell: Shell
        var systemPreferences: SystemPreferences
        var powerMonitor: PowerMonitor
        var powerSaveBlocker: PowerSaveBlocker
        var protocol: Protocol
        var webContents: WebContents
        var webFrame: WebFrame
        var webviewTag: WebviewTag
    }

    open class BrowserView(options: BrowserViewConstructorOptions? = definedExternally /* null */) : EventEmitter {
        open fun setAutoResize(options: AutoResizeOptions): Unit = definedExternally
        open fun setBackgroundColor(color: String): Unit = definedExternally
        open fun setBounds(bounds: Rectangle): Unit = definedExternally
        open var id: Number = definedExternally
        open var webContents: WebContents = definedExternally
    }

    open class BrowserWindow(options: BrowserWindowConstructorOptions? = definedExternally /* null */) : EventEmitter {
        open fun blur(): Unit = definedExternally
        open fun blurWebView(): Unit = definedExternally
        open fun capturePage(callback: (image: NativeImage) -> Unit): Unit = definedExternally
        open fun capturePage(rect: Rectangle, callback: (image: NativeImage) -> Unit): Unit = definedExternally
        open fun center(): Unit = definedExternally
        open fun close(): Unit = definedExternally
        open fun closeFilePreview(): Unit = definedExternally
        open fun destroy(): Unit = definedExternally
        open fun flashFrame(flag: Boolean): Unit = definedExternally
        open fun focus(): Unit = definedExternally
        open fun focusOnWebView(): Unit = definedExternally
        open fun getBounds(): Rectangle = definedExternally
        open fun getChildWindows(): Array<BrowserWindow> = definedExternally
        open fun getContentBounds(): Rectangle = definedExternally
        open fun getContentSize(): Array<Number> = definedExternally
        open fun getMaximumSize(): Array<Number> = definedExternally
        open fun getMinimumSize(): Array<Number> = definedExternally
        open fun getNativeWindowHandle(): Buffer = definedExternally
        open fun getParentWindow(): BrowserWindow = definedExternally
        open fun getPosition(): Array<Number> = definedExternally
        open fun getRepresentedFilename(): String = definedExternally
        open fun getSize(): Array<Number> = definedExternally
        open fun getTitle(): String = definedExternally
        open fun hasShadow(): Boolean = definedExternally
        open fun hide(): Unit = definedExternally
        open fun hookWindowMessage(message: Number, callback: Function<*>): Unit = definedExternally
        open fun isAlwaysOnTop(): Boolean = definedExternally
        open fun isClosable(): Boolean = definedExternally
        open fun isDestroyed(): Boolean = definedExternally
        open fun isDocumentEdited(): Boolean = definedExternally
        open fun isFocused(): Boolean = definedExternally
        open fun isFullScreen(): Boolean = definedExternally
        open fun isFullScreenable(): Boolean = definedExternally
        open fun isKiosk(): Boolean = definedExternally
        open fun isMaximizable(): Boolean = definedExternally
        open fun isMaximized(): Boolean = definedExternally
        open fun isMenuBarAutoHide(): Boolean = definedExternally
        open fun isMenuBarVisible(): Boolean = definedExternally
        open fun isMinimizable(): Boolean = definedExternally
        open fun isMinimized(): Boolean = definedExternally
        open fun isModal(): Boolean = definedExternally
        open fun isMovable(): Boolean = definedExternally
        open fun isResizable(): Boolean = definedExternally
        open fun isVisible(): Boolean = definedExternally
        open fun isVisibleOnAllWorkspaces(): Boolean = definedExternally
        open fun isWindowMessageHooked(message: Number): Boolean = definedExternally
        open fun loadURL(url: String, options: LoadURLOptions? = definedExternally /* null */): Unit = definedExternally
        open fun maximize(): Unit = definedExternally
        open fun minimize(): Unit = definedExternally
        open fun previewFile(path: String, displayName: String? = definedExternally /* null */): Unit = definedExternally
        open fun reload(): Unit = definedExternally
        open fun restore(): Unit = definedExternally
        open fun setAlwaysOnTop(flag: Boolean, level: Any? /* "normal" */ = definedExternally /* null */, relativeLevel: Number? = definedExternally /* null */): Unit = definedExternally
        open fun setAppDetails(options: AppDetailsOptions): Unit = definedExternally
        open fun setAspectRatio(aspectRatio: Number, extraSize: Size): Unit = definedExternally
        open fun setAutoHideCursor(autoHide: Boolean): Unit = definedExternally
        open fun setAutoHideMenuBar(hide: Boolean): Unit = definedExternally
        open fun setBounds(bounds: Rectangle, animate: Boolean? = definedExternally /* null */): Unit = definedExternally
        open fun setBrowserView(browserView: BrowserView): Unit = definedExternally
        open fun setClosable(closable: Boolean): Unit = definedExternally
        open fun setContentBounds(bounds: Rectangle, animate: Boolean? = definedExternally /* null */): Unit = definedExternally
        open fun setContentProtection(enable: Boolean): Unit = definedExternally
        open fun setContentSize(width: Number, height: Number, animate: Boolean? = definedExternally /* null */): Unit = definedExternally
        open fun setDocumentEdited(edited: Boolean): Unit = definedExternally
        open fun setFocusable(focusable: Boolean): Unit = definedExternally
        open fun setFullScreen(flag: Boolean): Unit = definedExternally
        open fun setFullScreenable(fullscreenable: Boolean): Unit = definedExternally
        open fun setHasShadow(hasShadow: Boolean): Unit = definedExternally
        open fun setIcon(icon: NativeImage): Unit = definedExternally
        open fun setIgnoreMouseEvents(ignore: Boolean): Unit = definedExternally
        open fun setKiosk(flag: Boolean): Unit = definedExternally
        open fun setMaximizable(maximizable: Boolean): Unit = definedExternally
        open fun setMaximumSize(width: Number, height: Number): Unit = definedExternally
        open fun setMenu(menu: Menu?): Unit = definedExternally
        open fun setMenuBarVisibility(visible: Boolean): Unit = definedExternally
        open fun setMinimizable(minimizable: Boolean): Unit = definedExternally
        open fun setMinimumSize(width: Number, height: Number): Unit = definedExternally
        open fun setMovable(movable: Boolean): Unit = definedExternally
        open fun setOverlayIcon(overlay: NativeImage, description: String): Unit = definedExternally
        open fun setParentWindow(parent: BrowserWindow): Unit = definedExternally
        open fun setPosition(x: Number, y: Number, animate: Boolean? = definedExternally /* null */): Unit = definedExternally
        open fun setProgressBar(progress: Number, options: ProgressBarOptions? = definedExternally /* null */): Unit = definedExternally
        open fun setRepresentedFilename(filename: String): Unit = definedExternally
        open fun setResizable(resizable: Boolean): Unit = definedExternally
        open fun setSheetOffset(offsetY: Number, offsetX: Number? = definedExternally /* null */): Unit = definedExternally
        open fun setSize(width: Number, height: Number, animate: Boolean? = definedExternally /* null */): Unit = definedExternally
        open fun setSkipTaskbar(skip: Boolean): Unit = definedExternally
        open fun setThumbarButtons(buttons: Array<ThumbarButton>): Boolean = definedExternally
        open fun setThumbnailClip(region: Rectangle): Unit = definedExternally
        open fun setThumbnailToolTip(toolTip: String): Unit = definedExternally
        open fun setTitle(title: String): Unit = definedExternally
        open fun setTouchBar(touchBar: TouchBar): Unit = definedExternally
        open fun setVibrancy(type: Any /* "appearance-based" */): Unit = definedExternally
        open fun setVisibleOnAllWorkspaces(visible: Boolean): Unit = definedExternally
        open fun show(): Unit = definedExternally
        open fun showDefinitionForSelection(): Unit = definedExternally
        open fun showInactive(): Unit = definedExternally
        open fun unhookAllWindowMessages(): Unit = definedExternally
        open fun unhookWindowMessage(message: Number): Unit = definedExternally
        open fun unmaximize(): Unit = definedExternally
        open var id: Number = definedExternally
        open var webContents: WebContents = definedExternally

        companion object {
            fun addDevToolsExtension(path: String): Unit = definedExternally
            fun fromId(id: Number): BrowserWindow = definedExternally
            fun fromWebContents(webContents: WebContents): BrowserWindow = definedExternally
            fun getAllWindows(): Array<BrowserWindow> = definedExternally
            fun getDevToolsExtensions(): DevToolsExtensions = definedExternally
            fun getFocusedWindow(): BrowserWindow = definedExternally
            fun removeDevToolsExtension(name: String): Unit = definedExternally
        }
    }

    open class BrowserWindowProxy : EventEmitter {
        open fun blur(): Unit = definedExternally
        open fun close(): Unit = definedExternally
        open fun eval(code: String): Unit = definedExternally
        open fun focus(): Unit = definedExternally
        open fun postMessage(message: String, targetOrigin: String): Unit = definedExternally
        open fun print(): Unit = definedExternally
        open var closed: Boolean = definedExternally
    }

    open class ClientRequest : EventEmitter {
        constructor(options: Any)
        constructor(options: String)

        open fun abort(): Unit = definedExternally
        open fun end(chunk: String? = definedExternally /* null */, encoding: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): Unit = definedExternally
        open fun end(chunk: Buffer? = definedExternally /* null */, encoding: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): Unit = definedExternally
        open fun followRedirect(): Unit = definedExternally
        open fun getHeader(name: String): Unit = definedExternally
        open fun removeHeader(name: String): Unit = definedExternally
        open fun setHeader(name: String, value: Any): Unit = definedExternally
        open fun write(chunk: String, encoding: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): Unit = definedExternally
        open fun write(chunk: Buffer, encoding: String? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): Unit = definedExternally
        open var chunkedEncoding: Boolean = definedExternally
    }

    open class Cookies : EventEmitter {
        open fun flushStore(callback: Function<*>): Unit = definedExternally
        open fun get(filter: Filter, callback: (error: Error, cookies: Array<Cookies>) -> Unit): Unit = definedExternally
        open fun remove(url: String, name: String, callback: Function<*>): Unit = definedExternally
        open fun set(details: Details, callback: (error: Error) -> Unit): Unit = definedExternally
    }

    open class Debugger : EventEmitter {
        open fun on(event: Any /* "detach" */, listener: (event: Event, reason: String) -> Unit): Debugger /* this */ = definedExternally
        open fun once(event: Any /* "detach" */, listener: (event: Event, reason: String) -> Unit): Debugger /* this */ = definedExternally
        open fun addListener(event: Any /* "detach" */, listener: (event: Event, reason: String) -> Unit): Debugger /* this */ = definedExternally
        open fun removeListener(event: Any /* "detach" */, listener: (event: Event, reason: String) -> Unit): Debugger /* this */ = definedExternally
        open fun attach(protocolVersion: String? = definedExternally /* null */): Unit = definedExternally
        open fun detach(): Unit = definedExternally
        open fun isAttached(): Boolean = definedExternally
        open fun sendCommand(method: String, commandParams: Any? = definedExternally /* null */, callback: ((error: Any, result: Any) -> Unit)? = definedExternally /* null */): Unit = definedExternally
    }

    open class DownloadItem : EventEmitter {
        open fun cancel(): Unit = definedExternally
        open fun canResume(): Unit = definedExternally
        open fun getContentDisposition(): String = definedExternally
        open fun getETag(): String = definedExternally
        open fun getFilename(): String = definedExternally
        open fun getLastModifiedTime(): String = definedExternally
        open fun getMimeType(): String = definedExternally
        open fun getReceivedBytes(): Number = definedExternally
        open fun getSavePath(): String = definedExternally
        open fun getStartTime(): Number = definedExternally
        open fun getState(): dynamic /* Any /* "progressing" */ | Any /* "completed" */ | Any /* "cancelled" */ | Any /* "interrupted" */ */ = definedExternally
        open fun getTotalBytes(): Number = definedExternally
        open fun getURL(): String = definedExternally
        open fun getURLChain(): Array<String> = definedExternally
        open fun hasUserGesture(): Boolean = definedExternally
        open fun isPaused(): Boolean = definedExternally
        open fun pause(): Unit = definedExternally
        open fun resume(): Unit = definedExternally
        open fun setSavePath(path: String): Unit = definedExternally
    }

    open class IncomingMessage : EventEmitter {
        open var headers: Any = definedExternally
        open var httpVersion: String = definedExternally
        open var httpVersionMajor: Number = definedExternally
        open var httpVersionMinor: Number = definedExternally
        open var statusCode: Number = definedExternally
        open var statusMessage: String = definedExternally
    }

    open class Menu {
        open fun append(menuItem: MenuItem): Unit = definedExternally
        open fun closePopup(browserWindow: BrowserWindow? = definedExternally /* null */): Unit = definedExternally
        open fun insert(pos: Number, menuItem: MenuItem): Unit = definedExternally
        open fun popup(browserWindow: BrowserWindow? = definedExternally /* null */, options: PopupOptions? = definedExternally /* null */): Unit = definedExternally
        open var items: Array<MenuItem> = definedExternally

        companion object {
            fun buildFromTemplate(template: Array<MenuItemConstructorOptions>): Menu = definedExternally
            fun getApplicationMenu(): Menu = definedExternally
            fun sendActionToFirstResponder(action: String): Unit = definedExternally
            fun setApplicationMenu(menu: Menu): Unit = definedExternally
        }
    }

    open class MenuItem(options: MenuItemConstructorOptions) {
        open var checked: Boolean = definedExternally
        open var click: Function<*> = definedExternally
        open var enabled: Boolean = definedExternally
        open var label: String = definedExternally
        open var visible: Boolean = definedExternally
    }

    open class TouchBar : EventEmitter {
        constructor(items: TouchBarButton)
        constructor(items: TouchBarColorPicker)
        constructor(items: TouchBarGroup)
        constructor(items: TouchBarLabel)
        constructor(items: TouchBarPopover)
        constructor(items: TouchBarScrubber)
        constructor(items: TouchBarSegmentedControl)
        constructor(items: TouchBarSlider)
        constructor(items: TouchBarSpacer)

        open var escapeItem: Any = definedExternally

        companion object {
            var TouchBarButton: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:3621:27 to 3621:49) */ = definedExternally
            var TouchBarColorPicker: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:3622:32 to 3622:59) */ = definedExternally
            var TouchBarGroup: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:3623:26 to 3623:47) */ = definedExternally
            var TouchBarLabel: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:3624:26 to 3624:47) */ = definedExternally
            var TouchBarPopover: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:3625:28 to 3625:51) */ = definedExternally
            var TouchBarScrubber: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:3626:29 to 3626:53) */ = definedExternally
            var TouchBarSegmentedControl: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:3627:37 to 3627:69) */ = definedExternally
            var TouchBarSlider: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:3628:27 to 3628:49) */ = definedExternally
            var TouchBarSpacer: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:3629:27 to 3629:49) */ = definedExternally
        }
    }

    open class WebRequest : EventEmitter {
        open fun onBeforeRedirect(filter: OnBeforeRedirectFilter, listener: (details: OnBeforeRedirectDetails) -> Unit): Unit = definedExternally
        open fun onBeforeRequest(filter: OnBeforeRequestFilter, listener: (details: OnBeforeRequestDetails, callback: (response: Response) -> Unit) -> Unit): Unit = definedExternally
        open fun onBeforeSendHeaders(filter: OnBeforeSendHeadersFilter, listener: Function<*>): Unit = definedExternally
        open fun onCompleted(filter: OnCompletedFilter, listener: (details: OnCompletedDetails) -> Unit): Unit = definedExternally
        open fun onErrorOccurred(filter: OnErrorOccurredFilter, listener: (details: OnErrorOccurredDetails) -> Unit): Unit = definedExternally
        open fun onHeadersReceived(filter: OnHeadersReceivedFilter, listener: Function<*>): Unit = definedExternally
        open fun onResponseStarted(filter: OnResponseStartedFilter, listener: (details: OnResponseStartedDetails) -> Unit): Unit = definedExternally
        open fun onSendHeaders(filter: OnSendHeadersFilter, listener: (details: OnSendHeadersDetails) -> Unit): Unit = definedExternally
    }

}

external open class EventEmitter {
    open fun addListener(event: String, listener: Function<*>): EventEmitter /* this */ = definedExternally
    open fun on(event: String, listener: Function<*>): EventEmitter /* this */ = definedExternally
    open fun once(event: String, listener: Function<*>): EventEmitter /* this */ = definedExternally
    open fun removeListener(event: String, listener: Function<*>): EventEmitter /* this */ = definedExternally
    open fun removeAllListeners(event: String? = definedExternally /* null */): EventEmitter /* this */ = definedExternally
    open fun setMaxListeners(n: Number): EventEmitter /* this */ = definedExternally
    open fun getMaxListeners(): Number = definedExternally
    open fun listeners(event: String): Array<Function<*>> = definedExternally
    open fun emit(event: String, vararg args: Any): Boolean = definedExternally
    open fun listenerCount(type: String): Number = definedExternally
    open fun prependListener(event: String, listener: Function<*>): EventEmitter /* this */ = definedExternally
    open fun prependOnceListener(event: String, listener: Function<*>): EventEmitter /* this */ = definedExternally
    open fun eventNames(): Array<String> = definedExternally
}

external open class Accelerator
external interface Event : GlobalEvent {
    var preventDefault: () -> Unit
    var sender: WebContents
    var returnValue: Any
    var ctrlkey: Boolean? get() = definedExternally; set(value) = definedExternally
    var metaKey: Boolean? get() = definedExternally; set(value) = definedExternally
    var shiftKey: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface CommonInterface {
    var clipboard: Clipboard
    var crashReporter: CrashReporter
    var nativeImage: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:43:17 to 43:45) */
    var screen: Screen
    var shell: Shell
}

external interface MainInterface : CommonInterface {
    var app: App
    var autoUpdater: AutoUpdater
    var BrowserView: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:51:17 to 51:45) */
    var BrowserWindow: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:52:19 to 52:49) */
    var ClientRequest: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:53:19 to 53:49) */
    var contentTracing: ContentTracing
    var Cookies: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:55:13 to 55:37) */
    var Debugger: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:56:14 to 56:39) */
    var dialog: Dialog
    var DownloadItem: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:58:18 to 58:47) */
    var globalShortcut: GlobalShortcut
    var IncomingMessage: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:60:21 to 60:53) */
    var ipcMain: IpcMain
    var Menu: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:62:10 to 62:31) */
    var MenuItem: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:63:14 to 63:39) */
    var net: Net
    var powerMonitor: PowerMonitor
    var powerSaveBlocker: PowerSaveBlocker
    var protocol: Protocol
    var session: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:68:13 to 68:37) */
    var systemPreferences: SystemPreferences
    var TouchBar: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:70:14 to 70:39) */
    var Tray: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:71:10 to 71:31) */
    var webContents: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:72:17 to 72:45) */
    var WebRequest: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:73:16 to 73:43) */
}

external interface RendererInterface : CommonInterface {
    var BrowserWindowProxy: dynamic /* "TypeQuery" kind unsupported yet here! (electron.d.ts:77:24 to 77:59) */
    var desktopCapturer: DesktopCapturer
    var ipcRenderer: IpcRenderer
    var remote: Remote
    var webFrame: WebFrame
    var webviewTag: WebviewTag
}

external interface App : EventEmitter {
    fun addRecentDocument(path: String)
    fun clearRecentDocuments()
    fun disableHardwareAcceleration()
    fun exit(exitCode: Number? = definedExternally /* null */)
    fun focus()
    fun getAppMemoryInfo()
    fun getAppPath(): String
    fun getBadgeCount(): Number
    fun getCurrentActivityType(): String
    fun getFileIcon(path: String, options: FileIconOptions, callback: (error: Error, icon: NativeImage) -> Unit)
    fun getFileIcon(path: String, callback: (error: Error, icon: NativeImage) -> Unit)
    fun getJumpListSettings(): JumpListSettings
    fun getLocale(): String
    fun getLoginItemSettings(options: LoginItemSettingsOptions? = definedExternally /* null */): LoginItemSettings
    fun getName(): String
    fun getPath(name: String): String
    fun getVersion(): String
    fun hide()
    fun importCertificate(options: ImportCertificateOptions, callback: (result: Number) -> Unit)
    fun isAccessibilitySupportEnabled(): Boolean
    fun isDefaultProtocolClient(protocol: String, path: String? = definedExternally /* null */, args: Array<String>? = definedExternally /* null */): Boolean
    fun isReady(): Boolean
    fun isUnityRunning(): Boolean
    fun makeSingleInstance(callback: (argv: Array<String>, workingDirectory: String) -> Unit): Boolean
    fun quit()
    fun relaunch(options: RelaunchOptions? = definedExternally /* null */)
    fun releaseSingleInstance()
    fun removeAsDefaultProtocolClient(protocol: String, path: String? = definedExternally /* null */, args: Array<String>? = definedExternally /* null */): Boolean
    fun setAboutPanelOptions(options: AboutPanelOptionsOptions)
    fun setAppUserModelId(id: String)
    fun setAsDefaultProtocolClient(protocol: String, path: String? = definedExternally /* null */, args: Array<String>? = definedExternally /* null */): Boolean
    fun setBadgeCount(count: Number): Boolean
    fun setJumpList(categories: Array<JumpListCategory>)
    fun setLoginItemSettings(settings: Settings, path: String? = definedExternally /* null */, args: Array<String>? = definedExternally /* null */)
    fun setName(name: String)
    fun setPath(name: String, path: String)
    fun setUserActivity(type: String, userInfo: Any, webpageURL: String? = definedExternally /* null */)
    fun setUserTasks(tasks: Array<Task>): Boolean
    fun show()
    var commandLine: CommandLine
    var dock: Dock
}

external interface AutoUpdater : EventEmitter {
    fun checkForUpdates()
    fun getFeedURL(): String
    fun quitAndInstall()
    fun setFeedURL(url: String, requestHeaders: Any? = definedExternally /* null */)
}

external interface BluetoothDevice {
    var deviceId: String
    var deviceName: String
}

external interface Certificate {
    var data: String
    var fingerprint: String
    var issuer: CertificatePrincipal
    var issuerCert: Certificate
    var issuerName: String
    var serialNumber: String
    var subject: CertificatePrincipal
    var subjectName: String
    var validExpiry: Number
    var validStart: Number
}

external interface CertificatePrincipal {
    var commonName: String
    var country: String
    var locality: String
    var organizations: Array<String>
    var organizationUnits: Array<String>
    var state: String
}

external interface Clipboard : EventEmitter {
    fun availableFormats(type: String? = definedExternally /* null */): Array<String>
    fun clear(type: String? = definedExternally /* null */)
    fun has(format: String, type: String? = definedExternally /* null */): Boolean
    fun read(format: String): String
    fun readBookmark(): ReadBookmark
    fun readBuffer(format: String): Buffer
    fun readFindText(): String
    fun readHTML(type: String? = definedExternally /* null */): String
    fun readImage(type: String? = definedExternally /* null */): NativeImage
    fun readRTF(type: String? = definedExternally /* null */): String
    fun readText(type: String? = definedExternally /* null */): String
    fun write(data: Data, type: String? = definedExternally /* null */)
    fun writeBookmark(title: String, url: String, type: String? = definedExternally /* null */)
    fun writeFindText(text: String)
    fun writeHTML(markup: String, type: String? = definedExternally /* null */)
    fun writeImage(image: NativeImage, type: String? = definedExternally /* null */)
    fun writeRTF(text: String, type: String? = definedExternally /* null */)
    fun writeText(text: String, type: String? = definedExternally /* null */)
}

external interface ContentTracing : EventEmitter {
    fun captureMonitoringSnapshot(resultFilePath: String, callback: (resultFilePath: String) -> Unit)
    fun getCategories(callback: (categories: Array<String>) -> Unit)
    fun getTraceBufferUsage(callback: (value: Number, percentage: Number) -> Unit)
    fun startMonitoring(options: StartMonitoringOptions, callback: Function<*>)
    fun startRecording(options: StartRecordingOptions, callback: Function<*>)
    fun stopMonitoring(callback: Function<*>)
    fun stopRecording(resultFilePath: String, callback: (resultFilePath: String) -> Unit)
}

external interface Cookie {
    var domain: String? get() = definedExternally; set(value) = definedExternally
    var expirationDate: Number? get() = definedExternally; set(value) = definedExternally
    var hostOnly: Boolean? get() = definedExternally; set(value) = definedExternally
    var httpOnly: Boolean? get() = definedExternally; set(value) = definedExternally
    var name: String
    var path: String? get() = definedExternally; set(value) = definedExternally
    var secure: Boolean? get() = definedExternally; set(value) = definedExternally
    var session: Boolean? get() = definedExternally; set(value) = definedExternally
    var value: String
}

external interface CPUUsage {
    var idleWakeupsPerSecond: Number
    var percentCPUUsage: Number
}

external interface CrashReport {
    var date: String
    var ID: Number
}

external interface CrashReporter : EventEmitter {
    fun getLastCrashReport(): CrashReport
    fun getUploadedReports(): Array<CrashReport>
    fun getUploadToServer(): Boolean
    fun setExtraParameter(key: String, value: String)
    fun setUploadToServer(uploadToServer: Boolean)
    fun start(options: CrashReporterStartOptions)
}


external interface DesktopCapturer : EventEmitter {
    fun getSources(options: SourcesOptions, callback: (error: Error, sources: Array<DesktopCapturerSource>) -> Unit)
}

external interface DesktopCapturerSource {
    var id: String
    var name: String
    var thumbnail: NativeImage
}

external interface Dialog : EventEmitter {
    fun showCertificateTrustDialog(browserWindow: Electron.BrowserWindow, options: CertificateTrustDialogOptions, callback: Function<*>)
    fun showCertificateTrustDialog(options: CertificateTrustDialogOptions, callback: Function<*>)
    fun showCertificateTrustDialog(browserWindow: Electron.BrowserWindow, options: CertificateTrustDialogOptions, callback: Function<*>)
    fun showErrorBox(title: String, content: String)
    fun showMessageBox(browserWindow: Electron.BrowserWindow, options: MessageBoxOptions, callback: ((response: Number, checkboxChecked: Boolean) -> Unit)? = definedExternally /* null */): Number
    fun showMessageBox(options: MessageBoxOptions, callback: ((response: Number, checkboxChecked: Boolean) -> Unit)? = definedExternally /* null */): Number
    fun showOpenDialog(browserWindow: Electron.BrowserWindow, options: OpenDialogOptions, callback: ((filePaths: Array<String>) -> Unit)? = definedExternally /* null */): Array<String>
    fun showOpenDialog(options: OpenDialogOptions, callback: ((filePaths: Array<String>) -> Unit)? = definedExternally /* null */): Array<String>
    fun showSaveDialog(browserWindow: Electron.BrowserWindow, options: SaveDialogOptions, callback: ((filename: String) -> Unit)? = definedExternally /* null */): String
    fun showSaveDialog(options: SaveDialogOptions, callback: ((filename: String) -> Unit)? = definedExternally /* null */): String
}

external interface Display {
    var bounds: Rectangle
    var id: Number
    var rotation: Number
    var scaleFactor: Number
    var size: Size
    var touchSupport: dynamic /* Any /* "available" */ | Any /* "unavailable" */ | Any /* "unknown" */ */
    var workArea: Rectangle
    var workAreaSize: Size
}

external interface FileFilter {
    var extensions: Array<String>
    var name: String
}

external interface GlobalShortcut : EventEmitter {
    fun isRegistered(accelerator: Accelerator): Boolean
    fun register(accelerator: Accelerator, callback: Function<*>)
    fun unregister(accelerator: Accelerator)
    fun unregisterAll()
}

external interface IOCounters {
    var otherOperationCount: Number
    var otherTransferCount: Number
    var readOperationCount: Number
    var readTransferCount: Number
    var writeOperationCount: Number
    var writeTransferCount: Number
}

external interface IpcMain : EventEmitter {
    override fun on(channel: String, listener: Function<*>): IpcMain /* this */
    override fun once(channel: String, listener: Function<*>): IpcMain /* this */
    override fun removeAllListeners(channel: String?): IpcMain /* this */
    override fun removeListener(channel: String, listener: Function<*>): IpcMain /* this */
}

external interface IpcRenderer : EventEmitter {
    override fun on(channel: String, listener: Function<*>): IpcRenderer /* this */
    override fun once(channel: String, listener: Function<*>): IpcRenderer /* this */
    override fun removeAllListeners(channel: String?): IpcRenderer /* this */
    override fun removeListener(channel: String, listener: Function<*>): IpcRenderer /* this */
    fun send(channel: String, vararg args: Any)
    fun sendSync(channel: String, vararg args: Any)
    fun sendToHost(channel: String, vararg args: Any)
}

external interface JumpListCategory {
    var items: Array<JumpListItem>? get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
    var type: dynamic /* Any /* "tasks" */ | Any /* "frequent" */ | Any /* "recent" */ | Any /* "custom" */ */ get() = definedExternally; set(value) = definedExternally
}

external interface JumpListItem {
    var args: String? get() = definedExternally; set(value) = definedExternally
    var description: String? get() = definedExternally; set(value) = definedExternally
    var iconIndex: Number? get() = definedExternally; set(value) = definedExternally
    var iconPath: String? get() = definedExternally; set(value) = definedExternally
    var path: String? get() = definedExternally; set(value) = definedExternally
    var program: String? get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var type: dynamic /* Any /* "task" */ | Any /* "separator" */ | Any /* "file" */ */ get() = definedExternally; set(value) = definedExternally
}

external interface MemoryInfo {
    var peakWorkingSetSize: Number
    var pid: Number
    var privateBytes: Number
    var sharedBytes: Number
    var workingSetSize: Number
}

external interface MemoryUsageDetails {
    var count: Number
    var liveSize: Number
    var size: Number
}

external interface MimeTypedBuffer {
    var data: Buffer
    var mimeType: String
}

external open class NativeImage {
    open fun addRepresentation(options: AddRepresentationOptions): Unit = definedExternally
    open fun crop(rect: Rectangle): NativeImage = definedExternally
    open fun getAspectRatio(): Number = definedExternally
    open fun getBitmap(options: BitmapOptions? = definedExternally /* null */): Buffer = definedExternally
    open fun getNativeHandle(): Buffer = definedExternally
    open fun getSize(): Size = definedExternally
    open fun isEmpty(): Boolean = definedExternally
    open fun isTemplateImage(): Boolean = definedExternally
    open fun resize(options: ResizeOptions): NativeImage = definedExternally
    open fun setTemplateImage(option: Boolean): Unit = definedExternally
    open fun toBitmap(options: ToBitmapOptions? = definedExternally /* null */): Buffer = definedExternally
    open fun toDataURL(options: ToDataURLOptions? = definedExternally /* null */): String = definedExternally
    open fun toJPEG(quality: Number): Buffer = definedExternally
    open fun toPNG(options: ToPNGOptions? = definedExternally /* null */): Buffer = definedExternally

    companion object {
        fun createEmpty(): NativeImage = definedExternally
        fun createFromBuffer(buffer: Buffer, options: CreateFromBufferOptions? = definedExternally /* null */): NativeImage = definedExternally
        fun createFromDataURL(dataURL: String): NativeImage = definedExternally
        fun createFromPath(path: String): NativeImage = definedExternally
    }
}

external interface Net : EventEmitter {
    fun request(options: Any): Electron.ClientRequest
    fun request(options: String): Electron.ClientRequest
}

external interface Point {
    var x: Number
    var y: Number
}

external interface PowerMonitor : EventEmitter {
    fun on(event: Any /* "on-ac" */, listener: Function<*>): PowerMonitor /* this */
    fun once(event: Any /* "on-ac" */, listener: Function<*>): PowerMonitor /* this */
    fun addListener(event: Any /* "on-ac" */, listener: Function<*>): PowerMonitor /* this */
    fun removeListener(event: Any /* "on-ac" */, listener: Function<*>): PowerMonitor /* this */
}

external interface PowerSaveBlocker : EventEmitter {
    fun isStarted(id: Number): Boolean
    fun start(type: Any /* "prevent-app-suspension" */): Number
    fun start(type: Any /* "prevent-display-sleep" */): Number
    fun stop(id: Number)
}

external interface ProcessMemoryInfo {
    var memory: MemoryInfo
    var pid: Number
    var workingSetSize: Number
    var peakWorkingSetSize: Number
    var privateBytes: Number
    var sharedBytes: Number
}

external interface Protocol : EventEmitter {
    fun interceptBufferProtocol(scheme: String, handler: (request: InterceptBufferProtocolRequest, callback: (buffer: Buffer? /*= null*/) -> Unit) -> Unit, completion: ((error: Error) -> Unit)? = definedExternally /* null */)
    fun interceptFileProtocol(scheme: String, handler: (request: InterceptFileProtocolRequest, callback: (filePath: String) -> Unit) -> Unit, completion: ((error: Error) -> Unit)? = definedExternally /* null */)
    fun interceptHttpProtocol(scheme: String, handler: (request: InterceptHttpProtocolRequest, callback: (redirectRequest: RedirectRequest) -> Unit) -> Unit, completion: ((error: Error) -> Unit)? = definedExternally /* null */)
    fun interceptStringProtocol(scheme: String, handler: (request: InterceptStringProtocolRequest, callback: (data: String? /*= null*/) -> Unit) -> Unit, completion: ((error: Error) -> Unit)? = definedExternally /* null */)
    fun isProtocolHandled(scheme: String, callback: (error: Error) -> Unit)
    fun registerBufferProtocol(scheme: String, handler: (request: RegisterBufferProtocolRequest, callback: (buffer: Buffer? /*= null*/) -> Unit) -> Unit, completion: ((error: Error) -> Unit)? = definedExternally /* null */)
    fun registerBufferProtocol(scheme: String, handler: (request: RegisterBufferProtocolRequest, callback: (buffer: MimeTypedBuffer? /*= null*/) -> Unit) -> Unit, completion: ((error: Error) -> Unit)? = definedExternally /* null */)
    fun registerFileProtocol(scheme: String, handler: (request: RegisterFileProtocolRequest, callback: (filePath: String? /*= null*/) -> Unit) -> Unit, completion: ((error: Error) -> Unit)? = definedExternally /* null */)
    fun registerHttpProtocol(scheme: String, handler: (request: RegisterHttpProtocolRequest, callback: (redirectRequest: RedirectRequest) -> Unit) -> Unit, completion: ((error: Error) -> Unit)? = definedExternally /* null */)
    fun registerServiceWorkerSchemes(schemes: Array<String>)
    fun registerStandardSchemes(schemes: Array<String>, options: RegisterStandardSchemesOptions? = definedExternally /* null */)
    fun registerStringProtocol(scheme: String, handler: (request: RegisterStringProtocolRequest, callback: (data: String? /*= null*/) -> Unit) -> Unit, completion: ((error: Error) -> Unit)? = definedExternally /* null */)
    fun uninterceptProtocol(scheme: String, completion: ((error: Error) -> Unit)? = definedExternally /* null */)
    fun unregisterProtocol(scheme: String, completion: ((error: Error) -> Unit)? = definedExternally /* null */)
}

external interface Rectangle {
    var height: Number
    var width: Number
    var x: Number
    var y: Number
}

external interface Remote : MainInterface {
    fun getCurrentWebContents(): WebContents
    fun getCurrentWindow(): Electron.BrowserWindow
    fun getGlobal(name: String): Any
    fun require(module: String): Any
    var process: Any? get() = definedExternally; set(value) = definedExternally
}

external interface RemoveClientCertificate {
    var origin: String
    var type: String
}

external interface RemovePassword {
    var origin: String? get() = definedExternally; set(value) = definedExternally
    var password: String? get() = definedExternally; set(value) = definedExternally
    var realm: String? get() = definedExternally; set(value) = definedExternally
    var scheme: dynamic /* Any /* "basic" */ | Any /* "digest" */ | Any /* "ntlm" */ | Any /* "negotiate" */ */ get() = definedExternally; set(value) = definedExternally
    var type: String
    var username: String? get() = definedExternally; set(value) = definedExternally
}

external interface Screen : EventEmitter {
    fun on(event: Any /* "display-added" */, listener: (event: Event, newDisplay: Display) -> Unit): Screen /* this */
    fun once(event: Any /* "display-added" */, listener: (event: Event, newDisplay: Display) -> Unit): Screen /* this */
    fun addListener(event: Any /* "display-added" */, listener: (event: Event, newDisplay: Display) -> Unit): Screen /* this */
    fun removeListener(event: Any /* "display-added" */, listener: (event: Event, newDisplay: Display) -> Unit): Screen /* this */
    fun getAllDisplays(): Array<Display>
    fun getCursorScreenPoint(): Point
    fun getDisplayMatching(rect: Rectangle): Display
    fun getDisplayNearestPoint(point: Point): Display
    fun getPrimaryDisplay(): Display
}

external interface ScrubberItem {
    var icon: NativeImage? get() = definedExternally; set(value) = definedExternally
    var label: String? get() = definedExternally; set(value) = definedExternally
}

external interface SegmentedControlSegment {
    var enabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var icon: NativeImage? get() = definedExternally; set(value) = definedExternally
    var label: String? get() = definedExternally; set(value) = definedExternally
}

external open class Session : EventEmitter {
    open fun on(event: Any /* "will-download" */, listener: (event: Event, item: Electron.DownloadItem, webContents: WebContents) -> Unit): Session /* this */ = definedExternally
    open fun once(event: Any /* "will-download" */, listener: (event: Event, item: Electron.DownloadItem, webContents: WebContents) -> Unit): Session /* this */ = definedExternally
    open fun addListener(event: Any /* "will-download" */, listener: (event: Event, item: Electron.DownloadItem, webContents: WebContents) -> Unit): Session /* this */ = definedExternally
    open fun removeListener(event: Any /* "will-download" */, listener: (event: Event, item: Electron.DownloadItem, webContents: WebContents) -> Unit): Session /* this */ = definedExternally
    open fun allowNTLMCredentialsForDomains(domains: String): Unit = definedExternally
    open fun clearAuthCache(options: RemovePassword, callback: Function<*>? = definedExternally /* null */): Unit = definedExternally
    open fun clearAuthCache(options: RemoveClientCertificate, callback: Function<*>? = definedExternally /* null */): Unit = definedExternally
    open fun clearCache(callback: Function<*>): Unit = definedExternally
    open fun clearHostResolverCache(callback: Function<*>? = definedExternally /* null */): Unit = definedExternally
    open fun clearStorageData(options: ClearStorageDataOptions? = definedExternally /* null */, callback: Function<*>? = definedExternally /* null */): Unit = definedExternally
    open fun createInterruptedDownload(options: CreateInterruptedDownloadOptions): Unit = definedExternally
    open fun disableNetworkEmulation(): Unit = definedExternally
    open fun enableNetworkEmulation(options: EnableNetworkEmulationOptions): Unit = definedExternally
    open fun flushStorageData(): Unit = definedExternally
    open fun getBlobData(identifier: String, callback: (result: Buffer) -> Unit): Blob = definedExternally
    open fun getCacheSize(callback: (size: Number) -> Unit): Unit = definedExternally
    open fun getUserAgent(): String = definedExternally
    open fun resolveProxy(url: String, callback: (proxy: String) -> Unit): Unit = definedExternally
    open fun setCertificateVerifyProc(proc: (request: CertificateVerifyProcRequest, callback: (verificationResult: Number) -> Unit) -> Unit): Unit = definedExternally
    open fun setDownloadPath(path: String): Unit = definedExternally
    open fun setPermissionRequestHandler(handler: (webContents: WebContents, permission: String, callback: (permissionGranted: Boolean) -> Unit) -> Unit): Unit = definedExternally
    open fun setProxy(config: Config, callback: Function<*>): Unit = definedExternally
    open fun setUserAgent(userAgent: String, acceptLanguages: String? = definedExternally /* null */): Unit = definedExternally
    open var cookies: Electron.Cookies = definedExternally
    open var protocol: Protocol = definedExternally
    open var webRequest: Electron.WebRequest = definedExternally

    companion object {
        fun fromPartition(partition: String, options: FromPartitionOptions): Session = definedExternally
        var defaultSession: Session = definedExternally
    }
}

external interface Shell {
    fun beep()
    fun moveItemToTrash(fullPath: String): Boolean
    fun openExternal(url: String, options: OpenExternalOptions? = definedExternally /* null */, callback: ((error: Error) -> Unit)? = definedExternally /* null */): Boolean
    fun openItem(fullPath: String): Boolean
    fun readShortcutLink(shortcutPath: String): ShortcutDetails
    fun showItemInFolder(fullPath: String): Boolean
    fun writeShortcutLink(shortcutPath: String, operation: Any /* "create" */, options: ShortcutDetails): Boolean
    fun writeShortcutLink(shortcutPath: String, operation: Any /* "update" */, options: ShortcutDetails): Boolean
    fun writeShortcutLink(shortcutPath: String, operation: Any /* "replace" */, options: ShortcutDetails): Boolean
    fun writeShortcutLink(shortcutPath: String, options: ShortcutDetails): Boolean
}

external interface ShortcutDetails {
    var appUserModelId: String? get() = definedExternally; set(value) = definedExternally
    var args: String? get() = definedExternally; set(value) = definedExternally
    var cwd: String? get() = definedExternally; set(value) = definedExternally
    var description: String? get() = definedExternally; set(value) = definedExternally
    var icon: String? get() = definedExternally; set(value) = definedExternally
    var iconIndex: Number? get() = definedExternally; set(value) = definedExternally
    var target: String
}

external interface Size {
    var height: Number
    var width: Number
}

external interface SystemPreferences : EventEmitter {
    fun on(event: Any /* "accent-color-changed" */, listener: (event: Event, newColor: String) -> Unit): SystemPreferences /* this */
    fun once(event: Any /* "accent-color-changed" */, listener: (event: Event, newColor: String) -> Unit): SystemPreferences /* this */
    fun addListener(event: Any /* "accent-color-changed" */, listener: (event: Event, newColor: String) -> Unit): SystemPreferences /* this */
    fun removeListener(event: Any /* "accent-color-changed" */, listener: (event: Event, newColor: String) -> Unit): SystemPreferences /* this */
    fun getAccentColor(): String
    fun getColor(color: dynamic /* Any /* "3d-dark-shadow" */ | Any /* "3d-face" */ | Any /* "3d-highlight" */ | Any /* "3d-light" */ | Any /* "3d-shadow" */ | Any /* "active-border" */ | Any /* "active-caption" */ | Any /* "active-caption-gradient" */ | Any /* "app-workspace" */ | Any /* "button-text" */ | Any /* "caption-text" */ | Any /* "desktop" */ | Any /* "disabled-text" */ | Any /* "highlight" */ | Any /* "highlight-text" */ | Any /* "hotlight" */ | Any /* "inactive-border" */ | Any /* "inactive-caption" */ | Any /* "inactive-caption-gradient" */ | Any /* "inactive-caption-text" */ | Any /* "node.info-background" */ | Any /* "node.info-text" */ | Any /* "menu" */ | Any /* "menu-highlight" */ | Any /* "menubar" */ | Any /* "menu-text" */ | Any /* "scrollbar" */ | Any /* "window" */ | Any /* "window-frame" */ | Any /* "window-text" */ */): String
    fun getUserDefault(key: String, type: Any /* "string" */)
    fun isAeroGlassEnabled()
    fun isDarkMode(): Boolean
    fun isInvertedColorScheme(): Boolean
    fun isSwipeTrackingFromScrollEventsEnabled(): Boolean
    fun postLocalNotification(event: String, userInfo: Any)
    fun postNotification(event: String, userInfo: Any)
    fun setUserDefault(key: String, type: String, value: String)
    fun subscribeLocalNotification(event: String, callback: (event: String, userInfo: Any) -> Unit)
    fun subscribeNotification(event: String, callback: (event: String, userInfo: Any) -> Unit)
    fun unsubscribeLocalNotification(id: Number)
    fun unsubscribeNotification(id: Number)
}

external interface Task {
    var arguments: String
    var description: String
    var iconIndex: Number
    var iconPath: String
    var program: String
    var title: String
}

external interface ThumbarButton {
    var click: Function<*>
    var flags: Array<String>? get() = definedExternally; set(value) = definedExternally
    var icon: NativeImage
    var tooltip: String? get() = definedExternally; set(value) = definedExternally
}

external open class TouchBarButton(options: TouchBarButtonConstructorOptions) : EventEmitter {
    open var backgroundColor: String = definedExternally
    open var icon: NativeImage = definedExternally
    open var label: String = definedExternally
}

external open class TouchBarColorPicker(options: TouchBarColorPickerConstructorOptions) : EventEmitter {
    open var availableColors: Array<String> = definedExternally
    open var selectedColor: String = definedExternally
}

external open class TouchBarGroup(options: TouchBarGroupConstructorOptions) : EventEmitter
external open class TouchBarLabel(options: TouchBarLabelConstructorOptions) : EventEmitter {
    open var label: String = definedExternally
    open var textColor: String = definedExternally
}

external open class TouchBarPopover(options: TouchBarPopoverConstructorOptions) : EventEmitter {
    open var icon: NativeImage = definedExternally
    open var label: String = definedExternally
}

external open class TouchBarScrubber(options: TouchBarScrubberConstructorOptions) : EventEmitter {
    open var continuous: Boolean = definedExternally
    open var items: Array<ScrubberItem> = definedExternally
    open var mode: String = definedExternally
    open var overlayStyle: String = definedExternally
    open var selectedStyle: String = definedExternally
    open var showArrowButtons: Boolean = definedExternally
}

external open class TouchBarSegmentedControl(options: TouchBarSegmentedControlConstructorOptions) : EventEmitter {
    open var segments: Array<SegmentedControlSegment> = definedExternally
    open var segmentStyle: String = definedExternally
    open var selectedIndex: Number = definedExternally
}

external open class TouchBarSlider(options: TouchBarSliderConstructorOptions) : EventEmitter {
    open var label: String = definedExternally
    open var maxValue: Number = definedExternally
    open var minValue: Number = definedExternally
    open var value: Number = definedExternally
}

external open class TouchBarSpacer(options: TouchBarSpacerConstructorOptions) : EventEmitter


external open class Tray : EventEmitter {
    constructor(image: NativeImage)
    constructor(image: String)

    open fun on(event: Any /* "balloon-click" */, listener: Function<*>): Tray /* this */ = definedExternally
    open fun once(event: Any /* "balloon-click" */, listener: Function<*>): Tray /* this */ = definedExternally
    open fun addListener(event: Any /* "balloon-click" */, listener: Function<*>): Tray /* this */ = definedExternally
    open fun removeListener(event: Any /* "balloon-click" */, listener: Function<*>): Tray /* this */ = definedExternally
    open fun destroy(): Unit = definedExternally
    open fun displayBalloon(options: DisplayBalloonOptions): Unit = definedExternally
    open fun getBounds(): Rectangle = definedExternally
    open fun isDestroyed(): Boolean = definedExternally
    open fun popUpContextMenu(menu: Electron.Menu? = definedExternally /* null */, position: Point? = definedExternally /* null */): Unit = definedExternally
    open fun setContextMenu(menu: Electron.Menu): Unit = definedExternally
    open fun setHighlightMode(mode: Any /* "selection" */): Unit = definedExternally
    open fun setHighlightMode(mode: Any /* "always" */): Unit = definedExternally
    open fun setHighlightMode(mode: Any /* "never" */): Unit = definedExternally
    open fun setImage(image: NativeImage): Unit = definedExternally
    open fun setImage(image: String): Unit = definedExternally
    open fun setPressedImage(image: NativeImage): Unit = definedExternally
    open fun setTitle(title: String): Unit = definedExternally
    open fun setToolTip(toolTip: String): Unit = definedExternally
}

external interface UploadBlob {
    var blobUUID: String
    var type: String
}

external interface UploadData {
    var blobUUID: String
    var bytes: Buffer
    var file: String
}

external interface UploadFile {
    var filePath: String
    var length: Number
    var modificationTime: Number
    var offset: Number
    var type: String
}

external interface UploadFileSystem {
    var filsSystemURL: String
    var length: Number
    var modificationTime: Number
    var offset: Number
    var type: String
}

external interface UploadRawData {
    var bytes: Buffer
    var type: String
}

external open class WebContents : EventEmitter {
    open fun on(event: Any /* "before-input-event" */, listener: (event: Event, input: Input) -> Unit): WebContents /* this */ = definedExternally
    open fun once(event: Any /* "before-input-event" */, listener: (event: Event, input: Input) -> Unit): WebContents /* this */ = definedExternally
    open fun addListener(event: Any /* "before-input-event" */, listener: (event: Event, input: Input) -> Unit): WebContents /* this */ = definedExternally
    open fun removeListener(event: Any /* "before-input-event" */, listener: (event: Event, input: Input) -> Unit): WebContents /* this */ = definedExternally
    open fun addWorkSpace(path: String): Unit = definedExternally
    open fun beginFrameSubscription(callback: (frameBuffer: Buffer, dirtyRect: Rectangle) -> Unit): Unit = definedExternally
    open fun beginFrameSubscription(onlyDirty: Boolean, callback: (frameBuffer: Buffer, dirtyRect: Rectangle) -> Unit): Unit = definedExternally
    open fun canGoBack(): Boolean = definedExternally
    open fun canGoForward(): Boolean = definedExternally
    open fun canGoToOffset(offset: Number): Boolean = definedExternally
    open fun capturePage(rect: Rectangle, callback: (image: NativeImage) -> Unit): Unit = definedExternally
    open fun capturePage(callback: (image: NativeImage) -> Unit): Unit = definedExternally
    open fun clearHistory(): Unit = definedExternally
    open fun closeDevTools(): Unit = definedExternally
    open fun copy(): Unit = definedExternally
    open fun copyImageAt(x: Number, y: Number): Unit = definedExternally
    open fun cut(): Unit = definedExternally
    open fun delete(): Unit = definedExternally
    open fun disableDeviceEmulation(): Unit = definedExternally
    open fun downloadURL(url: String): Unit = definedExternally
    open fun enableDeviceEmulation(parameters: Parameters): Unit = definedExternally
    open fun endFrameSubscription(): Unit = definedExternally
    open fun executeJavaScript(code: String, userGesture: Boolean? = definedExternally /* null */, callback: ((result: Any) -> Unit)? = definedExternally /* null */): Promise<Any> = definedExternally
    open fun findInPage(text: String, options: FindInPageOptions? = definedExternally /* null */): Unit = definedExternally
    open fun getFrameRate(): Number = definedExternally
    open fun getOSProcessId(): Number = definedExternally
    open fun getTitle(): String = definedExternally
    open fun getURL(): String = definedExternally
    open fun getUserAgent(): String = definedExternally
    open fun getWebRTCIPHandlingPolicy(): String = definedExternally
    open fun getZoomFactor(callback: (zoomFactor: Number) -> Unit): Unit = definedExternally
    open fun getZoomLevel(callback: (zoomLevel: Number) -> Unit): Unit = definedExternally
    open fun goBack(): Unit = definedExternally
    open fun goForward(): Unit = definedExternally
    open fun goToIndex(index: Number): Unit = definedExternally
    open fun goToOffset(offset: Number): Unit = definedExternally
    open fun hasServiceWorker(callback: (hasWorker: Boolean) -> Unit): Unit = definedExternally
    open fun insertCSS(css: String): Unit = definedExternally
    open fun insertText(text: String): Unit = definedExternally
    open fun inspectElement(x: Number, y: Number): Unit = definedExternally
    open fun inspectServiceWorker(): Unit = definedExternally
    open fun invalidate(): Unit = definedExternally
    open fun isAudioMuted(): Boolean = definedExternally
    open fun isCrashed(): Boolean = definedExternally
    open fun isDestroyed(): Boolean = definedExternally
    open fun isDevToolsFocused(): Boolean = definedExternally
    open fun isDevToolsOpened(): Boolean = definedExternally
    open fun isFocused(): Boolean = definedExternally
    open fun isLoading(): Boolean = definedExternally
    open fun isLoadingMainFrame(): Boolean = definedExternally
    open fun isOffscreen(): Boolean = definedExternally
    open fun isPainting(): Boolean = definedExternally
    open fun isWaitingForResponse(): Boolean = definedExternally
    open fun loadURL(url: String, options: LoadURLOptions? = definedExternally /* null */): Unit = definedExternally
    open fun openDevTools(options: OpenDevToolsOptions? = definedExternally /* null */): Unit = definedExternally
    open fun paste(): Unit = definedExternally
    open fun pasteAndMatchStyle(): Unit = definedExternally
    open fun print(options: PrintOptions? = definedExternally /* null */): Unit = definedExternally
    open fun printToPDF(options: PrintToPDFOptions, callback: (error: Error, data: Buffer) -> Unit): Unit = definedExternally
    open fun redo(): Unit = definedExternally
    open fun reload(): Unit = definedExternally
    open fun reloadIgnoringCache(): Unit = definedExternally
    open fun removeWorkSpace(path: String): Unit = definedExternally
    open fun replace(text: String): Unit = definedExternally
    open fun replaceMisspelling(text: String): Unit = definedExternally
    open fun savePage(fullPath: String, saveType: Any /* "HTMLOnly" */, callback: (error: Error) -> Unit): Boolean = definedExternally
    open fun savePage(fullPath: String, saveType: Any /* "HTMLComplete" */, callback: (error: Error) -> Unit): Boolean = definedExternally
    open fun savePage(fullPath: String, saveType: Any /* "MHTML" */, callback: (error: Error) -> Unit): Boolean = definedExternally
    open fun selectAll(): Unit = definedExternally
    open fun send(channel: String, vararg args: Any): Unit = definedExternally
    open fun sendInputEvent(event: Event): Unit = definedExternally
    open fun setAudioMuted(muted: Boolean): Unit = definedExternally
    open fun setFrameRate(fps: Number): Unit = definedExternally
    open fun setLayoutZoomLevelLimits(minimumLevel: Number, maximumLevel: Number): Unit = definedExternally
    open fun setSize(options: SizeOptions): Unit = definedExternally
    open fun setUserAgent(userAgent: String): Unit = definedExternally
    open fun setVisualZoomLevelLimits(minimumLevel: Number, maximumLevel: Number): Unit = definedExternally
    open fun setWebRTCIPHandlingPolicy(policy: Any /* "default" */): Unit = definedExternally
    open fun setWebRTCIPHandlingPolicy(policy: Any /* "default_public_interface_only" */): Unit = definedExternally
    open fun setWebRTCIPHandlingPolicy(policy: Any /* "default_public_and_private_interfaces" */): Unit = definedExternally
    open fun setWebRTCIPHandlingPolicy(policy: Any /* "disable_non_proxied_udp" */): Unit = definedExternally
    open fun setZoomFactor(factor: Number): Unit = definedExternally
    open fun setZoomLevel(level: Number): Unit = definedExternally
    open fun setZoomLevelLimits(minimumLevel: Number, maximumLevel: Number): Unit = definedExternally
    open fun showDefinitionForSelection(): Unit = definedExternally
    open fun startDrag(item: Item): Unit = definedExternally
    open fun startPainting(): Unit = definedExternally
    open fun stop(): Unit = definedExternally
    open fun stopFindInPage(action: Any /* "clearSelection" */): Unit = definedExternally
    open fun stopFindInPage(action: Any /* "keepSelection" */): Unit = definedExternally
    open fun stopFindInPage(action: Any /* "activateSelection" */): Unit = definedExternally
    open fun stopPainting(): Unit = definedExternally
    open fun toggleDevTools(): Unit = definedExternally
    open fun undo(): Unit = definedExternally
    open fun unregisterServiceWorker(callback: (success: Boolean) -> Unit): Unit = definedExternally
    open fun unselect(): Unit = definedExternally
    open var debugger: Electron.Debugger = definedExternally
    open var devToolsWebContents: WebContents = definedExternally
    open var hostWebContents: WebContents = definedExternally
    open var id: Number = definedExternally
    open var session: Session = definedExternally

    companion object {
        fun fromId(id: Number): WebContents = definedExternally
        fun getAllWebContents(): Array<WebContents> = definedExternally
        fun getFocusedWebContents(): WebContents = definedExternally
    }
}

external interface WebFrame : EventEmitter {
    fun clearCache()
    fun executeJavaScript(code: String, userGesture: Boolean? = definedExternally /* null */, callback: ((result: Any) -> Unit)? = definedExternally /* null */): Promise<Any>
    fun getResourceUsage(): ResourceUsage
    fun getZoomFactor(): Number
    fun getZoomLevel(): Number
    fun insertText(text: String)
    fun registerURLSchemeAsBypassingCSP(scheme: String)
    fun registerURLSchemeAsPrivileged(scheme: String, options: RegisterURLSchemeAsPrivilegedOptions? = definedExternally /* null */)
    fun registerURLSchemeAsSecure(scheme: String)
    fun setLayoutZoomLevelLimits(minimumLevel: Number, maximumLevel: Number)
    fun setSpellCheckProvider(language: String, autoCorrectWord: Boolean, provider: Provider)
    fun setVisualZoomLevelLimits(minimumLevel: Number, maximumLevel: Number)
    fun setZoomFactor(factor: Number)
    fun setZoomLevel(level: Number)
    fun setZoomLevelLimits(minimumLevel: Number, maximumLevel: Number)
}


external interface WebviewTag : HTMLElement {
    fun addEventListener(event: Any /* "load-commit" */, listener: (event: LoadCommitEvent) -> Unit, useCapture: Boolean? = definedExternally /* null */): WebviewTag /* this */
    fun removeEventListener(event: Any /* "load-commit" */, listener: (event: LoadCommitEvent) -> Unit): WebviewTag /* this */
    fun canGoBack(): Boolean
    fun canGoForward(): Boolean
    fun canGoToOffset(offset: Number): Boolean
    fun capturePage(callback: (image: NativeImage) -> Unit)
    fun capturePage(rect: Rectangle, callback: (image: NativeImage) -> Unit)
    fun clearHistory()
    fun closeDevTools()
    fun copy()
    fun cut()
    fun delete()
    fun executeJavaScript(code: String, userGesture: Boolean, callback: ((result: Any) -> Unit)? = definedExternally /* null */)
    fun findInPage(text: String, options: FindInPageOptions? = definedExternally /* null */)
    fun getTitle(): String
    fun getURL(): String
    fun getUserAgent(): String
    fun getWebContents(): WebContents
    fun goBack()
    fun goForward()
    fun goToIndex(index: Number)
    fun goToOffset(offset: Number)
    fun insertCSS(css: String)
    fun insertText(text: String)
    fun inspectElement(x: Number, y: Number)
    fun inspectServiceWorker()
    fun isAudioMuted(): Boolean
    fun isCrashed(): Boolean
    fun isDevToolsFocused(): Boolean
    fun isDevToolsOpened(): Boolean
    fun isLoading(): Boolean
    fun isWaitingForResponse(): Boolean
    fun loadURL(url: String, options: LoadURLOptions? = definedExternally /* null */)
    fun openDevTools()
    fun paste()
    fun pasteAndMatchStyle()
    fun print(options: PrintOptions? = definedExternally /* null */)
    fun printToPDF(options: PrintToPDFOptions, callback: (error: Error, data: Buffer) -> Unit)
    fun redo()
    fun reload()
    fun reloadIgnoringCache()
    fun replace(text: String)
    fun replaceMisspelling(text: String)
    fun selectAll()
    fun send(channel: String, vararg args: Any)
    fun sendInputEvent(event: Any)
    fun setAudioMuted(muted: Boolean)
    fun setUserAgent(userAgent: String)
    fun setZoomFactor(factor: Number)
    fun setZoomLevel(level: Number)
    fun showDefinitionForSelection()
    fun stop()
    fun stopFindInPage(action: Any /* "clearSelection" */)
    fun stopFindInPage(action: Any /* "keepSelection" */)
    fun stopFindInPage(action: Any /* "activateSelection" */)
    fun undo()
    fun unselect()
    var allowpopups: String? get() = definedExternally; set(value) = definedExternally
    var autosize: String? get() = definedExternally; set(value) = definedExternally
    var blinkfeatures: String? get() = definedExternally; set(value) = definedExternally
    var disableblinkfeatures: String? get() = definedExternally; set(value) = definedExternally
    var disableguestresize: String? get() = definedExternally; set(value) = definedExternally
    var disablewebsecurity: String? get() = definedExternally; set(value) = definedExternally
    var guestinstance: String? get() = definedExternally; set(value) = definedExternally
    var httpreferrer: String? get() = definedExternally; set(value) = definedExternally
    var nodeintegration: String? get() = definedExternally; set(value) = definedExternally
    var partition: String? get() = definedExternally; set(value) = definedExternally
    var plugins: String? get() = definedExternally; set(value) = definedExternally
    var preload: String? get() = definedExternally; set(value) = definedExternally
    var src: String? get() = definedExternally; set(value) = definedExternally
    var useragent: String? get() = definedExternally; set(value) = definedExternally
    var webpreferences: String? get() = definedExternally; set(value) = definedExternally
}

fun BrowserWindowConstructorOptions(): BrowserWindowConstructorOptions = js("return {}")

external interface AboutPanelOptionsOptions {
    var applicationName: String? get() = definedExternally; set(value) = definedExternally
    var applicationVersion: String? get() = definedExternally; set(value) = definedExternally
    var copyright: String? get() = definedExternally; set(value) = definedExternally
    var credits: String? get() = definedExternally; set(value) = definedExternally
    var version: String? get() = definedExternally; set(value) = definedExternally
}

external interface AddRepresentationOptions {
    var scaleFactor: Number
    var width: Number? get() = definedExternally; set(value) = definedExternally
    var height: Number? get() = definedExternally; set(value) = definedExternally
    var buffer: Buffer? get() = definedExternally; set(value) = definedExternally
    var dataURL: String? get() = definedExternally; set(value) = definedExternally
}

external interface AppDetailsOptions {
    var appId: String? get() = definedExternally; set(value) = definedExternally
    var appIconPath: String? get() = definedExternally; set(value) = definedExternally
    var appIconIndex: Number? get() = definedExternally; set(value) = definedExternally
    var relaunchCommand: String? get() = definedExternally; set(value) = definedExternally
    var relaunchDisplayName: String? get() = definedExternally; set(value) = definedExternally
}

external interface AuthInfo {
    var isProxy: Boolean
    var scheme: String
    var host: String
    var port: Number
    var realm: String
}

external interface AutoResizeOptions {
    var width: Boolean
    var height: Boolean
}

external interface BitmapOptions {
    var scaleFactor: Number? get() = definedExternally; set(value) = definedExternally
}

external interface BrowserViewConstructorOptions {
    var webPreferences: WebPreferences? get() = definedExternally; set(value) = definedExternally
}

external interface BrowserWindowConstructorOptions {
    var width: Number? get() = definedExternally; set(value) = definedExternally
    var height: Number? get() = definedExternally; set(value) = definedExternally
    var x: Number? get() = definedExternally; set(value) = definedExternally
    var y: Number? get() = definedExternally; set(value) = definedExternally
    var useContentSize: Boolean? get() = definedExternally; set(value) = definedExternally
    var center: Boolean? get() = definedExternally; set(value) = definedExternally
    var minWidth: Number? get() = definedExternally; set(value) = definedExternally
    var minHeight: Number? get() = definedExternally; set(value) = definedExternally
    var maxWidth: Number? get() = definedExternally; set(value) = definedExternally
    var maxHeight: Number? get() = definedExternally; set(value) = definedExternally
    var resizable: Boolean? get() = definedExternally; set(value) = definedExternally
    var movable: Boolean? get() = definedExternally; set(value) = definedExternally
    var minimizable: Boolean? get() = definedExternally; set(value) = definedExternally
    var maximizable: Boolean? get() = definedExternally; set(value) = definedExternally
    var closable: Boolean? get() = definedExternally; set(value) = definedExternally
    var focusable: Boolean? get() = definedExternally; set(value) = definedExternally
    var alwaysOnTop: Boolean? get() = definedExternally; set(value) = definedExternally
    var fullscreen: Boolean? get() = definedExternally; set(value) = definedExternally
    var fullscreenable: Boolean? get() = definedExternally; set(value) = definedExternally
    var skipTaskbar: Boolean? get() = definedExternally; set(value) = definedExternally
    var kiosk: Boolean? get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var icon: dynamic /* NativeImage | String */ get() = definedExternally; set(value) = definedExternally
    var show: Boolean? get() = definedExternally; set(value) = definedExternally
    var frame: Boolean? get() = definedExternally; set(value) = definedExternally
    var parent: Electron.BrowserWindow? get() = definedExternally; set(value) = definedExternally
    var modal: Boolean? get() = definedExternally; set(value) = definedExternally
    var acceptFirstMouse: Boolean? get() = definedExternally; set(value) = definedExternally
    var disableAutoHideCursor: Boolean? get() = definedExternally; set(value) = definedExternally
    var autoHideMenuBar: Boolean? get() = definedExternally; set(value) = definedExternally
    var enableLargerThanScreen: Boolean? get() = definedExternally; set(value) = definedExternally
    var backgroundColor: String? get() = definedExternally; set(value) = definedExternally
    var hasShadow: Boolean? get() = definedExternally; set(value) = definedExternally
    var darkTheme: Boolean? get() = definedExternally; set(value) = definedExternally
    var transparent: Boolean? get() = definedExternally; set(value) = definedExternally
    var type: String? get() = definedExternally; set(value) = definedExternally
    var titleBarStyle: dynamic /* Any /* "default" */ | Any /* "hidden" */ | Any /* "hidden-inset" */ */ get() = definedExternally; set(value) = definedExternally
    var thickFrame: Boolean? get() = definedExternally; set(value) = definedExternally
    var vibrancy: dynamic /* Any /* "appearance-based" */ | Any /* "light" */ | Any /* "dark" */ | Any /* "titlebar" */ | Any /* "selection" */ | Any /* "menu" */ | Any /* "popover" */ | Any /* "sidebar" */ | Any /* "medium-light" */ | Any /* "ultra-dark" */ */ get() = definedExternally; set(value) = definedExternally
    var zoomToPageWidth: Boolean? get() = definedExternally; set(value) = definedExternally
    var tabbingIdentifier: String? get() = definedExternally; set(value) = definedExternally
    var webPreferences: WebPreferences? get() = definedExternally; set(value) = definedExternally
}

external interface CertificateTrustDialogOptions {
    var certificate: Certificate
    var message: String
}

external interface CertificateVerifyProcRequest {
    var hostname: String
    var certificate: Certificate
    var error: String
}

external interface ClearStorageDataOptions {
    var origin: String
    var storages: Array<String>
    var quotas: Array<String>
}

external interface CommandLine {
    var appendSwitch: (the_switch: String, value: String? /*= null*/) -> Unit
    var appendArgument: (value: String) -> Unit
}

external interface Config {
    var pacScript: String
    var proxyRules: String
    var proxyBypassRules: String
}

external interface ConsoleMessageEvent : Event {
    var level: Number
    var message: String
    var line: Number
    var sourceId: String
}

external interface ContextMenuParams {
    var x: Number
    var y: Number
    var linkURL: String
    var linkText: String
    var pageURL: String
    var frameURL: String
    var srcURL: String
    var mediaType: dynamic /* Any /* "none" */ | Any /* "image" */ | Any /* "audio" */ | Any /* "video" */ | Any /* "canvas" */ | Any /* "file" */ | Any /* "plugin" */ */
    var hasImageContents: Boolean
    var isEditable: Boolean
    var selectionText: String
    var titleText: String
    var misspelledWord: String
    var frameCharset: String
    var inputFieldType: String
    var menuSourceType: dynamic /* Any /* "none" */ | Any /* "mouse" */ | Any /* "keyboard" */ | Any /* "touch" */ | Any /* "touchMenu" */ */
    var mediaFlags: MediaFlags
    var editFlags: EditFlags
}

external interface CrashReporterStartOptions {
    var companyName: String? get() = definedExternally; set(value) = definedExternally
    var submitURL: String
    var productName: String? get() = definedExternally; set(value) = definedExternally
    var uploadToServer: Boolean? get() = definedExternally; set(value) = definedExternally
    var ignoreSystemCrashHandler: Boolean? get() = definedExternally; set(value) = definedExternally
    var extra: Extra? get() = definedExternally; set(value) = definedExternally
}

external interface CreateFromBufferOptions {
    var width: Number? get() = definedExternally; set(value) = definedExternally
    var height: Number? get() = definedExternally; set(value) = definedExternally
    var scaleFactor: Number? get() = definedExternally; set(value) = definedExternally
}

external interface CreateInterruptedDownloadOptions {
    var path: String
    var urlChain: Array<String>
    var mimeType: String? get() = definedExternally; set(value) = definedExternally
    var offset: Number
    var length: Number
    var lastModified: String
    var eTag: String
    var startTime: Number? get() = definedExternally; set(value) = definedExternally
}

external interface Data {
    var text: String? get() = definedExternally; set(value) = definedExternally
    var html: String? get() = definedExternally; set(value) = definedExternally
    var image: NativeImage? get() = definedExternally; set(value) = definedExternally
    var rtf: String? get() = definedExternally; set(value) = definedExternally
    var bookmark: String? get() = definedExternally; set(value) = definedExternally
}

external interface Details {
    var url: String
    var name: String? get() = definedExternally; set(value) = definedExternally
    var value: String? get() = definedExternally; set(value) = definedExternally
    var domain: String? get() = definedExternally; set(value) = definedExternally
    var path: String? get() = definedExternally; set(value) = definedExternally
    var secure: Boolean? get() = definedExternally; set(value) = definedExternally
    var httpOnly: Boolean? get() = definedExternally; set(value) = definedExternally
    var expirationDate: Number? get() = definedExternally; set(value) = definedExternally
}

external interface DevToolsExtensions
external interface DidChangeThemeColorEvent : Event {
    var themeColor: String
}

external interface DidFailLoadEvent : Event {
    var errorCode: Number
    var errorDescription: String
    var validatedURL: String
    var isMainFrame: Boolean
}

external interface DidFrameFinishLoadEvent : Event {
    var isMainFrame: Boolean
}

external interface DidGetRedirectRequestEvent : Event {
    var oldURL: String
    var newURL: String
    var isMainFrame: Boolean
}

external interface DidGetResponseDetailsEvent : Event {
    var status: Boolean
    var newURL: String
    var originalURL: String
    var httpResponseCode: Number
    var requestMethod: String
    var referrer: String
    var headers: Headers
    var resourceType: String
}

external interface DidNavigateEvent : Event {
    var url: String
}

external interface DidNavigateInPageEvent : Event {
    var isMainFrame: Boolean
    var url: String
}

external interface DisplayBalloonOptions {
    var icon: dynamic /* NativeImage | String */ get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var content: String? get() = definedExternally; set(value) = definedExternally
}

external interface Dock {
    var bounce: (type: dynamic /* Any /* "critical" */ | Any /* "informational" */ */ /*= null*/) -> Number
    var cancelBounce: (id: Number) -> Unit
    var downloadFinished: (filePath: String) -> Unit
    var setBadge: (text: String) -> Unit
    var getBadge: () -> String
    var hide: () -> Unit
    var show: () -> Unit
    var isVisible: () -> Boolean
    var setMenu: (menu: Electron.Menu) -> Unit
    var setIcon: (image: dynamic /* NativeImage | String */) -> Unit
}

external interface EnableNetworkEmulationOptions {
    var offline: Boolean? get() = definedExternally; set(value) = definedExternally
    var latency: Number? get() = definedExternally; set(value) = definedExternally
    var downloadThroughput: Number? get() = definedExternally; set(value) = definedExternally
    var uploadThroughput: Number? get() = definedExternally; set(value) = definedExternally
}

external interface FileIconOptions {
    var size: dynamic /* Any /* "small" */ | Any /* "normal" */ | Any /* "large" */ */
}

external interface Filter {
    var url: String? get() = definedExternally; set(value) = definedExternally
    var name: String? get() = definedExternally; set(value) = definedExternally
    var domain: String? get() = definedExternally; set(value) = definedExternally
    var path: String? get() = definedExternally; set(value) = definedExternally
    var secure: Boolean? get() = definedExternally; set(value) = definedExternally
    var session: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface FindInPageOptions {
    var forward: Boolean? get() = definedExternally; set(value) = definedExternally
    var findNext: Boolean? get() = definedExternally; set(value) = definedExternally
    var matchCase: Boolean? get() = definedExternally; set(value) = definedExternally
    var wordStart: Boolean? get() = definedExternally; set(value) = definedExternally
    var medialCapitalAsWordStart: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface FoundInPageEvent : Event {
    var result: FoundInPageResult
}

external interface FromPartitionOptions {
    var cache: Boolean
}

external interface ImportCertificateOptions {
    var certificate: String
    var password: String
}

external interface Input {
    var type: String
    var key: String
    var code: String
    var isAutoRepeat: Boolean
    var shift: Boolean
    var control: Boolean
    var alt: Boolean
    var meta: Boolean
}

external interface InterceptBufferProtocolRequest {
    var url: String
    var referrer: String
    var method: String
    var uploadData: Array<UploadData>
}

external interface InterceptFileProtocolRequest {
    var url: String
    var referrer: String
    var method: String
    var uploadData: Array<UploadData>
}

external interface InterceptHttpProtocolRequest {
    var url: String
    var referrer: String
    var method: String
    var uploadData: Array<UploadData>
}

external interface InterceptStringProtocolRequest {
    var url: String
    var referrer: String
    var method: String
    var uploadData: Array<UploadData>
}

external interface IpcMessageEvent : Event {
    var channel: String
    var args: Array<Any>
}

external interface Item {
    var file: String
    var icon: NativeImage
}

external interface JumpListSettings {
    var minItems: Number
    var removedItems: Array<JumpListItem>
}

external interface LoadCommitEvent : Event {
    var url: String
    var isMainFrame: Boolean
}

external interface LoadURLOptions {
    var httpReferrer: String? get() = definedExternally; set(value) = definedExternally
    var userAgent: String? get() = definedExternally; set(value) = definedExternally
    var extraHeaders: String? get() = definedExternally; set(value) = definedExternally
    var postData: dynamic /* Array<UploadRawData> | Array<UploadFile> | Array<UploadFileSystem> | Array<UploadBlob> */ get() = definedExternally; set(value) = definedExternally
    var baseURLForDataURL: String? get() = definedExternally; set(value) = definedExternally
}

external interface LoginItemSettings {
    var options: Options? get() = definedExternally; set(value) = definedExternally
    var openAtLogin: Boolean
    var openAsHidden: Boolean
    var wasOpenedAtLogin: Boolean
    var wasOpenedAsHidden: Boolean
    var restoreState: Boolean
}

external interface LoginItemSettingsOptions {
    var path: String? get() = definedExternally; set(value) = definedExternally
    var args: Array<String>? get() = definedExternally; set(value) = definedExternally
}

external interface MenuItemConstructorOptions {
    var click: ((menuItem: Electron.MenuItem, browserWindow: Electron.BrowserWindow, event: Event) -> Unit)? get() = definedExternally; set(value) = definedExternally
    var role: String? get() = definedExternally; set(value) = definedExternally
    var type: dynamic /* Any /* "normal" */ | Any /* "separator" */ | Any /* "submenu" */ | Any /* "checkbox" */ | Any /* "radio" */ */ get() = definedExternally; set(value) = definedExternally
    var label: String? get() = definedExternally; set(value) = definedExternally
    var sublabel: String? get() = definedExternally; set(value) = definedExternally
    var accelerator: Accelerator? get() = definedExternally; set(value) = definedExternally
    var icon: dynamic /* NativeImage | String */ get() = definedExternally; set(value) = definedExternally
    var enabled: Boolean? get() = definedExternally; set(value) = definedExternally
    var visible: Boolean? get() = definedExternally; set(value) = definedExternally
    var checked: Boolean? get() = definedExternally; set(value) = definedExternally
    var submenu: dynamic /* Array<MenuItemConstructorOptions> | Menu */ get() = definedExternally; set(value) = definedExternally
    var id: String? get() = definedExternally; set(value) = definedExternally
    var position: String? get() = definedExternally; set(value) = definedExternally
}

external interface MessageBoxOptions {
    var type: String? get() = definedExternally; set(value) = definedExternally
    var buttons: Array<String>? get() = definedExternally; set(value) = definedExternally
    var defaultId: Number? get() = definedExternally; set(value) = definedExternally
    var title: String? get() = definedExternally; set(value) = definedExternally
    var message: String
    var detail: String? get() = definedExternally; set(value) = definedExternally
    var checkboxLabel: String? get() = definedExternally; set(value) = definedExternally
    var checkboxChecked: Boolean? get() = definedExternally; set(value) = definedExternally
    var icon: NativeImage? get() = definedExternally; set(value) = definedExternally
    var cancelId: Number? get() = definedExternally; set(value) = definedExternally
    var noLink: Boolean? get() = definedExternally; set(value) = definedExternally
    var normalizeAccessKeys: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface NewWindowEvent : Event {
    var url: String
    var frameName: String
    var disposition: dynamic /* Any /* "default" */ | Any /* "foreground-tab" */ | Any /* "background-tab" */ | Any /* "new-window" */ | Any /* "save-to-disk" */ | Any /* "other" */ */
    var options: Options
}

external interface OnBeforeRedirectDetails {
    var id: String
    var url: String
    var method: String
    var resourceType: String
    var timestamp: Number
    var redirectURL: String
    var statusCode: Number
    var ip: String? get() = definedExternally; set(value) = definedExternally
    var fromCache: Boolean
    var responseHeaders: ResponseHeaders
}

external interface OnBeforeRedirectFilter {
    var urls: Array<String>
}

external interface OnBeforeRequestDetails {
    var id: Number
    var url: String
    var method: String
    var resourceType: String
    var timestamp: Number
    var uploadData: Array<UploadData>
}

external interface OnBeforeRequestFilter {
    var urls: Array<String>
}

external interface OnBeforeSendHeadersFilter {
    var urls: Array<String>
}

external interface OnCompletedDetails {
    var id: Number
    var url: String
    var method: String
    var resourceType: String
    var timestamp: Number
    var responseHeaders: ResponseHeaders
    var fromCache: Boolean
    var statusCode: Number
    var statusLine: String
}

external interface OnCompletedFilter {
    var urls: Array<String>
}

external interface OnErrorOccurredDetails {
    var id: Number
    var url: String
    var method: String
    var resourceType: String
    var timestamp: Number
    var fromCache: Boolean
    var error: String
}

external interface OnErrorOccurredFilter {
    var urls: Array<String>
}

external interface OnHeadersReceivedFilter {
    var urls: Array<String>
}

external interface OnResponseStartedDetails {
    var id: Number
    var url: String
    var method: String
    var resourceType: String
    var timestamp: Number
    var responseHeaders: ResponseHeaders
    var fromCache: Boolean
    var statusCode: Number
    var statusLine: String
}

external interface OnResponseStartedFilter {
    var urls: Array<String>
}

external interface OnSendHeadersDetails {
    var id: Number
    var url: String
    var method: String
    var resourceType: String
    var timestamp: Number
    var requestHeaders: RequestHeaders
}

external interface OnSendHeadersFilter {
    var urls: Array<String>
}

external interface OpenDevToolsOptions {
    var mode: dynamic /* Any /* "right" */ | Any /* "bottom" */ | Any /* "undocked" */ | Any /* "detach" */ */
}

external interface OpenDialogOptions {
    var title: String? get() = definedExternally; set(value) = definedExternally
    var defaultPath: String? get() = definedExternally; set(value) = definedExternally
    var buttonLabel: String? get() = definedExternally; set(value) = definedExternally
    var filters: Array<FileFilter>? get() = definedExternally; set(value) = definedExternally
    var properties: Array<dynamic /* Any /* "openFile" */ | Any /* "openDirectory" */ | Any /* "multiSelections" */ | Any /* "showHiddenFiles" */ | Any /* "createDirectory" */ | Any /* "promptToCreate" */ | Any /* "noResolveAliases" */ */>? get() = definedExternally; set(value) = definedExternally
    var message: String? get() = definedExternally; set(value) = definedExternally
}

external interface OpenExternalOptions {
    var activate: Boolean
}

external interface PageFaviconUpdatedEvent : Event {
    var favicons: Array<String>
}

external interface PageTitleUpdatedEvent : Event {
    var title: String
    var explicitSet: Boolean
}

external interface Parameters {
    var screenPosition: dynamic /* Any /* "desktop" */ | Any /* "mobile" */ */
    var screenSize: Size
    var viewPosition: Point
    var deviceScaleFactor: Number
    var viewSize: Size
    var fitToView: Boolean
    var offset: Point
    var scale: Number
}

external interface PluginCrashedEvent : Event {
    var name: String
    var version: String
}

external interface PopupOptions {
    var x: Number? get() = definedExternally; set(value) = definedExternally
    var y: Number
    var async: Boolean? get() = definedExternally; set(value) = definedExternally
    var positioningItem: Number? get() = definedExternally; set(value) = definedExternally
}

external interface PrintOptions {
    var silent: Boolean
    var printBackground: Boolean
}

external interface PrintToPDFOptions {
    var marginsType: Number? get() = definedExternally; set(value) = definedExternally
    var pageSize: String? get() = definedExternally; set(value) = definedExternally
    var printBackground: Boolean? get() = definedExternally; set(value) = definedExternally
    var printSelectionOnly: Boolean? get() = definedExternally; set(value) = definedExternally
    var landscape: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface ProgressBarOptions {
    var mode: dynamic /* Any /* "none" */ | Any /* "normal" */ | Any /* "indeterminate" */ | Any /* "error" */ */
}

external interface Provider {
    var spellCheck: (text: String) -> Unit
}

external interface ReadBookmark {
    var title: String
    var url: String
}

external interface RedirectRequest {
    var url: String
    var method: String
    var session: Session? get() = definedExternally; set(value) = definedExternally
    var uploadData: UploadData? get() = definedExternally; set(value) = definedExternally
}

external interface RegisterBufferProtocolRequest {
    var url: String
    var referrer: String
    var method: String
    var uploadData: Array<UploadData>
}

external interface RegisterFileProtocolRequest {
    var url: String
    var referrer: String
    var method: String
    var uploadData: Array<UploadData>
}

external interface RegisterHttpProtocolRequest {
    var url: String
    var referrer: String
    var method: String
    var uploadData: Array<UploadData>
}

external interface RegisterStandardSchemesOptions {
    var secure: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface RegisterStringProtocolRequest {
    var url: String
    var referrer: String
    var method: String
    var uploadData: Array<UploadData>
}

external interface RegisterURLSchemeAsPrivilegedOptions {
    var secure: Boolean? get() = definedExternally; set(value) = definedExternally
    var bypassCSP: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowServiceWorkers: Boolean? get() = definedExternally; set(value) = definedExternally
    var supportFetchAPI: Boolean? get() = definedExternally; set(value) = definedExternally
    var corsEnabled: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface RelaunchOptions {
    var args: Array<String>? get() = definedExternally; set(value) = definedExternally
    var execPath: String? get() = definedExternally; set(value) = definedExternally
}

external interface Request {
    var method: String
    var url: String
    var referrer: String
}

external interface ResizeOptions {
    var width: Number? get() = definedExternally; set(value) = definedExternally
    var height: Number? get() = definedExternally; set(value) = definedExternally
    var quality: String? get() = definedExternally; set(value) = definedExternally
}

external interface ResourceUsage {
    var images: MemoryUsageDetails
    var cssStyleSheets: MemoryUsageDetails
    var xslStyleSheets: MemoryUsageDetails
    var fonts: MemoryUsageDetails
    var other: MemoryUsageDetails
}

external interface Response {
    var cancel: Boolean? get() = definedExternally; set(value) = definedExternally
    var redirectURL: String? get() = definedExternally; set(value) = definedExternally
}

external interface Result {
    var requestId: Number
    var activeMatchOrdinal: Number
    var matches: Number
    var selectionArea: SelectionArea
    var finalUpdate: Boolean
}

external interface SaveDialogOptions {
    var title: String? get() = definedExternally; set(value) = definedExternally
    var defaultPath: String? get() = definedExternally; set(value) = definedExternally
    var buttonLabel: String? get() = definedExternally; set(value) = definedExternally
    var filters: Array<FileFilter>? get() = definedExternally; set(value) = definedExternally
    var message: String? get() = definedExternally; set(value) = definedExternally
    var nameFieldLabel: String? get() = definedExternally; set(value) = definedExternally
    var showsTagField: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface Settings {
    var openAtLogin: Boolean? get() = definedExternally; set(value) = definedExternally
    var openAsHidden: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface SizeOptions {
    var normal: Normal? get() = definedExternally; set(value) = definedExternally
}

external interface SourcesOptions {
    var types: Array<String>
    var thumbnailSize: Size? get() = definedExternally; set(value) = definedExternally
}

external interface StartMonitoringOptions {
    var categoryFilter: String
    var traceOptions: String
}

external interface StartRecordingOptions {
    var categoryFilter: String
    var traceOptions: String
}

external interface SystemMemoryInfo {
    var total: Number
    var free: Number
    var swapTotal: Number
    var swapFree: Number
}

external interface ToBitmapOptions {
    var scaleFactor: Number? get() = definedExternally; set(value) = definedExternally
}

external interface ToDataURLOptions {
    var scaleFactor: Number? get() = definedExternally; set(value) = definedExternally
}

external interface ToPNGOptions {
    var scaleFactor: Number? get() = definedExternally; set(value) = definedExternally
}

external interface TouchBarButtonConstructorOptions {
    var label: String? get() = definedExternally; set(value) = definedExternally
    var backgroundColor: String? get() = definedExternally; set(value) = definedExternally
    var icon: NativeImage? get() = definedExternally; set(value) = definedExternally
    var iconPosition: dynamic /* Any /* "left" */ | Any /* "right" */ | Any /* "overlay" */ */
    var click: (() -> Unit)? get() = definedExternally; set(value) = definedExternally
}

external interface TouchBarColorPickerConstructorOptions {
    var availableColors: Array<String>? get() = definedExternally; set(value) = definedExternally
    var selectedColor: String? get() = definedExternally; set(value) = definedExternally
    var change: ((color: String) -> Unit)? get() = definedExternally; set(value) = definedExternally
}

external interface TouchBarGroupConstructorOptions {
    var items: Electron.TouchBar
}

external interface TouchBarLabelConstructorOptions {
    var label: String? get() = definedExternally; set(value) = definedExternally
    var textColor: String? get() = definedExternally; set(value) = definedExternally
}

external interface TouchBarPopoverConstructorOptions {
    var label: String? get() = definedExternally; set(value) = definedExternally
    var icon: NativeImage? get() = definedExternally; set(value) = definedExternally
    var items: Electron.TouchBar? get() = definedExternally; set(value) = definedExternally
    var showCloseButton: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface TouchBarScrubberConstructorOptions {
    var items: Array<ScrubberItem>
    var select: (selectedIndex: Number) -> Unit
    var highlight: (highlightedIndex: Number) -> Unit
    var selectedStyle: String
    var overlayStyle: String
    var showArrowButtons: Boolean
    var mode: String
    var continuous: Boolean
}

external interface TouchBarSegmentedControlConstructorOptions {
    var segmentStyle: dynamic /* Any /* "automatic" */ | Any /* "rounded" */ | Any /* "textured-rounded" */ | Any /* "round-rect" */ | Any /* "textured-square" */ | Any /* "capsule" */ | Any /* "small-square" */ | Any /* "separated" */ */ get() = definedExternally; set(value) = definedExternally
    var mode: dynamic /* Any /* "single" */ | Any /* "multiple" */ | Any /* "buttons" */ */ get() = definedExternally; set(value) = definedExternally
    var segments: Array<SegmentedControlSegment>
    var selectedIndex: Number? get() = definedExternally; set(value) = definedExternally
    var change: (selectedIndex: Number, isSelected: Boolean) -> Unit
}

external interface TouchBarSliderConstructorOptions {
    var label: String? get() = definedExternally; set(value) = definedExternally
    var value: Number? get() = definedExternally; set(value) = definedExternally
    var minValue: Number? get() = definedExternally; set(value) = definedExternally
    var maxValue: Number? get() = definedExternally; set(value) = definedExternally
    var change: ((newValue: Number) -> Unit)? get() = definedExternally; set(value) = definedExternally
}

external interface TouchBarSpacerConstructorOptions {
    var size: dynamic /* Any /* "small" */ | Any /* "large" */ | Any /* "flexible" */ */ get() = definedExternally; set(value) = definedExternally
}

external interface UpdateTargetUrlEvent : Event {
    var url: String
}

external interface Versions {
    var electron: String? get() = definedExternally; set(value) = definedExternally
    var chrome: String? get() = definedExternally; set(value) = definedExternally
}

external interface WillNavigateEvent : Event {
    var url: String
}

external interface EditFlags {
    var canUndo: Boolean
    var canRedo: Boolean
    var canCut: Boolean
    var canCopy: Boolean
    var canPaste: Boolean
    var canDelete: Boolean
    var canSelectAll: Boolean
}

external interface Extra
external interface FoundInPageResult {
    var requestId: Number
    var activeMatchOrdinal: Number
    var matches: Number
    var selectionArea: SelectionArea
    var finalUpdate: Boolean
}

external interface Headers
external interface MediaFlags {
    var inError: Boolean
    var isPaused: Boolean
    var isMuted: Boolean
    var hasAudio: Boolean
    var isLooping: Boolean
    var isControlsVisible: Boolean
    var canToggleControls: Boolean
    var canRotate: Boolean
}

external interface Normal {
    var width: Number
    var height: Number
}

external interface Options
external interface RequestHeaders
external interface ResponseHeaders
external interface SelectionArea
external interface WebPreferences {
    var devTools: Boolean? get() = definedExternally; set(value) = definedExternally
    var nodeIntegration: Boolean? get() = definedExternally; set(value) = definedExternally
    var nodeIntegrationInWorker: Boolean? get() = definedExternally; set(value) = definedExternally
    var preload: String? get() = definedExternally; set(value) = definedExternally
    var sandbox: Boolean? get() = definedExternally; set(value) = definedExternally
    var session: Session? get() = definedExternally; set(value) = definedExternally
    var partition: String? get() = definedExternally; set(value) = definedExternally
    var zoomFactor: Number? get() = definedExternally; set(value) = definedExternally
    var javascript: Boolean? get() = definedExternally; set(value) = definedExternally
    var webSecurity: Boolean? get() = definedExternally; set(value) = definedExternally
    var allowRunningInsecureContent: Boolean? get() = definedExternally; set(value) = definedExternally
    var images: Boolean? get() = definedExternally; set(value) = definedExternally
    var textAreasAreResizable: Boolean? get() = definedExternally; set(value) = definedExternally
    var webgl: Boolean? get() = definedExternally; set(value) = definedExternally
    var webaudio: Boolean? get() = definedExternally; set(value) = definedExternally
    var plugins: Boolean? get() = definedExternally; set(value) = definedExternally
    var experimentalFeatures: Boolean? get() = definedExternally; set(value) = definedExternally
    var experimentalCanvasFeatures: Boolean? get() = definedExternally; set(value) = definedExternally
    var scrollBounce: Boolean? get() = definedExternally; set(value) = definedExternally
    var blinkFeatures: String? get() = definedExternally; set(value) = definedExternally
    var disableBlinkFeatures: String? get() = definedExternally; set(value) = definedExternally
    var defaultFontFamily: DefaultFontFamily? get() = definedExternally; set(value) = definedExternally
    var defaultFontSize: Number? get() = definedExternally; set(value) = definedExternally
    var defaultMonospaceFontSize: Number? get() = definedExternally; set(value) = definedExternally
    var minimumFontSize: Number? get() = definedExternally; set(value) = definedExternally
    var defaultEncoding: String? get() = definedExternally; set(value) = definedExternally
    var backgroundThrottling: Boolean? get() = definedExternally; set(value) = definedExternally
    var offscreen: Boolean? get() = definedExternally; set(value) = definedExternally
    var contextIsolation: Boolean? get() = definedExternally; set(value) = definedExternally
    var nativeWindowOpen: Boolean? get() = definedExternally; set(value) = definedExternally
}

external interface DefaultFontFamily {
    var standard: String? get() = definedExternally; set(value) = definedExternally
    var serif: String? get() = definedExternally; set(value) = definedExternally
    var sansSerif: String? get() = definedExternally; set(value) = definedExternally
    var monospace: String? get() = definedExternally; set(value) = definedExternally
    var cursive: String? get() = definedExternally; set(value) = definedExternally
    var fantasy: String? get() = definedExternally; set(value) = definedExternally
}
