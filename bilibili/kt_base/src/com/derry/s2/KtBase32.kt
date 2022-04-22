package com.derry.s2

//方法作为参数传递
// ::函数名 -> 函数类型对象
fun main() {
    login3("user1", "sss", ::callbackMethod)
}

fun login3(name: String, pwd: String, callback: (msg:String, code:Int) -> Unit) {
    if (name == "user1" && pwd == "123456") {
        callback("success", 200)
    } else {
        callback("fail", 404)
    }
}

fun callbackMethod(msg: String, code: Int) {
    println("msg:$msg, code:$code")
}