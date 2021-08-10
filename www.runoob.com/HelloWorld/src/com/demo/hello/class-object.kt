package com.demo.hello

/*
https://www.runoob.com/kotlin/kotlin-class-object.html

Kotlin 类和对象
类定义
Kotlin 类可以包含：构造函数和初始化代码块、函数、属性、内部类、对象声明。

Kotlin 中使用关键字 class 声明类，后面紧跟类名：
 */
class Runoob { // 类名为 Runoob
    // 大括号内是类体构成
}

//我们也可以定义一个空类：
class Empty

//可以在类中定义成员函数：
class Runoob2 {
    fun foo() { println("Runoob2.foo()") }
}

/*
类的属性
属性定义
类的属性可以用关键字 var 声明为可变的，否则使用只读关键字 val 声明为不可变。
 */
class Runoob3 {
    var name: String = "noob1"
    var url: String = "www.xxx.com"
    var city: String = "city1"
}

//我们可以像使用普通函数那样使用构造函数创建类实例：
fun testProperty() {
    println("testProperty")
    val site = Runoob3() // Kotlin 中没有 new 关键字
    //要使用一个属性，只要用名称引用它即可
    println(site.name+","+site.url)
}

//Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，
// 主构造器是类头部的一部分，位于类名称之后:
class Person constructor(firstName: String) {

}

//如果主构造器没有任何注解，也没有任何可见度修饰符，
// 那么constructor关键字可以省略。
class Person2(firstName: String)

/*
getter 和 setter
属性声明的完整语法：

var <propertyName>[: <PropertyType>] [= <property_initializer>]
    [<getter>]
    [<setter>]

getter 和 setter 都是可选

如果属性类型可以从初始化语句或者类的成员函数中推断出来，那就可以省去类型，val不允许设置setter函数，因为它是只读的。

var allByDefault: Int? // 错误: 需要一个初始化语句, 默认实现了 getter 和 setter 方法
var initialized = 1    // 类型为 Int, 默认实现了 getter 和 setter
val simple: Int?       // 类型为 Int ，默认实现 getter ，但必须在构造函数中初始化
val inferredType = 1   // 类型为 Int 类型,默认实现 getter
 */

/*
实例
以下实例定义了一个 Person 类，包含两个可变变量 lastName 和 no，
lastName 修改了 getter 方法，no 修改了 setter 方法。
 */
class Person3 {
    var lastName: String = "zhang"
        get() = field.toLowerCase()
        set
    // Kotlin 中类不能定义名为"field"的属性。
    // 提供了 Backing Fields(后端变量) 机制,
    // 备用字段使用field关键字声明,field 关键词只能用于属性的访问器，如以上实例

    var no: Int = 100
        get() = field
        set(value) {
            if (value < 10) {
                field = value
            } else {
                field = -1
            }
        }
    var heiht: Float = 152.5f
        private set

    //非空属性必须在定义的时候初始化,
    // kotlin提供了一种可以延迟初始化的方案,使用 lateinit 关键字描述属性：
    lateinit var subject: String
//    @SetUp fun setup() {
//        subject = "wuli"
//    }
//    @Test fun test() {
//        println("subject:$subject")
//    }
}

fun testPerson3() {
    println("testPerson3")
    var person = Person3()
    person.lastName = "wang"
    println("lastName:${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")
}


fun main(args: Array<String>) {
    testProperty()
    testPerson3()
}
