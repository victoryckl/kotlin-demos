package d20220423.s3by

// by关键字 -> 接口代理
fun main(args: Array<String>) {
    //var son = BigHeadSon()
    var son = BigHeadSon
    son.washing()

    var dad = SmallHeadDad()
    dad.washing()
}