package com.derry.s2

//函数作为参数，高阶函数
fun main() {
    loginAPI("user1", "123456") { status, code ->
        println("$status, $code")
    }
}

const val USER_NAME = "user1"
const val USER_PWD  = "123456"

fun loginAPI(username: String, userpwd: String, callback: (String, Int) -> Unit) {
    if (username == null || userpwd == null) {
        TODO("用户名或者密码为空") //抛出异常
    }

    if (webLogin(username, userpwd)) {
        if (callback != null) callback("ok", 200)
    } else {
        if (callback != null) callback("failed", 404)
    }
}

private fun webLogin(name: String, pwd: String) : Boolean {
    // 这里 == 相当于java equals
    return name == USER_NAME && pwd == USER_PWD
}
