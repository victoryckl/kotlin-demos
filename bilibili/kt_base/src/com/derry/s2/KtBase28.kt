package com.derry.s2

// 匿名函数是一种lambda表达式
fun main() {
    val add = { number1: Int, number2: Int ->
        "两数相加结果是：${number1 + number2}"
    }
    println(add(20, 22))

    // (Int) -> Any
    val weekTest = { number: Int ->
        when(number) {
            1 -> "星期一"
            2 -> "星期二"
            3 -> "星期三"
            4 -> "星期四"
            5 -> "星期五"
            6 -> "星期六"
            7 -> "星期日"
            else -> -1
        }
    }
    println(weekTest(99))
}