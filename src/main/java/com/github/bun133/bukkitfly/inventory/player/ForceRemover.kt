package com.github.bun133.bukkitfly.inventory.player

import com.github.bun133.bukkitfly.listen.Listener
import com.github.bun133.bukkitfly.listen.listen
import com.github.bun133.bukkitfly.listen.unregister
import org.bukkit.entity.Player
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.PlayerInventory
import org.bukkit.plugin.Plugin

/**
 * PlayerQuitEventでremoveをしようとするとバグるのでそれの回避用
 */
fun PlayerInventory.removeItemForce(plugin: Plugin, vararg items: ItemStack): Boolean {
    val p = this.holder
    return if (p is Player) {
        plugin.listen(Listener<PlayerJoinEvent> { listener, event ->
            if (event.player.uniqueId == p.uniqueId) {
                p.inventory.removeItem(*items)
                listener.unregister(plugin)
            }
        })
        true
    } else {
        false
    }
}

fun PlayerInventory.removeItemAnySlotForce(plugin: Plugin, vararg items: ItemStack): Boolean {
    val p = this.holder
    return if (p is Player) {
        plugin.listen(Listener<PlayerJoinEvent> { listener, event ->
            if (event.player.uniqueId == p.uniqueId) {
                p.inventory.removeItemAnySlot(*items)
                listener.unregister(plugin)
            }
        })
        true
    } else {
        false
    }
}