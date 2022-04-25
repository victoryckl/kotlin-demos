package org.example.tank.model

import org.example.tank.Config
import org.itheima.kotlin.game.core.Painter

class Water(override var x : Int, override val y : Int) : View {
    override val width = Config.block
    override val height = Config.block

    override fun draw() {
        Painter.drawImage("/img/water.png", x, y)
    }
}