package antd

import kotlinext.js.jsObject
import react.*
import kotlin.reflect.KClass

/**
 * 具体代码参考 RBuilder 这个是根据RBuilder改的
 * */
class KBuilder{
    companion object {

        fun <P : RProps, C : React.Component<P, *>> build(klazz: KClass<C>, handler: RHandler<P>): ReactElement {
            val rClass = klazz.js as RClass<P>
            return rClass(handler)
        }

        fun <P : RProps> build(type: Any, props: P, handler: RHandler<P>): ReactElement {
            val children = with(RElementBuilder(props)) {
                handler()
                childList
            }
            return build(type, props,children)
        }

        fun <P : RProps> build(type: Any, props: P,children: List<Any>) = react.React.createElement(type, props,*children.toTypedArray())

        operator fun <P : RProps> RClass<P>.invoke(handler: RHandler<P>) =
                build(this, jsObject {}, handler)
    }
}