package antd

data class KRowSelection(var type:String? = null,
                         var onSelect:((record: Any, selected: Any, selectedRows: Any) -> Unit)?=null,
                         var onChange:((selectedRowKeys: Array<Any>, selectedRows: Any) -> Unit)?=null
)

fun kRowSelection(block: KRowSelection.() -> Unit): KRowSelection = KRowSelection().apply(block)