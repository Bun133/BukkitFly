package com.github.bun133.bukkitfly.stack

import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import kotlin.reflect.KProperty

/**
 * アイテムスタックのデータ等を'by'で委譲することができるクラス
 */
class DelegatedItemStack(val stack: ItemStack) {
    /**
     * アイテムスタックのデータ等を'by'で委譲するための実態クラス
     */
    object Delegates {
        /**
         * PersistentDataType.STRINGを使ってDelegateする
         */
        class PersistentString(private val d: DelegatedItemStack, private val key: NamespacedKey) {
            operator fun getValue(thisRef: Any?, property: KProperty<*>): String? {
                return d.stack.itemMeta?.persistentDataContainer?.get(key, PersistentDataType.STRING)
            }

            operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
                d.stack.itemMeta?.persistentDataContainer?.set(key, PersistentDataType.STRING, value)
            }
        }

        fun DelegatedItemStack.persistentString(key: NamespacedKey): PersistentString {
            return PersistentString(this, key)
        }

        /**
         * PersistentDataType.INTEGERを使ってDelegateする
         */
        class PersistentInteger(private val d: DelegatedItemStack, private val key: NamespacedKey) {
            operator fun getValue(thisRef: Any?, property: KProperty<*>): Int? {
                return d.stack.itemMeta?.persistentDataContainer?.get(key, PersistentDataType.INTEGER)
            }

            operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
                d.stack.itemMeta?.persistentDataContainer?.set(key, PersistentDataType.INTEGER, value)
            }
        }

        fun DelegatedItemStack.persistentInteger(key: NamespacedKey): PersistentInteger {
            return PersistentInteger(this, key)
        }

        /**
         * PersistentDataType.LONGを使ってDelegateする
         */
        class PersistentLong(private val d: DelegatedItemStack, private val key: NamespacedKey) {
            operator fun getValue(thisRef: Any?, property: KProperty<*>): Long? {
                return d.stack.itemMeta?.persistentDataContainer?.get(key, PersistentDataType.LONG)
            }

            operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
                d.stack.itemMeta?.persistentDataContainer?.set(key, PersistentDataType.LONG, value)
            }
        }

        fun DelegatedItemStack.persistentLong(key: NamespacedKey): PersistentLong {
            return PersistentLong(this, key)
        }

        /**
         * ItemMetaを使ってDelegateする
         */
        object ItemMeta {
            /**
             * 標準のItemMetaを使ってDelegateする
             */
            class ItemMeta(private val d: DelegatedItemStack) {
                operator fun getValue(thisRef: Any?, property: KProperty<*>): org.bukkit.inventory.meta.ItemMeta {
                    return d.stack.itemMeta
                }

                operator fun setValue(
                    thisRef: Any?,
                    property: KProperty<*>,
                    value: org.bukkit.inventory.meta.ItemMeta
                ) {
                    d.stack.itemMeta = value
                }
            }

            fun DelegatedItemStack.itemMeta(): ItemMeta {
                return ItemMeta(this)
            }

            /**
             * MapMetaを使ってDelegateする
             */
            class MapMeta(private val d: DelegatedItemStack) {
                operator fun getValue(thisRef: Any?, property: KProperty<*>): org.bukkit.inventory.meta.MapMeta? {
                    return d.stack.itemMeta as? org.bukkit.inventory.meta.MapMeta
                }

                operator fun setValue(
                    thisRef: Any?,
                    property: KProperty<*>,
                    value: org.bukkit.inventory.meta.MapMeta
                ) {
                    d.stack.itemMeta = value
                }
            }

            fun DelegatedItemStack.mapMeta(): MapMeta {
                return MapMeta(this)
            }
        }
    }
}