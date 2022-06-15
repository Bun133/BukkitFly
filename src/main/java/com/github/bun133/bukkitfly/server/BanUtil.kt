package com.github.bun133.bukkitfly.server

import com.github.bun133.bukkitfly.component.text
import org.bukkit.BanList
import org.bukkit.Server
import org.bukkit.entity.Player
import java.util.Date

fun Server.banPlayerByName(
    p: Player,
    kickIfOnline: Boolean,
    reason: String = "Banned by Plugin",
    expires: Date? = null,
    source: String = ""
) {
    val banList = this.getBanList(BanList.Type.NAME)
    banList.addBan(p.name, reason, expires, source)

    if (kickIfOnline) {
        p.kick(text(reason))
    }
}

fun Server.unbanPlayerByName(p: Player) {
    unbanPlayerByName(p.name)
}

fun Server.unbanPlayerByName(name: String) {
    val banList = this.getBanList(BanList.Type.NAME)
    banList.pardon(name)
}