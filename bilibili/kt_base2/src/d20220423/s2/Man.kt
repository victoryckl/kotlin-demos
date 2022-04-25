package d20220423.s2

class Man : Human(), IMan {
    override fun xiaodidi() {
        println("有小弟弟")
    }

    override fun eat() {
        println("大口吃肉")
    }
}