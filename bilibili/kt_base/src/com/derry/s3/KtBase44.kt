package com.derry.s3

fun main() {
    val text = "Hello,Good,Body,Girl,HH,ZZ"
    val list = text.split(',')
    println("list:$list")

    val(v1,v2) = list; //解构
    println("v1:$v1,v2:$v2")

    val(n1,n2,n3,n4) = list; //解构
    println("n1:$n1,n2:$n2,n3:$n3,n4:$n4")

    //val(s1,s2,s3,s4,s5,s6) = list; //默认解构最多5个
}