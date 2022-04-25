package d20220423.s5sealed

fun main(args: Array<String>) {
    //var s:Son = Son(); 无法直接生成密封类
    var s1:Son = Son.小驴()
    s1.sayHello()
    var s2:Son = Son.骡子()
    s2.sayHello()

}