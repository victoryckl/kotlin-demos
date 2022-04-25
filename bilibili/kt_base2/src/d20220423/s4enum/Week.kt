package d20220423.s4enum

enum class Week {
    星期一,星期二,星期三,星期四,星期五,星期六,星期日
}

fun main(args: Array<String>) {
    println(Week.星期一.ordinal)
    println(Week.星期一.name)

    println(Week.星期五.ordinal)
    println(Week.星期五.name)
    println(Week.星期五.toString())
}