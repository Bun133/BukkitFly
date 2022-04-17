package com.github.bun133.bukkitfly.location

import com.github.bun133.bukkitfly.kotlin.step
import org.bukkit.Location
import org.bukkit.util.Vector
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

/**
 * 平面における極座標形式でのLocationの足し算
 * (+X方向を0rad,-Z方向をPI/2rad...とする)
 */
fun Location.addPolar2D(length: Double, angleRad: Double): Location {
    return this.add(Vector(length * cos(angleRad), 0.0, length * sin(angleRad)))
}

/**
 * 平面における、円上の点の切り出し
 * @param angleRad 切り出す間隔の中心角
 */
fun Location.circle2D(radius: Double, angleRad: Double): List<Location> {
    val collection = mutableListOf<Location>()
    for (i in (0.0..2.0 * PI step angleRad)) {
        collection.add(this.clone().addPolar2D(radius, i))
    }
    return collection
}