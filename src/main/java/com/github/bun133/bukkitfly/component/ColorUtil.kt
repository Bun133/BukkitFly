package com.github.bun133.bukkitfly.component

import net.kyori.adventure.text.format.TextColor
import java.awt.Color

fun TextColor.toAWTColor(): Color {
    val r = red()
    val g = green()
    val b = blue()
    return java.awt.Color(r, g, b)
}

fun Color.toAdventureColor(): TextColor {
    val r = red
    val g = green
    val b = blue
    return TextColor.color(r, g, b)
}