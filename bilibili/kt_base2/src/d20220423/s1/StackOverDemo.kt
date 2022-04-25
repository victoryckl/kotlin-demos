package d20220423.s1

fun main() {
    println(add2(100, 0))
    //d20220423.d1.ollAdd(10000) //栈溢出
}

fun ollAdd(num:Int):Int {
    println("第${num+1}次运算")
    if (num == 1) {
        return 1
    } else {
        return num + ollAdd(num - 1)
    }
}

//尾递归优化，避免栈溢出
tailrec fun add2(num: Int, result: Int) : Int {
    if (num == 0) {
        return 1
    } else {
        return add2(num - 1, result + num)
    }
}
