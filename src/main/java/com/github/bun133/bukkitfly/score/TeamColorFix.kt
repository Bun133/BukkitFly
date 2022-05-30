package com.github.bun133.bukkitfly.score

import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import org.bukkit.scoreboard.Team

/**
 * BukkitはTeamに色が設定されてないとエラーを投げるので
 */
fun Team.getColorSafe(defaultColor: TextColor = NamedTextColor.WHITE): TextColor {
    return try {
        this.color()
    } catch (e: IllegalStateException) {
        defaultColor
    }
}