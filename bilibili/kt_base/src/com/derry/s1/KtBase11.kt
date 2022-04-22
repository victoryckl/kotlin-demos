package com.derry.s1

const val PI1 = 3.1415926
const val PI2 = 3.1416
const val PI3 = 3

//查看kotlin编译后字节码 Tools-Kotlin-Show Kotlin Bytecode
//在Kotlin Bytecode界面，点击Decomplie可以查看编译处理的java代码
fun main() {
    val name = "json"
    val number1 = 111 //没有使用的Int会被优化成boolean类型
    val number2 : Int = 133 //没有使用的Int会被优化成boolean类型
    val number3 = 1.22
    val number4 = 222
    println(number4)
}