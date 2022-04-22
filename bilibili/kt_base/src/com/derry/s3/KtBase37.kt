package com.derry.s3

//使用let的安全调用
fun main() {
    var name: String? = "哈哈哈"
    name = null
    name?.let { //如果name == null，则不执行let{}
        println("消息：$it")
    }

    //name.capitalize()//编译错误
    if (name != null) {//先判断再调用，不会编译错误
        name.capitalize()
    }

    // 空合并操作符
    println(name?:"is null 1") //如果name == null，则返回后面的值：name != null ? name : "is null"

    // let函数 + 空合并操作符
    println(name?.let { "[$it]" } ?: "is null 2")

    println(name!!.toString()) //如果name == null，则抛出异常

}