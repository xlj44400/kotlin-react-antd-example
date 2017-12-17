package app

import antd.Alert
import kotlinx.html.js.onClickFunction
import logo.logo
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.*
import ticker.ticker
import util.async
import util.httpGet
import kotlin.browser.window

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        div("App-header") {
            logo()
            h2 {
                +"Welcome to React with Kotlin"
            }
        }
        p("App-intro") {
            +"To get started, edit "
            code { +"app/App.kt" }
            +" and save to reload."
        }
        p("App-ticker") {
            ticker()
        }
        p ("aaa"){
            alert()
            alert("error")
            alert("warning")
            alert("info")
            +"antd"
        }
        span("ttt"){
            attrs.onClickFunction = {
                //jq(".ttt").html("nininini")
                //jQuery(".ttt").html("nininini")
                /*jQuery.get("http://freegeoip.net/json/",{
                    commits, status, jqXHR ->
                    console.log(commits)
                })*/
                /*jQuery.getJSON("http://freegeoip.net/json/"){
                    commits, status, jqXHR ->
                    console.log(commits)
                }*/
                async {
                    val result = fetchAll()
                    console.log("result ${result}")
                    window.setTimeout({ console.log("time out finish")}, 10000)
                }

                console.log("success")

            }
            +"测试111"
        }
    }

    private suspend fun fetchAll(): String {
        val rawData = httpGet("http://freegeoip.net/json/")
        return rawData
    }
}

fun RBuilder.alert(type : String = "success") = child(Alert::class){
    attrs.type = type
    attrs.message = "测试的antd Alert 组件"
}

fun RBuilder.app() = child(App::class) {}
