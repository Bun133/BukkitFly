package com.github.bun133.bukkitfly.entity.human

import com.github.bun133.bukkitfly.listen.Listener
import com.github.bun133.bukkitfly.listen.listen
import com.github.bun133.bukkitfly.listen.unregister
import net.kyori.adventure.text.Component
import org.bukkit.entity.HumanEntity
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.plugin.java.JavaPlugin

fun HumanEntity.kill(
    plugin: JavaPlugin,
    onDead: (Listener<PlayerDeathEvent>, PlayerDeathEvent) -> Unit,
    toCancel: Boolean = false
) {
    plugin.listen(Listener<PlayerDeathEvent> { l, e ->
        if (e.entity.uniqueId == this@kill.uniqueId) {
            e.isCancelled = toCancel
            onDead(l, e)
        }
    })

    this.health = 0.0
}

fun HumanEntity.kill(plugin: JavaPlugin, deathMessage: Component) {
    kill(plugin, { l, e ->
        e.deathMessage(deathMessage)
        l.unregister(plugin)
    }, false)
}