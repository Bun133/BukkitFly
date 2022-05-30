package com.github.bun133.bukkitfly.particle

import com.github.bun133.bukkitfly.util.Line
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.World

/**
 * Minecraftのエフェクトを直線にしたものを表すクラス
 *
 * @param samplingRate サンプリングレート(何ブロック毎に1つのパーティクルを発生させるか)
 * @param forceEnds 両端で強制的にパーティクルを発生させるか
 */
class LineParticle(
    val line: Line,
    val particle: Particle,
    val samplingRate: Double,
    val forceEnds: Boolean = true,
) {
    /**
     * [line]に沿ってエフェクトを発生させる
     */
    fun playEffect(world: World) {
        val locations = locations(world)
        locations.forEach {
            it.world.spawnParticle(particle, it, 1)
        }
    }

    fun locations(world: World): List<Location> {
        val list = mutableListOf<Location>()
        if (forceEnds) {
            list.add(line.from.toLocation(world))
            list.add(line.to.toLocation(world))
        }

        list.addAll(line.frequent(samplingRate, world))

        return list
    }
}