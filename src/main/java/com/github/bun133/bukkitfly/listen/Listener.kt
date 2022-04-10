package com.github.bun133.bukkitfly.listen

import org.bukkit.event.Event

fun interface Listener<T : Event> {
    fun onEvent(listener:Listener<T>,event: T)
}