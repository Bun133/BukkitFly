package com.github.bun133.bukkitfly.util

import org.bukkit.Location
import org.bukkit.World

/**
 * 直線を表すクラス
 */
class Line(val from: Pos, val to: Pos) {
    constructor(x1:Double, y1:Double, z1:Double, x2:Double, y2:Double, z2:Double) : this(Pos(x1, y1, z1), Pos(x2, y2, z2))

    /**
     * @throws IllegalArgumentException if from and to are not in the same world
     */
    fun distance(): Double {
        return from.distance(to)
    }

    /**
     * [from]から[to]までの間で[step]ブロックごとに[Location]を取ってくる
     * @note [from]は含まれない、[to]は[step]によっては含まれることもある
     */
    fun frequent(step: Double, world: World): List<Location> {
        val result = mutableListOf<Location>()
        val distance = distance()
        val stepCount = distance / step
        val stepX = (to.x - from.x) / stepCount
        val stepY = (to.y - from.y) / stepCount
        val stepZ = (to.z - from.z) / stepCount
        var currentX = from.x
        var currentY = from.y
        var currentZ = from.z
        for (i in 0 until stepCount.toInt()) {
            result.add(Location(world, currentX, currentY, currentZ))
            currentX += stepX
            currentY += stepY
            currentZ += stepZ
        }
        return result
    }
}

fun Location.lineTo(to: Location): Line {
    return Line(Pos(this), Pos(to))
}