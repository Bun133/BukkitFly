package com.github.bun133.bukkitfly.advancement

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import java.util.UUID

fun Player.toast(toastData: ToastData, plugin: Plugin) {
    try {
        Bukkit.getUnsafe().loadAdvancement(NamespacedKey("bukkitfly", "toast${toastData.uuid}"), toastData.toJson())
        val adv = Bukkit.getAdvancement(NamespacedKey("bukkitfly", "toast${toastData.uuid}"))!!
        this.getAdvancementProgress(adv).also {
            it.awardCriteria("impossible")
            plugin.server.scheduler.runTaskLater(plugin, Runnable {
                it.revokeCriteria("impossible")
                Bukkit.getUnsafe().removeAdvancement(NamespacedKey("bukkitfly", "toast${toastData.uuid}"))
            }, 20)
        }
    } catch (e: java.lang.IllegalArgumentException) {
        return
    }
}

data class ToastData(
    val icon: Material,
    val title: String,
    val frame: FrameType,
    val description: String = "",
    val backGround: String = "minecraft:textures/gui/advancements/backgrounds/adventure.png",
    val uuid: UUID = UUID.randomUUID(),
) {
    fun toJson() = """
            {
                "criteria":{
                    "impossible":{
                        "trigger":"minecraft:impossible"
                    }
                },
                "display":{
                    "icon":{
                        "item":"${icon.key}"
                    },
                    "title":"$title",
                    "description":"$description",
                    "background":"$backGround",
                    "frame":"${frame.key}",
                    "announce_to_chat":false,
                    "show_toast":true,
                    "hidden":true
                }
            }
        """.trimIndent()

    enum class FrameType(val key: String) {
        Task("task"), Challenge("challenge"), Goal("goal");
    }
}