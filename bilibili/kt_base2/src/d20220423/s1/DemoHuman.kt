package d20220423.s1

fun main(args: Array<String>) {
    var person1 = Man("金三胖")
    person1.eat()

    var person2 = Woman("小甜甜")
    person2.eat()

    var person3 = Man("张三丰")
    person3.eat()

    var person4 = Woman("小姐姐")
    person4.eat()

    var list = listOf(person1, person2, person3, person4)
    for (p in list) {
        p.pee()
    }
}