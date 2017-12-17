package components

import antd.kRowSelection
import antd.component.props.table.pagination
import react.*
import util.async
import util.httpGet

interface TabState : RState{
    var data:Array<Owner>
    var total : Int
    var current : Int
    var pageSize : Int
}

class TableComponent(props: RProps) : RComponent<RProps, TabState>(props) {

    override fun TabState.init(props: RProps) {
        data = arrayOf()
        total = 0
        pageSize = 4
        current = 1
    }

    override fun componentWillMount() {
        loadData(1)
    }

    override fun componentDidMount() {
        console.log("componentDidMount")
    }

    fun loadData(page:Int){
        async {
            val result = fetchAll(page)
            val r = JSON.parse<Result>(result);
            setState {
                data = r.list
                total = r.total
                current = page
            }
            console.log("result ${r.total}")
        }
    }

    private suspend fun fetchAll(current:Int): String {
        val rawData = httpGet("http://localhost:8082/api/owners/list/${current}")
        return rawData
    }

    override fun RBuilder.render() {
        console.log("total ${state.total}")
        val rowSelect = kRowSelection {
            onSelect = { record, selected, selectedRows ->
                console.log("record ${record}")
            }
        }

        val pagination = pagination {
            total = state.total
            current = state.current
            pageSize = state.pageSize
            showSizeChanger = true
            showTotal = {
                "共 ${total} 条记录"
            }
            pageSizeOptions = arrayOf("10","20","30")
            onChange = {
                page, pageSize ->  loadData(page)
                console.log("load data ${page}")
            }
        }

        myTable(state.data,rowSelect,pagination)
    }
}

data class Owner(val id:String,
                 val firstName:String,
                 val city:String,
                 val telephone:String,
                 val address:String)

data class Result(val list:Array<Owner>,val total:Int)