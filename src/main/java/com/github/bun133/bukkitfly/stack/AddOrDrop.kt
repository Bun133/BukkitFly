package com.github.bun133.bukkitfly.stack

import org.bukkit.entity.Item
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.PlayerInventory

/**
 * プレイヤーのインベントリにアイテムを追加する、できなければドロップする
 */
fun PlayerInventory.addOrDrop(vararg stack: ItemStack): List<Item>? {
    val notAdded = this.addItem(*stack)
    var isSuccess = true

    val h = this.holder
    return if (h is Player) {
        notAdded.map { (_, u) ->
            h.location.world.dropItem(h.location, u)
        }
    } else {
        null
    }
}