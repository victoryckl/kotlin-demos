package d20220423.s1

class Man(name:String) : Human(name) {
    override fun eat() {
        println("$name 大口吃肉")
    }

    override fun pee() {
        println("$name 站着尿尿")
    }
}