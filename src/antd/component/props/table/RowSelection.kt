package antd.component.props.table

class RowSelection {
    var type: String? = null // checkbox|radio
    var onChange: ((selectedRowKeys: Array<Any>, selectedRows: Any) -> Unit)? = null
    var getCheckboxProps: ((record: Any) -> Unit)? = null
    var onSelect: ((record: dynamic, selected: Any, selectedRows: Any) -> Unit)? = null
    var onSelectAll: ((rselectedecord: Any, selectedRows: Any, changeRows: Any) -> Unit)? = null
}

fun rowSelection(block: RowSelection.()->Unit) : RowSelection = RowSelection().apply(block)