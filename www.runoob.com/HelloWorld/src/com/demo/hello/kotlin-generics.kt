package com.demo.hello

/*
https://www.runoob.com/kotlin/kotlin-generics.html
Kotlin 泛型
泛型，即 "参数化类型"，将类型参数化，可以用在类，接口，方法上。
与 Java 一样，Kotlin 也提供泛型，为类型安全提供保证，消除类型强转的烦恼。
声明一个泛型类:
class Box<T>(t: T) {
    var value = t
}
创建类的实例时我们需要指定类型参数:
val box: Box<Int> = Box<Int>(1)
// 或者
val box = Box(1) // 编译器会进行类型推断，1 类型 Int，所以编译器知道我们说的是 Box<Int>。
以下实例向泛型类 Box 传入整型数据和字符串：
*/

class Box<T>(t:T) {
    var value = t
}

fun testBox() {
    println("testBox")
    var boxInt = Box(10)
    var boxString = Box<String>("xxxx")
    println(boxInt.value)
    println(boxString.value)
}

/*
定义泛型类型变量，可以完整地写明类型参数，
如果编译器可以自动推定类型参数，也可以省略类型参数。
Kotlin 泛型函数的声明与 Java 相同，类型参数要放在函数名的前面：
fun <T> boxIn(value: T) = Box(value)

// 以下都是合法语句
val box4 = boxIn<Int>(1)
val box5 = boxIn(1)     // 编译器会进行类型推断
在调用泛型函数时，如果可以推断出类型参数，可以省略泛型参数。
以下实例创建了泛型函数 doPrintln，函数根据传入的不同类型做相应处理：
 */

fun <T> doPrint(content:T) {
    when(content) {
        is Int -> println("整数数字为 $content")
        is String -> println("字串转换为大写: ${content.toUpperCase()}")
        else -> println("T 不是整型，也不是字符串")
    }
}

fun testPrintT() {
    println("testPrintT")

    val age = 23
    val name = "jelly"
    val bool = true


}

fun main(args: Array<String>) {
    testBox()
    testPrintT()
}