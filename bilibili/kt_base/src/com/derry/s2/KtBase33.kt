package com.derry.s2

//返回一个匿名函数
fun main() {
    println(show3("one")("boy", 18))
    var fun3 = show3("two")
    println(fun3("gril", 17))
}

fun show(info: String) : String {
    println("哈哈哈哈 $info")
    return "xxx"
}

fun show3(info: String) : (String, Int) -> String {
    println("哈哈哈哈 $info")
    return {
        msg: String, code: Int ->
        "good $msg, $code"
    }
}

