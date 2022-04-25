package d20220423.s1

class Woman(name: String) : Human(name) {
    override fun eat() {
        println("$name 慢慢的吃饭")
    }

    override fun pee() {
        println("$name 蹲着尿尿")
    }
}