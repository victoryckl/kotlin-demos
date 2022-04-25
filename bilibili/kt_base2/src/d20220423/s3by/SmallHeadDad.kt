package d20220423.s3by

// 接口实现由BigHeadSon实现
class SmallHeadDad : IWashBowl by BigHeadSon {
    override fun washing() {
        println("看着大头儿子洗碗")
        BigHeadSon.washing()
        println("小头爸爸 洗碗 获得9元")
    }
}