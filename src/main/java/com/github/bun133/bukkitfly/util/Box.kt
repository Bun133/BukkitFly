package com.github.bun133.bukkitfly.util

import org.bukkit.Location
import org.bukkit.util.BoundingBox
import kotlin.math.max
import kotlin.math.min

class Box(val x: Double, val y: Double, val z: Double, val xWidth: Double, val yHeight: Double, val zLength: Double) {
    companion object {
        fun of(x1: Double, y1: Double, z1: Double, x2: Double, y2: Double, z2: Double): Box {
            val minX = min(x1, x2)
            val minY = min(y1, y2)
            val minZ = min(z1, z2)
            val maxX = max(x1, x2)
            val maxY = max(y1, y2)
            val maxZ = max(z1, z2)
            return Box(minX, minY, minZ, maxX - minX, maxY - minY, maxZ - minZ)
        }

        fun of(from: Location, to: Location) = of(from.lineTo(to))

        fun of(line: Line) = of(line.from.x, line.from.y, line.from.z, line.to.x, line.to.y, line.to.z)

        fun of(box: BoundingBox) = of(box.minX, box.minY, box.minZ, box.maxX, box.maxY, box.maxZ)
    }

    /**
     * この箱のすべての辺の線分を返す
     *
     * (Copilotに書かせました。間違っててもGithubが悪いです。)
     */
    fun lines(): List<Line> {
        return listOf(
            Line(x, y, z, x + xWidth, y, z),
            Line(x, y, z, x, y + yHeight, z),
            Line(x, y, z, x, y, z + zLength),
            Line(x + xWidth, y, z, x + xWidth, y + yHeight, z),
            Line(x + xWidth, y, z, x + xWidth, y, z + zLength),
            Line(x, y + yHeight, z, x + xWidth, y + yHeight, z),
            Line(x, y + yHeight, z, x, y + yHeight, z + zLength),
            Line(x, y, z + zLength, x + xWidth, y, z + zLength),
            Line(x, y, z + zLength, x, y + yHeight, z + zLength),
            Line(x + xWidth, y, z + zLength, x + xWidth, y + yHeight, z + zLength),
            Line(x + xWidth, y + yHeight, z + zLength, x, y + yHeight, z + zLength),
            Line(x + xWidth, y + yHeight, z + zLength, x + xWidth, y, z + zLength)
        )
    }
}