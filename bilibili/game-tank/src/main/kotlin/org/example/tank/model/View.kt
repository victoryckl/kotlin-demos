package org.example.tank.model

interface View {

    val x : Int
    val y : Int

    val width : Int
    val height : Int

    fun draw()
}