package com.github.bun133.bukkitfly.particle

import com.github.bun133.bukkitfly.util.Box
import org.bukkit.Effect
import org.bukkit.Particle
import org.bukkit.World

/**
 * Minecraftのエフェクトを箱型にしたものを表すクラス
 * @param samplingRate サンプリングレート(何ブロック毎に1つのエフェクトを発生させるか)
 * @param forceEnds 両端を強制的にエフェクトを発生させるか
 * @param data [World#playEffect]に渡すデータ
 */
class BoxParticle(
    box: Box,
    val particle: Particle,
    val samplingRate: Double,
    val forceEnds: Boolean = true,
) {
    val lineParticles = box.lines().map { LineParticle(it, particle, samplingRate, forceEnds) }

    fun playEffect(world: World) {
        lineParticles.forEach { it.playEffect(world) }
    }
}