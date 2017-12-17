package index

import app.App
import components.TabDemo
import components.form.OwnerForm
import kotlinext.js.invoke
import kotlinext.js.require
import kroute.browserRouter
import kroute.route
import kroute.router
import kroute.switch
import react.dom.render
import react.history.History
import kotlin.browser.document

fun main(args: Array<String>) {
    require("src/index/index.css")
    require("src/app/App.css")
    require("src/logo/Logo.css")

    render(document.getElementById("root")) {
        router {
            attrs.history = History.createBrowserHistory()
            switch {
                route("/",  App::class, exact = true)
                //kroute("/mytable",  TableComponent::class, exact = true)
                route("/tabTest",  TabDemo::class, exact = true)
                route("/myForm",  OwnerForm::class, exact = true)
            }
        }
    }
}
