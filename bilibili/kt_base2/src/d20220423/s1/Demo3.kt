package d20220423.s1

fun main() {
    var washMachine = WashMachine("小天鹅", 10)
    washMachine.openDoor()
    println("小明把衣服放到洗衣机中")
    washMachine.closeDoor()
    washMachine.selectMode(1)
    washMachine.start()
}