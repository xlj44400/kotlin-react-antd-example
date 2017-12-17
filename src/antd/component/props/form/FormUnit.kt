package antd.component.props.form

import react.ReactElement

interface WrappedFormUtils{
    fun getFieldsValue(): (fieldNames: Array<String>?) -> Any
    fun getFieldValue(): (fieldName: String) -> Any
    fun setFieldsValue(): (obj: Any) -> Unit
    fun setFields(): (obj: Any) -> Unit
    fun validateFields(): (fieldNames: Array<String>? /*= null*/, options: Any? /*= null*/, callback: ((erros: Any, values: Any) -> Unit)? /*= null*/) -> Any
    fun validateFieldsAndScroll(): (fieldNames: Array<String>? /*= null*/, options: Any? /*= null*/, callback: ((erros: Any, values: Any) -> Unit)? /*= null*/) -> Any
    fun getFieldError(): (name: String) -> Any
    fun isFieldValidating(): (name: String) -> Any
    fun resetFields(): (names: Array<String>? /*= null*/) -> Unit
    fun getFieldDecorator(id: String, options: FieldOptions): (node: ReactElement)-> ReactElement
}

class FieldOptions {
    var valuePropName: String? =null
    var initialValue: Any? =null
    var trigger: String? =null
    var validateTrigger: String? =null
    var rules: Array<Any>? =null
    var id: String? =null
}

fun fieldOptions(block: FieldOptions.()->Unit) : FieldOptions = FieldOptions().apply(block)

class FormItemLabelColOption {
    var span: Int? = null;
    var offset : Int? = null;
}

fun formItemLabelColOption(block: FormItemLabelColOption.()->Unit) : FormItemLabelColOption = FormItemLabelColOption().apply(block)
