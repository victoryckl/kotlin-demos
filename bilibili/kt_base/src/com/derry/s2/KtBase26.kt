package com.derry.s2

// it关键字
fun main() {
    val methodAction: (Int,Int,Int) -> String = { n1,n2,n3 ->
        val number = 454654
        var msg = "$number Derry , n1:$n1, n2:$n2, n3:$n3"
        println(msg)
        msg
    }

    methodAction.invoke(4,5,6)
    methodAction(1,2,3)

    val method2 : (String) -> String = {
        println(it);
        it
    }
    method2("hhhhhh")

    val method3 : (String) -> Unit = {
        println("$it, are you ok?")
    }
    method3("sdfsd")
}