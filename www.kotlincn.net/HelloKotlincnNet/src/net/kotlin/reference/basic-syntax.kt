package net.kotlin.reference

/*
https://www.kotlincn.net/docs/reference/basic-syntax.html

空值与 null 检测
当某个变量的值可以为 null 的时候，必须在声明处的类型后添加 ? 来标识该引用可为空。

如果 str 的内容不是数字返回 null：
fun parseInt(str: String): Int? {
    // ……
}
使用返回可空值的函数:
 */
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    // 直接使用 `x * y` 会导致编译错误，因为它们可能为 null
    if (x != null && y != null) {
        // 在空检测后，x 与 y 会自动转换为非空值（non-nullable）
        println(x * y)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }
}


//使用 lambda 表达式来过滤（filter）与映射（map）集合：
fun testFilter() {
    println("testFilter")
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

fun main(args: Array<String>) {
    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")

    testFilter()
}