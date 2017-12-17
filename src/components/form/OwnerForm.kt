package components.form

import antd.*
import antd.component.props.form.formItemLabelColOption
import kroute.BrowserRouterProps
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.div
import react.dom.p
import react.history.History
import kotlin.js.Json
import kotlin.js.json

interface OwnerState : RState {
    var formFields : Json
}

class OwnerForm(props: BrowserRouterProps) : RComponent<BrowserRouterProps, OwnerState>(props){

    override fun OwnerState.init(props: BrowserRouterProps) {
        formFields = json("name" to "xljxxxx")
    }

    override fun componentWillMount() {

    }

    override fun RBuilder.render() {

        val onClick = {
            val json = state.formFields
            console.log("submit $json ")
            val h = History.createBrowserHistory()
            h.replace("/tabTest")
            val path = props.history
            path?.push("/tabTest")
            console.log(path)
        }

        div("x-add-form"){
            myForm(state.formFields,onClick){
                e ->
                val event = e.target as HTMLInputElement
                console.log("onChange",event.value)
                var j = json()
                j[event.name] = event.value
                setState{formFields = j}
            }
        }
    }
}
fun button(onClick:KHandle) = KBuilder.build(Button::class){
    attrs.htmlType = "button"
    attrs.type = "primary"
    attrs.onClick = onClick
    +"提交"
}
fun input(formFields:Json,name:String,onChange:KEventHandle) = KBuilder.build(Input::class){
    attrs.placeholder = "测试的"
    attrs.onChange = onChange
    attrs.name = name
    attrs.value = formFields[name] ?: null
}
fun row(vararg elements: ReactElement) = KBuilder.build(Row::class){
    attrs.type = "flex"
    attrs.align = "middle"
    attrs.justify = "center"
    elements.forEach {
        child(it)
    }
}

fun date() = KBuilder.build(DatePicker::class){
    attrs.format = "YYYY-MM-DD"
}

fun col(element: ReactElement) = KBuilder.build(Col::class){
    attrs.span = "4"
    child(element)
}

typealias KEventHandle = (e: Event) -> Unit
typealias KHandle = () -> Unit

fun RBuilder.myForm(formFields:Json,handle:KHandle,onChange:KEventHandle) = child(Form::class){
    val formItemName = formItem(input(formFields,"name",onChange),"姓名")

    child(row(col(formItemName)))

    child(row(col(button(handle))))
}

fun formItem(element: ReactElement,label:String) = KBuilder.build(FormItem::class){
    attrs.label = label
    attrs.labelCol = formItemLabelColOption { span = 6 }
    attrs.wrapperCol = formItemLabelColOption { span = 12 }
    child(element)
}