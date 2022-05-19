package com.github.bun133.bukkitfly.stack

import org.bukkit.NamespacedKey
import org.bukkit.inventory.ItemStack
import org.bukkit.persistence.PersistentDataType
import kotlin.reflect.KProperty

/**
 * アイテムスタックのデータ等を'by'で委譲することができるクラス
 */
open class DelegatedItemStack(val stack: ItemStack) {
    /**
     * アイテムスタックのデータ等を'by'で委譲するための実態クラス
     */
    object Delegates {
        /**
         * PersistentDataType.STRINGを使ってDelegateする
         */
        class PersistentString<C:DelegatedItemStack>(private val d: DelegatedItemStack, private val key: NamespacedKey) {
            operator fun getValue(thisRef: C, property: KProperty<*>): String? {
                return d.stack.itemMeta?.persistentDataContainer?.get(key, PersistentDataType.STRING)
            }

            operator fun setValue(thisRef: C, property: KProperty<*>, value: String) {
                d.stack.itemMeta?.persistentDataContainer?.set(key, PersistentDataType.STRING, value)
            }
        }

        fun <C:DelegatedItemStack> C.persistentString(key: NamespacedKey): PersistentString<C> {
            return PersistentString(this, key)
        }

        /**
         * PersistentDataType.INTEGERを使ってDelegateする
         */
        class PersistentInteger<C:DelegatedItemStack>(private val d: DelegatedItemStack, private val key: NamespacedKey) {
            operator fun getValue(thisRef: C, property: KProperty<*>): Int? {
                return d.stack.itemMeta?.persistentDataContainer?.get(key, PersistentDataType.INTEGER)
            }

            operator fun setValue(thisRef: C, property: KProperty<*>, value: Int) {
                d.stack.itemMeta?.persistentDataContainer?.set(key, PersistentDataType.INTEGER, value)
            }
        }

        fun <C:DelegatedItemStack> C.persistentInteger(key: NamespacedKey): PersistentInteger<C> {
            return PersistentInteger(this, key)
        }

        /**
         * PersistentDataType.LONGを使ってDelegateする
         */
        class PersistentLong<C:DelegatedItemStack>(private val d: DelegatedItemStack, private val key: NamespacedKey) {
            operator fun getValue(thisRef: C, property: KProperty<*>): Long? {
                return d.stack.itemMeta?.persistentDataContainer?.get(key, PersistentDataType.LONG)
            }

            operator fun setValue(thisRef: C, property: KProperty<*>, value: Long) {
                d.stack.itemMeta?.persistentDataContainer?.set(key, PersistentDataType.LONG, value)
            }
        }

        fun <C:DelegatedItemStack> C.persistentLong(key: NamespacedKey): PersistentLong<C> {
            return PersistentLong(this, key)
        }

        /**
         * ItemMetaを使ってDelegateする
         */
        object ItemMeta {
            /**
             * 標準のItemMetaを使ってDelegateする
             */
            class ItemMeta<C:DelegatedItemStack>(private val d: DelegatedItemStack) {
                operator fun getValue(thisRef: C, property: KProperty<*>): org.bukkit.inventory.meta.ItemMeta {
                    return d.stack.itemMeta
                }

                operator fun setValue(
                    thisRef: C,
                    property: KProperty<*>,
                    value: org.bukkit.inventory.meta.ItemMeta
                ) {
                    d.stack.itemMeta = value
                }
            }

            fun <C:DelegatedItemStack> C.itemMeta(): ItemMeta<C> {
                return ItemMeta(this)
            }

            /**
             * MapMetaを使ってDelegateする
             */
            class MapMeta<C:DelegatedItemStack>(private val d: DelegatedItemStack) {
                operator fun getValue(thisRef: C, property: KProperty<*>): org.bukkit.inventory.meta.MapMeta? {
                    return d.stack.itemMeta as? org.bukkit.inventory.meta.MapMeta
                }

                operator fun setValue(
                    thisRef: C,
                    property: KProperty<*>,
                    value: org.bukkit.inventory.meta.MapMeta
                ) {
                    d.stack.itemMeta = value
                }
            }

            fun <C:DelegatedItemStack> C.mapMeta(): MapMeta<C> {
                return MapMeta(this)
            }
        }
    }
}