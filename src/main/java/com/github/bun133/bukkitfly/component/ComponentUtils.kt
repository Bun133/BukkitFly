package com.github.bun133.bukkitfly.component

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.format.TextColor

operator fun Component.plus(other: Component): Component {
    return this.append(other)
}

fun text(str: String, color: TextColor? = null): TextComponent {
    if (color != null) {
        return Component.text(str).color(color)
    }
    return Component.text(str)
}