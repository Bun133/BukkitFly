package com.github.bun133.bukkitfly.stack

import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import kotlin.reflect.KProperty

/**
 * アイテムスタックのデータ等を'by'で委譲するためのクラス
 */
class DelegatedItemStack(val stack: ItemStack) {
    class PersistentString(private val d: DelegatedItemStack, private val key: NamespacedKey) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): String? {
            return d.stack.itemMeta?.persistentDataContainer?.get(key, PersistentDataType.STRING)
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
            d.stack.itemMeta?.persistentDataContainer?.set(key, PersistentDataType.STRING, value)
        }
    }

    class PersistentInteger(private val d: DelegatedItemStack, private val key: NamespacedKey) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): Int? {
            return d.stack.itemMeta?.persistentDataContainer?.get(key, PersistentDataType.INTEGER)
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
            d.stack.itemMeta?.persistentDataContainer?.set(key, PersistentDataType.INTEGER, value)
        }
    }

    class PersistentLong(private val d: DelegatedItemStack, private val key: NamespacedKey) {
        operator fun getValue(thisRef: Any?, property: KProperty<*>): Long? {
            return d.stack.itemMeta?.persistentDataContainer?.get(key, PersistentDataType.LONG)
        }

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
            d.stack.itemMeta?.persistentDataContainer?.set(key, PersistentDataType.LONG, value)
        }
    }
}