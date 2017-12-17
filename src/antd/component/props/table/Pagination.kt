package antd.component.props.table

class Pagination {
    var current: Number? =null 
    var total: Number = 0
    var pageSize: Number? =null
    var onChange: ((page: Int, pageSize: Int?) -> Unit)?=null
    var showSizeChanger: Boolean? =null 
    var pageSizeOptions: Array<String>? =null
    var onShowSizeChange: Function<*>? =null 
    var showQuickJumper: Boolean? =null 
    var showTotal: ((total: Number)->dynamic)? = null
}

fun pagination(block: Pagination.()->Unit) : Pagination = Pagination().apply(block)