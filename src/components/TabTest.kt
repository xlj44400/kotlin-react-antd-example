package components

import antd.Table
import antd.component.props.table.*
import react.RBuilder
import react.dom.a

fun RBuilder.TabTest() = child(Table::class){
    val rowKey : (reord:Person,index:Number)->String = {
        reord, index ->  reord.name
    }

    val cols = columns{
        column {
            title = "name"
            dataIndex = "name"
            key = "1"
        }
        column{
            title = "age"
            dataIndex = "age"
            key = "2"
            render = {
                text, record, index ->  a { +"${text} renderage" }
            }
        }
    }

    val rowSelection = rowSelection {
        type = "radio"
        onSelect = { record, selected, selectedRows ->
            console.log("record ${record}")
        }
    }

    val c1 = col {
        title = "name1"
        dataIndex = "name"
        key = "1"
    }

    val c2 = col{
        title = "age1"
        dataIndex = "age"
        key = "2"
    }

    attrs.dataSource = arrayOf(Person("xlj",2),Person("xlj2",34))
    attrs.columns = arrayOf(c1,c2)
    attrs.rowKey = rowKey
    attrs.className = "table"
    attrs.loading = false
    attrs.bordered = true
    attrs.prefixCls = "ant-table"
    attrs.rowSelection = rowSelection
}


data class Person(val name:String,val age:Int)