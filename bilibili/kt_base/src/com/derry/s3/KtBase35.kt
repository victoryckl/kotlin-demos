package com.derry.s3

//可空类型
fun main() {
    //默认为不可空类型，不能赋值null
    var name: String = "jack"
    //name = null; //Null can not be a value of a non-null type String

    //类型后增加问号，声明为可空类型
    var name2: String? = "lily"
    name2 = null
}