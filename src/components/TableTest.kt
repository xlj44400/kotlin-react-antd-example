package components

import antd.Table
import antd.KRowSelection
import antd.component.props.table.Pagination
import antd.component.props.table.columns
import react.RBuilder
import react.dom.a

fun RBuilder.myTable(data:Array<Owner>, rowSelection: KRowSelection, pagination: Pagination) = child(Table::class){
    val rowKey : (reord:Owner,index:Number)->String = {
        reord, index ->  reord.id
    }

    val cols = columns{
        column {
            title = "id"
            dataIndex = "id"
            key = "1"
        }
        column{
            title = "firstName"
            dataIndex = "firstName"
            key = "2"
            render = {
                text, record, index ->  a { +"${text} renderage" }
            }
        }
        column {
            title = "address"
            dataIndex = "address"
            key = "3"
        }
        column {
            title = "city"
            dataIndex = "city"
            key = "4"
        }
        column {
            title = "telephone"
            dataIndex = "telephone"
            key = "5"
        }
    }

    attrs.dataSource = data
    attrs.columns = cols
    attrs.rowKey = rowKey
    attrs.className = "table"
    attrs.loading = false
    attrs.bordered = true
    attrs.prefixCls = "ant-table"
    attrs.rowSelection = rowSelection
    attrs.pagination = pagination
}