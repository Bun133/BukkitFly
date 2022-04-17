package com.github.bun133.bukkitfly.entity.firework

import org.bukkit.Location
import org.bukkit.World
import org.bukkit.entity.EntityType
import org.bukkit.entity.Firework
import org.bukkit.inventory.meta.FireworkMeta

/*
 * @See at [location/LocationSetGenerator.kt]
 */

fun World.spawnFireWork(loc: Location): Firework {
    return this.spawnEntity(loc, EntityType.FIREWORK) as Firework
}

fun World.spawnFireWork(loc: Location, f: (FireworkMeta) -> Unit): Firework {
    val firework = this.spawnFireWork(loc)
    val meta = firework.fireworkMeta
    f(meta)
    firework.fireworkMeta = meta
    return firework
}