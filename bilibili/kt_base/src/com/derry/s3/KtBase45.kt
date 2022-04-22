package com.derry.s3

//replace
fun main() {
    val src = "ABCDEFGHIJKLMN"
    println(src)

    val newStr = src.replace(Regex("[AGK]")) {
        println(it.value)
        it.value
    }
    println(newStr)

    val newStr2 = src.replace(Regex("[AGK]")) {
        println(it.value)
        when(it.value) {
            "A" -> "9"
            "G" -> "4"
            "K" -> "3"
            else -> it.value
        }
    }
    println(newStr2)

    val newStr3 = newStr2.replace(Regex("[349]")) {
        println(it.value)
        when(it.value) {
            "9" -> "A"
            "4" -> "G"
            "3" -> "K"
            else -> it.value
        }
    }
    println(newStr3)
}