package antd.component.props.table

class Columns{
    var key: String? = null
    var title: dynamic /* String | dynamic */ = null
    var dataIndex: String? = null
    var render: ((text: Any? /*= null*/, record: Any? /*= null*/, index: Number? /*= null*/) -> dynamic)? = null
    var filters: Array<Any>? = null
    var onFilter: Function<*>? = null
    var filterMultiple: Boolean? = null
    var sorter: dynamic /* Boolean | Function<*> */ = null
    var colSpan: Number? = null
    var width: dynamic /* String | Number */ = null
    var className: String? = null
}

data class ColumnArray(val columns: Array<Columns>)

class ColumnsBuild{
    private val columns : Array<Columns> = arrayOf()

    fun column(block: Columns.()->Unit) {
        columns[columns.size]=Columns().apply(block)
    }

    fun build() : ColumnArray = ColumnArray(columns)
}

fun columns(block: ColumnsBuild.()->Unit) : Array<Columns> = ColumnsBuild().apply(block).build().columns

fun col(block: Columns.()->Unit) : Columns = Columns().apply(block)



