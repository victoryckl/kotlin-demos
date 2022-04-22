package com.derry.s2

//匿名函数的返回类型推断
fun main() {
    // (s1:String) -> String
    val method1 = { s1:String -> "$s1, timestamp: "+System.currentTimeMillis() }
    println(method1("ggggg"))

    // () -> Float
    val method2 = { 2323.3f }
    println(method2().javaClass)


}