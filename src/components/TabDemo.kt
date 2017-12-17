package components

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class TabDemo : RComponent<RProps,RState>(){

    override fun RBuilder.render() {
        TabTest()
    }
}