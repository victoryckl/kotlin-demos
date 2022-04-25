package org.example.tank

import javafx.application.Application
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import org.example.tank.enums.Direction
import org.example.tank.model.*
import org.itheima.kotlin.game.core.Painter
import org.itheima.kotlin.game.core.Window
import java.io.File

class GameWindow : Window(
    title = "坦克大战1.0",
    icon = "/img/kt.png",
    width = Config.gameWidth,
    height = Config.gameHeight) {

    private var views = arrayListOf<View>()

    private lateinit var tank : Tank

    override fun onCreate() {
        val file = File(javaClass.getResource("/map/1.map").path)
        val lines = file.readLines()
        lines.forEachIndexed { rowIndex, row ->
            val y = rowIndex * Config.block;
            row.toCharArray().forEachIndexed { colIndex, col ->
                val x = colIndex * Config.block
                when(col) {
                    '砖' -> views.add(Wall(x, y))
                    '铁' -> views.add(Steel(x, y))
                    '水' -> views.add(Water(x, y))
                    '草' -> views.add(Grass(x, y))
                }
            }
        }

        tank = Tank(9 * Config.block, 12 * Config.block)
        views.add(tank)
    }

    override fun onDisplay() {
        views.forEach {
            it.draw()
        }
    }

    override fun onKeyPressed(event: KeyEvent) {
        println("event.code = ${event.code}")
        when(event.code) {
            KeyCode.W -> tank.move(Direction.UP)
            KeyCode.S -> tank.move(Direction.DOWN)
            KeyCode.A -> tank.move(Direction.LEFT)
            KeyCode.D -> tank.move(Direction.RIGHT)
        }
    }

    override fun onRefresh() {
    }
}