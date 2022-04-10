package com.github.bun133.bukkitfly.stack

import net.kyori.adventure.text.TextComponent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

fun ItemStack.rename(comp: TextComponent) {
    this.editMeta {
        rename(comp)
    }
}

/**
 * @note style等は引き継がれません
 */
fun ItemMeta.rename(comp: TextComponent) {
    if (this.hasDisplayName()) {
        val bComp = this.displayName()!!
        if (bComp is TextComponent) {
            bComp.content(comp.content())
        }
    } else {
        this.displayName(comp)
    }
}