package com.github.bun133.bukkitfly.util

import org.bukkit.Location
import org.bukkit.World
import kotlin.math.sqrt

/**
 * 3次元の点を表すクラス
 */
class Pos(val x: Double, val y: Double, val z: Double) {
    constructor(loc: Location) : this(loc.x, loc.y, loc.z)

    fun distance(to: Pos): Double {
        return sqrt((x - to.x) * (x - to.x) + (y - to.y) * (y - to.y) + (z - to.z) * (z - to.z))
    }

    fun toLocation(world: World): Location {
        return Location(world, x, y, z)
    }
}