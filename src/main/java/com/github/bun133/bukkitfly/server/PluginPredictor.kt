package com.github.bun133.bukkitfly.server

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.PluginClassLoader

class PluginPredictor() {
    fun predict(): JavaPlugin? {
        val loader = this.javaClass.classLoader
        if (loader is PluginClassLoader) {
            return loader.plugin
        }
        return null
    }
}

/**
 * クラスローダーからプラグインを取得する
 */
fun plugin(): JavaPlugin? {
    return PluginPredictor().predict()
}