package com.derry.s3

const val INFO = "refreshAfter Upload"

fun main() {
    var index = INFO.indexOf('A')
    println(INFO.substring(0..index))
    println(INFO.substring(0, index))
    println(INFO.substring(0 until index))
}