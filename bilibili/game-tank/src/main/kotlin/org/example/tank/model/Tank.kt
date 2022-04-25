package org.example.tank.model

import org.example.tank.Config
import org.example.tank.enums.Direction
import org.itheima.kotlin.game.core.Painter

class Tank(override var x : Int, override var y : Int) : View {
    override val width = Config.block
    override val height = Config.block

    val speed = 8
    var currentDirection = Direction.UP

    override fun draw() {
        var imagePath = when (currentDirection) {
            Direction.UP -> "/img/tank_u.png"
            Direction.DOWN -> "/img/tank_d.png"
            Direction.LEFT -> "/img/tank_l.png"
            Direction.RIGHT -> "/img/tank_r.png"
        }
        Painter.drawImage(imagePath, x, y)
    }

    fun move(direction: Direction) {
        if (currentDirection != direction) {
            currentDirection = direction
            return
        }

        when(currentDirection) {
            Direction.UP -> y -= speed
            Direction.DOWN -> y += speed
            Direction.LEFT -> x -= speed
            Direction.RIGHT -> x += speed
        }

        if (x < 0) x = 0
        if (x > Config.gameWidth - width) x = Config.gameWidth - width

        if (y < 0) y = 0
        if (y > Config.gameHeight - height) y = Config.gameHeight - height
    }
}