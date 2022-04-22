package com.derry.s3

//安全操作符
fun main() {
    var name: String? = "kity"
    //println(name.length);
    println(name?.length);// 如果 name == null，则不再调用后续方法
}