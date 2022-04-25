package d20220423.s2
//接口表示能力
//抽象类表示本质
fun main(args: Array<String>) {
    var man = Man()
    //man.xiaodidi()

    var taijian = Taijian()
    //taijian.eat()

    var house = listOf(man, taijian)
    for (p in house) {
        if (p is IMan) {
            p.xiaodidi()
        }
        p.eat()
    }
}