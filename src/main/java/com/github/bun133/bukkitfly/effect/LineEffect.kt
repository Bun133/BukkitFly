package com.github.bun133.bukkitfly.effect

import com.github.bun133.bukkitfly.util.Line
import org.bukkit.Effect
import org.bukkit.Location
import org.bukkit.World

/**
 * Minecraftのエフェクトを直線にしたものを表すクラス
 *
 * @param samplingRate サンプリングレート(何ブロック毎に1つのエフェクトを発生させるか)
 * @param forceEnds 両端を強制的にエフェクトを発生させるか
 * @param data [World#playEffect]に渡すデータ
 */
class LineEffect(
    val line: Line,
    val effect: Effect,
    val samplingRate: Double,
    val forceEnds: Boolean = true,
    val data: Int = 0
) {
    /**
     * [line]に沿ってエフェクトを発生させる
     */
    fun playEffect(world: World) {
        val locations = locations(world)
        locations.forEach {
            it.world.playEffect(it, effect, data)
        }
    }

    fun locations(world:World): List<Location> {
        val list = mutableListOf<Location>()
        if (forceEnds) {
            list.add(line.from.toLocation(world))
            list.add(line.to.toLocation(world))
        }

        list.addAll(line.frequent(samplingRate,world))

        return list
    }
}