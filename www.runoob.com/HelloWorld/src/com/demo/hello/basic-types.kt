package com.demo.hello

/*
https://www.runoob.com/kotlin/kotlin-basic-types.html

Kotlin 基本数据类型
Kotlin 的基本数值类型包括 Byte、Short、Int、Long、Float、Double 等。不同于 Java 的是，字符不属于数值类型，是一个独立的数据类型。

类型	位宽度
Double	64
Float	32
Long	64
Int	32
Short	16
Byte	8
字面常量
下面是所有类型的字面常量：

十进制：123
长整型以大写的 L 结尾：123L
16 进制以 0x 开头：0x0F
2 进制以 0b 开头：0b00001011
注意：8进制不支持
Kotlin 同时也支持传统符号表示的浮点数值：

Doubles 默认写法: 123.5, 123.5e10
Floats 使用 f 或者 F 后缀：123.5f
 */

fun main(args: Array<String>) {
    println("basic-types.kt")

    constTest()
    digitEquals()
    testCast()
    testShift()
    testChar()
    testArray()

    testString2()
}

//使用下划线使数字常量更易读
fun constTest() {
    val oneMillion = 1_000_000;
    val creditCardNumber = 1234_4567_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b10101111_01010101_11110000
}

//比较两个数字
//Kotlin 中没有基础数据类型，只有封装的数字类型，你每定义的一个变量，
// 其实 Kotlin 帮你封装了一个对象，这样可以保证不会出现空指针。
// 数字类型也一样，所以在比较两个数字的时候，
// 就有比较数据大小和比较两个对象是否相同的区别了。
//在 Kotlin 中，三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小。
fun digitEquals() {
    val a:Int = 10000
    println(a === a) //true，值相等，对象地址相等

    //经过了装箱，创建了两个不同的对象
    val boxedA: Int? = a
    val boxedB: Int? = a

    //虽然经过了装箱，但是值是相等的，都是10000
    println(boxedA === boxedB) //  false，值相等，对象地址不一样
    println(boxedA == boxedB) // true，值相等
}

/*
类型转换
由于不同的表示方式，较小类型并不是较大类型的子类型，较小的类型不能隐式转换为较大的类型。 这意味着在不进行显式转换的情况下我们不能把 Byte 型值赋给一个 Int 变量。

val b: Byte = 1 // OK, 字面值是静态检测的
val i: Int = b // 错误
我们可以代用其toInt()方法。
val b: Byte = 1 // OK, 字面值是静态检测的
val i: Int = b.toInt() // OK

每种数据类型都有下面的这些方法，可以转化为其它的类型：
toByte(): Byte
toShort(): Short
toInt(): Int
toLong(): Long
toFloat(): Float
toDouble(): Double
toChar(): Char
有些情况下也是可以使用自动类型转化的，前提是可以根据上下文环境推断出正确的数据类型而且数学操作符会做相应的重载。例如下面是正确的：
val l = 1L + 3 // Long + Int => Long
 */
fun testCast() {
    val b:Byte = 1 // OK, 字面值是静态检测的
    //val i:Int = b // 错误
    val i:Int = b.toInt() //OK

    val l:Long = b + 10L // Int + Long => Long
}

/*
位操作符
对于Int和Long类型，还有一系列的位操作符可以使用，分别是：
 */
fun testShift() {
    val bits: Long = 0b10001111

    println(bits)
    println(bits shl 1) //左移位 (Java’s <<)
    println(bits shr 1) //右移位 (Java’s >>)
    println(bits ushr 1) //无符号右移位 (Java’s >>>)
    println(bits and 1) //与
    println(bits or 1) //或
    println(bits xor 1) //异或
    println(bits.inv()) //反向

    println("---------------")
    println(bits.shl(1))
    println(bits.shr(1))
    println(bits.ushr(1))
    println(bits.and(1))
    println(bits.or(1))
    println(bits.xor(1))
    println(bits.inv()) //反向
}

/*
字符
和 Java 不一样，Kotlin 中的 Char 不能直接和数字操作，
Char 必需是单引号 ' 包含起来的。比如普通字符 '0'，'a'。
fun check(c: Char) {
    if (c == 1) { // 错误：类型不兼容
        // ……
    }
}
字符字面值用单引号括起来: '1'。 特殊字符可以用反斜杠转义。
支持这几个转义序列：\t、 \b、\n、\r、\'、\"、\\ 和 \$。
 编码其他字符要用 Unicode 转义序列语法：'\uFF00'。
我们可以显式把字符转换为 Int 数字：
fun decimalDigitValue(c: Char): Int {
    if (c !in '0'..'9')
        throw IllegalArgumentException("Out of range")
    return c.toInt() - '0'.toInt() // 显式转换为数字
}
当需要可空引用时，像数字、字符会被装箱。装箱操作不会保留同一性。
 */
fun testChar() {
    var c: Char = '1'
    println("testChar")
    println(c.digitToInt())
    val c2: Char = 'a'
    //println(c2.digitToInt())//Char a is not a decimal digit
}

/*
数组
数组用类 Array 实现，并且还有一个 size 属性及 get 和 set 方法，
由于使用 [] 重载了 get 和 set 方法，
所以我们可以通过下标很方便的获取或者设置数组对应位置的值。

数组的创建两种方式：一种是使用函数arrayOf()；
另外一种是使用工厂函数。如下所示，我们分别是两种方式创建了两个数组：
 */
fun testArray() {
    println("testArray")
    //[1,2,3]
    val a = arrayOf(1,2,3)
    //[0,2,4]
    val b = Array(3) { i -> (i * 2) }
    //除了类Array，还有ByteArray, ShortArray, IntArray，用来表示各个类型的数组，省去了装箱操作，因此效率更高，其用法同Array一样：
    val array2 = intArrayOf(1, 2, 3, 4)
    val array4 = Array(5) { 0 } //初始化长度为5，元素均为0的数组
    val arrayEmpty = emptyArray<String>()//创建空数组，只读

    val array1 = arrayOfNulls<Int>(5)//创建指定长度的可空数组
    for (i in 0..4) {
        array1[i] = i
    }

    //val array = Array(4, { i -> i * i })

    //遍历数组
    val array7 = Array(4) { i -> i * i }  //0,1,4,9,16
// 遍历数组元素
    for (item in array7) {
        print(item)
        print(',')
    }
    println()
// 遍历数组下标
    for (item in array7.indices) {
        print(item)
        print(',')
    }
    println()
// 迭代器遍历数组1
    val it = array7.iterator()
    for (item in it.iterator()) {
        print(item)
        print(',')
    }
    println()
// 迭代器遍历数组2
    val it1 = array7.iterator()
    it1.forEach {
        print(it)
        print(',')
    }
    println()
// forEach遍历数组
    array7.forEach {
        print(it)
        print(',')
    }
    println()
}

/*
字符串
和 Java 一样，String 是不可变的。
方括号 [] 语法可以很方便的获取字符串中的某个字符，也可以通过 for 循环来遍历：
 */
fun testString2() {
    val str = "abcde";
    for (c in str) {
        print("$c,")
    }
    println()
    //Kotlin 支持三个引号 """ 扩起来的字符串，支持多行字符串，比如：
    val text = """
        |多行字符串1
        |多行字符串2
        |多行字符串3
    """
    println(text)
    //String 可以通过 trimMargin() 方法来删除多余的空白。
    //默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。
    println(text.trimMargin())
}