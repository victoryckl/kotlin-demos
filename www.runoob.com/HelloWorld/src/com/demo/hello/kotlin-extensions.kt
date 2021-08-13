package com.demo.hello

/*
https://www.runoob.com/kotlin/kotlin-extensions.html

Kotlin 扩展
Kotlin 可以对一个类的属性和方法进行扩展，且不需要继承或使用 Decorator 模式。
扩展是一种静态行为，对被扩展的类代码本身不会造成任何影响。

扩展函数
扩展函数可以在已有类中添加新的方法，不会对原类做修改，扩展函数定义形式：
fun receiverType.functionName(params){
    body
}
receiverType：表示函数的接收者，也就是函数扩展的对象
functionName：扩展函数的名称
params：扩展函数的参数，可以为NULL
以下实例扩展 User 类 ：
 */

class User(var name:String)

//扩展函数
fun User.print() {
    println("用户名 $name")
}

fun testUser() {
    println("testUser")
    var user = User("Tom")
    user.print()
}

//下面代码为 MutableList 添加一个swap函数：
//this关键字指代接收者对象(receiver object)(也就是调用扩展函数时, 在点号之前指定的对象实例)。
fun <T> MutableList<T>.swap(index1:Int, index2:Int) {
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

fun testSwap() {
    val l = mutableListOf(1,2,3)
    l.swap(0,1) // 'swap()' 函数内的 'this' 将指向 'l' 的值
    println(l)
}

/*
扩展函数是静态解析的
扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，
具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的
 */
open class D {
    open fun bar() = "D成员函数bar"
}

class E:D() {
    override fun bar() = "E成员函数bar"
    fun zoo() = "E成员函数zoo"
}

fun D.foo() = "d" //D的扩展函数
fun E.foo() = "e" //E的扩展函数
fun E.bar() = "E扩展函数bar"
fun E.fff() {
    println("E.fff()")
    println(bar())
    println(zoo())
}

fun printFoo(d:D) {
    println(d.foo()) //类型是D类
}

//若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
fun printBar(d:D) {
    println(d.bar())
}

//扩展一个空对象
//在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,
// 这样，即使接收者为 NULL,也可以调用扩展函数。例如:
fun Any?.toString():String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

/*
扩展属性
除了函数，Kotlin 也支持属性对属性进行扩展:
val <T> List<T>.lastIndex: Int
    get() = size - 1
扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。
初始化属性因为属性没有后端字段（backing field），
所以不允许被初始化，只能由显式提供的 getter/setter 定义。
val Foo.bar = 1 // 错误：扩展属性不能有初始化器
扩展属性只能被声明为 val。
 */

/*
伴生对象的扩展
如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性。
伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，
通过用类名限定符来调用：
 */
class MyClass {
    var no : Int = 20
    companion object {} // 将被称为 "Companion"
}

fun MyClass.Companion.foo() {
    println("伴生对象的扩展函数")
}

val MyClass.Companion.no: Int
    get() = 10;

fun testCompanionObject() {
    val mc = MyClass()
    println("no:${mc.no}")
    println("no:${MyClass.no}")
    MyClass.foo()
}

/*
扩展的作用域
通常扩展函数或属性定义在顶级包下:
package foo.bar
fun Baz.goo() { …… }
要使用所定义包之外的一个扩展, 通过import导入扩展的函数名进行使用:
package com.example.usage
import foo.bar.goo // 导入所有名为 goo 的扩展
                   // 或者
import foo.bar.*   // 从 foo.bar 导入一切
fun usage(baz: Baz) {
    baz.goo()
}
 */

/*
扩展声明为成员
在一个类内部你可以为另一个类声明扩展。
在这个扩展中，有个多个隐含的接受者，其中扩展方法定义所在类的实例称为分发接受者，
而扩展方法的目标类型的实例称为扩展接受者。

在 F 类内，创建了 G 类的扩展。此时，F 被成为分发接受者，
而 G 为扩展接受者。从上例中，可以清楚的看到，在扩展函数中，可以调用派发接收者的成员函数。
 */

class G {
    fun bar() = println("G.bar()")
}

class F {
    fun baz() = println("F.baz()")
    fun bar() = println("F.bar()")

    fun G.foo() {
        bar() //调用G.bar,扩展接受者优先
        baz() //调用F.baz
        this@F.bar() //调用F.bar
        //假如在调用某一个函数，而该函数在分发接受者和扩展接受者均存在，
        //则以扩展接收者优先，要引用分发接收者的成员你可以使用限定的 this 语法。
    }

    fun caller(g:G) {
        g.foo() //调用扩展函数
    }
}

fun testFG() {
    println("testFG")
    val f = F()
    val g = G()
    f.caller(g)
    //输出：
    //G.bar()
    //F.baz()
}

/*
以成员的形式定义的扩展函数, 可以声明为 open , 而且可以在子类中覆盖.
也就是说, 在这类扩展函数的派 发过程中, 针对分发接受者是虚拟的(virtual),
 但针对扩展接受者仍然是静态的。
 */

open class M {}
class M1 : M() {}
open class N {
    open fun M.foo() = println("M.foo in N")
    open fun M1.foo() = println("M1.foo in N")
    fun caller(m:M) {
        m.foo()//调用扩展函数
    }
}

class N1 : N() {
    override fun M.foo() = println("M.foo in N1")
    override fun M1.foo() = println("M1.foo in N1")
}

fun testMN() {
    println("testMN")
    N().caller(M())   //M.foo in N
    N1().caller(M())  //M.foo in N1  —— 分发接收者虚拟解析
    N().caller(M1())  //M.foo in N   —— 扩展接收者静态解析
    N1().caller(M1()) //M.foo in N1
}
/*
伴生对象内的成员相当于 Java 中的静态成员，其生命周期伴随类始终，在伴生对象内部可以定义变量和函数，这些变量和函数可以直接用类名引用。

对于伴生对象扩展函数，有两种形式，一种是在类内扩展，一种是在类外扩展，这两种形式扩展后的函数互不影响（甚至名称都可以相同），即使名称相同，它们也完全是两个不同的函数，并且有以下特点：

 （1）类内扩展的伴随对象函数和类外扩展的伴随对象可以同名，它们是两个独立的函数，互不影响；
 （2）当类内扩展的伴随对象函数和类外扩展的伴随对象同名时，类内的其它函数优先引用类内扩展的伴随对象函数，即对于类内其它成员函数来说，类内扩展屏蔽类外扩展；
 （3）类内扩展的伴随对象函数只能被类内的函数引用，不能被类外的函数和伴随对象内的函数引用；
 （4）类外扩展的伴随对象函数可以被伴随对象内的函数引用，；
例如以下代码：

class MyClass {
    companion object {
        val myClassField1: Int = 1
        var myClassField2 = "this is myClassField2"
        fun companionFun1() {
            println("this is 1st companion function.")
            foo()
        }
        fun companionFun2() {
            println("this is 2st companion function.")
            companionFun1()
        }
    }
    fun MyClass.Companion.foo() {
        println("伴随对象的扩展函数（内部）")
    }
    fun test2() {
        MyClass.foo()
    }
    init {
        test2()
    }
}
val MyClass.Companion.no: Int
    get() = 10
fun MyClass.Companion.foo() {
    println("foo 伴随对象外部扩展函数")
}
fun main(args: Array<String>) {
    println("no:${MyClass.no}")
    println("field1:${MyClass.myClassField1}")
    println("field2:${MyClass.myClassField2}")
    MyClass.foo()
    MyClass.companionFun2()
}
运行结果：

no:10
field1:1
field2:this is myClassField2
foo 伴随对象外部扩展函数
this is 2st companion function.
this is 1st companion function.
没有验证????foo 伴随对象外部扩展函数????
 */

fun main(args: Array<String>) {
    testUser()
    testSwap()
    printFoo(E())
    printBar(E())
    E().fff()

    var t = null
    println(t.toString())

    testCompanionObject()
    testFG()
    testMN()
}