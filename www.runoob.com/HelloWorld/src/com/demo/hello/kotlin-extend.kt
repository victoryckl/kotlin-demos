package com.demo.hello

//https://www.runoob.com/kotlin/kotlin-extend.html
//Kotlin 继承
//Kotlin 中所有类都继承该 Any 类，它是所有类的超类，对于没有超类型声明的类是默认超类：
class Example // 从Any隐式继承

/*
Any 默认提供了三个函数：
equals()
hashCode()
toString()
注意：Any 不是 java.lang.Object。

如果一个类要被继承，可以使用 open 关键字进行修饰。
 */
open class Base2(p:Int)

class Derived2(p:Int) : Base2(p)

/*
构造函数
子类有主构造函数
如果子类有主构造函数， 则基类必须在主构造函数中立即初始化。
 */
open class Person7(var name:String, var age:Int) {//基类

}

class Student(name:String, age:Int, var no:String, var score:Int) : Person7(name, age) {

}

fun testStudent() {
    val s = Student("Pony", 18, "S123456", 90)
    println("学生：${s.name}")
    println("年龄：${s.age}")
    println("学号：${s.no}")
    println("年龄：${s.score}")
}

/*
子类没有主构造函数
如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，
或者在代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。
 */
open class Person8(name:String){
    /**次级构造函数**/
    constructor(name:String,age:Int):this(name){
        //初始化
        println("-------基类次级构造函数---------")
    }
}

/**子类继承 Person 类**/
class Student2 : Person8{

    /**次级构造函数**/
    constructor(name:String,age:Int,no:String,score:Int):super(name,age){
        println("-------继承类次级构造函数---------")
        println("学生名： ${name}")
        println("年龄： ${age}")
        println("学生号： ${no}")
        println("成绩： ${score}")
    }
}

fun testStudent2() {
    val s = Student2("Bill", 32, "S3333", 87)
}

/*
重写
在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。
如果允许子类重写该函数，那么就要手动添加 open 修饰它,
子类重写方法使用 override 关键词：
 */
open class Person9 {
    open fun study() {//允许子类重写
        println("我毕业了！")
    }
}

class Student3 : Person9() {
    override fun study() { //重写
        println("我在读大一")
        //调用基类的函数
        //super.study()
        //super<Person9>.study()
    }
}

fun testStudent3() {
    val s = Student3()
    s.study()
}

/*如果有多个相同的方法（继承或者实现自其他类，如A、B类），
 则必须要重写该方法，使用super范型去选择性地调用父类的实现。
 C 继承自 a() 或 b(), C 不仅可以从 A 或则 B 中继承函数，
 而且 C 可以继承 A()、B() 中共有的函数。
 此时该函数在中只有一个实现，为了消除歧义，该函数提供自己的实现。
 */
open class A {
    open fun f() = println("A.f")
    fun a() = println("A.a")
}

interface B {
    fun f() = println("B.f") //接口的成员模式是open的
    fun b() = println("B.b")
}

class C : A(), B {
    override fun f() {
        println("C.f")
        //super<A>.f()//调用A.f()
        //super<B>.f()//调用B.f()
    }
}

fun testABC() {
    val c = C()
    c.f()
}

/*
属性重写
属性重写使用 override 关键字，属性必须具有兼容类型，
每一个声明的属性都可以通过初始化程序或者getter方法被重写：
open class Foo {
    open val x: Int get { …… }
}

class Bar1 : Foo() {
    override val x: Int = ……
}

你可以用一个var属性重写一个val属性，但是反过来不行。
因为val属性本身定义了getter方法，重写为var属性会在衍生类中额外声明一个setter方法
你可以在主构造函数中使用 override 关键字作为属性声明的一部分:
 */
interface Foo {
    val count: Int
}

class Bar1(override val count: Int) : Foo

class Bar2 : Foo {
    override var count: Int = 0
}

/*
1、子类继承父类时，不能有跟父类同名的变量，除非父类中该变量为 private，
或者父类中该变量为 open 并且子类用 override 关键字重写
2.

 */
fun main(args: Array<String>) {
    testStudent()
    testStudent2()
    testStudent3()
    testABC()
}