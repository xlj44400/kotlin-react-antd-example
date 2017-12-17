/**
 * Created by danfma on 26/01/17.
 */
package react.history
@JsModule("history")
external object History {

    fun createBrowserHistory(): BrowserHistoryInstance

    fun createHashHistory(): HashHistoryInstance

    fun createHashHistory(hashOptions: HashOptions): HashHistoryInstance

}