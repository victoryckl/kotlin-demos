package d20220423.s5sealed

// 母驴，公驴，公马，三者可能生下的后代，要么是小驴，要么是骡子
// sealed class 不可以继承，仅在内部实现有限的子类
// sealed更在意类型
// enum更在意数据
sealed class Son {

    fun sayHello() {
        println("我是一头${javaClass.simpleName}")
    }

    class 小驴():Son()
    class 骡子():Son()
}