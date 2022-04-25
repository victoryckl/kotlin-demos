package d20220423.s1

class WashMachine(var name:String, var size:Int) {
    private var isDoorOpen = false;
    private var currentMode = 0
    private var speed: Int = 0;

    fun openDoor() {
        println("洗衣机的门打开了")
        isDoorOpen = true;
    }

    fun closeDoor() {
        println("洗衣机的门关闭了")
        isDoorOpen = false
    }

    fun selectMode(mode: Int) {
        currentMode = mode
        when(mode) {
            0 -> println("初始化，请选择模式")
            1 -> {
                println("轻柔")
                setMotorSpeed(10);
            }
            2 -> {
                println("标准")
                setMotorSpeed(100);
            }
            else -> println("不要乱按啊啊~")
        }
    }

    fun start() {
        if (isDoorOpen) {
            println("bibibibi...先关门啊")
        } else {
            when(currentMode) {
                0 -> println("模式错误")
                1 -> {
                    println("放水")
                    println("电机开始转动，转速 ${speed}转/秒")
                    println("洗好了")
                }
                2 -> {
                    println("放水")
                    println("电机开始转动，转速 ${speed}转/秒")
                    println("洗好了")
                }
                else -> println("模式错误啦")
            }
        }
    }

    private fun setMotorSpeed(speed:Int) {
        this.speed = speed;
    }
}