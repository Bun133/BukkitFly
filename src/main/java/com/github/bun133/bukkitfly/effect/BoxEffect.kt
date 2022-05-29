package com.github.bun133.bukkitfly.effect

import com.github.bun133.bukkitfly.util.Box
import org.bukkit.Effect
import org.bukkit.World

/**
 * Minecraftのエフェクトを箱型にしたものを表すクラス
 * @param samplingRate サンプリングレート(何ブロック毎に1つのエフェクトを発生させるか)
 * @param forceEnds 両端を強制的にエフェクトを発生させるか
 * @param data [World#playEffect]に渡すデータ
 */
class BoxEffect(
    box: Box,
    val effect: Effect,
    val samplingRate: Double,
    val forceEnds: Boolean = true,
    val data: Int = 0
) {
    val lineEffects = box.lines().map { LineEffect(it, effect, samplingRate, forceEnds, data) }

    fun playEffect(world: World) {
        lineEffects.forEach { it.playEffect(world) }
    }
}