package com.demo.hello

import kotlin.reflect.KProperty

/*
https://www.runoob.com/kotlin/kotlin-delegated.html

kotlin 委托
委托模式是软件设计模式中的一项基本技巧。在委托模式中，
有两个对象参与处理同一个请求，接受请求的对象将请求委托给另一个对象来处理。
Kotlin 直接支持委托模式，更加优雅，简洁。Kotlin 通过关键字 by 实现委托。

类委托
类的委托即一个类中定义的方法实际是调用另一个类的对象的方法来实现的。
以下实例中派生类 Derived 继承了接口 Base 所有方法，
并且委托一个传入的 Base 类的对象来执行这些方法。
在 Derived 声明中，by 子句表示，将 b 保存在 Derived 的对象实例内部，
而且编译器将会生成继承自 Base 接口的所有方法, 并将调用转发给 b。
 */
// 创建接口
interface Base3 {
    fun print()
}

//实现此接口的被委托的类
class Base3Impl(private val x : Int) : Base3 {
    override fun print() {
        println("Base3Impl x=$x")
    }
}

//通过关键字 by 建立委托类
class Derived3(b : Base3) : Base3 by b
/*效果等于下面的写法：
class Derived3(private val b : Base3) : Base3 {
    override fun print() {
        b.println()
    }
}
*/


/*
属性委托
属性委托指的是一个类的某个属性值不是在类中直接进行定义，
而是将其托付给一个代理类，从而实现对该类的属性统一管理。

属性委托语法格式：
val/var <属性名>: <类型> by <表达式>
    var/val：属性类型(可变/只读)
    属性名：属性名称
    类型：属性的数据类型
    表达式：委托代理类
by 关键字之后的表达式就是委托, 属性的 get() 方法(以及set() 方法)
将被委托给这个对象的 getValue() 和 setValue() 方法。
属性委托不必实现任何接口, 但必须提供 getValue() 函数(对于 var属性,还需要 setValue() 函数)。

定义一个被委托的类
该类需要包含 getValue() 方法和 setValue() 方法，
且参数 thisRef 为进行委托的类的对象，prop 为进行委托的属性的对象。
 */

//定义包含属性委托的类
class Example2 {
    var p : String by Delegate2()
}

class Delegate2 {
    operator fun getValue(thisRef : Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}

/*
标准委托
Kotlin 的标准库中已经内置了很多工厂方法来实现属性的委托。

延迟属性 Lazy
lazy() 是一个函数, 接受一个 Lambda 表达式作为参数,
返回一个 Lazy <T> 实例的函数，返回的实例可以作为实现延迟属性的委托：
第一次调用 get() 会执行已传递给 lazy() 的 lamda 表达式并记录结果，
 后续调用 get() 只是返回记录的结果。
 */
val lazyValue : String by lazy {
    println("lazy init") // 第一次调用输出，第二次调用不执行
    "Hello"
}
//同下：
//val lazyValue : String by lazy({
//    println("lazy init") // 第一次调用输出，第二次调用不执行
//    "Hello"
//})

fun main(args: Array<String>) {
    val c = Base3Impl(1000)
    Derived3(c).print()

    val e = Example2()
    println(e.p)   // 访问该属性，调用 getValue() 函数
    e.p = "Runoob"
    println(e.p)   // 调用 setValue() 函数

    println(lazyValue) // 第一次执行，执行两次输出表达式
    println(lazyValue) // 第二次执行，只输出返回值
}