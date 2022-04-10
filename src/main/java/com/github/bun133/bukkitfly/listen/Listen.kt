package com.github.bun133.bukkitfly.listen

import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.HandlerList
import org.bukkit.plugin.Plugin

val listenerMap = mutableMapOf<Listener<*>, org.bukkit.event.Listener>()

inline fun <reified T : Event> Plugin.listen(
    listener: Listener<T>,
    priority: EventPriority = EventPriority.NORMAL,
    ignoreCancelled: Boolean = false
) {
    val bukkit = DummyListener()

    listenerMap[listener] = bukkit

    server.pluginManager.registerEvent(
        T::class.java,
        bukkit,
        priority,
        { _, event -> listener.onEvent(listener, event as T) },
        this,
        ignoreCancelled
    )
}

class DummyListener : org.bukkit.event.Listener {}

inline fun <reified T : Event> Listener<T>.unregister(plugin: Plugin) {
    listenerMap[this]?.let {
        HandlerList.unregisterAll(it)
    }
}