# 目次

・[HumanEntity](https://github.com/Bun133/BukkitFly/blob/main/Functions.md#humanentity)
・[Component](https://github.com/Bun133/BukkitFly/blob/main/Functions.md#component)
・[FireWork](https://github.com/Bun133/BukkitFly/blob/main/Functions.md#firework)
・[Advancement](https://github.com/Bun133/BukkitFly/blob/main/Functions.md#advancement)
・[ItemStack](https://github.com/Bun133/BukkitFly/blob/main/Functions.md#itemstack)
・[Inventory](https://github.com/Bun133/BukkitFly/blob/main/Functions.md#inventory)
・[Effect](https://github.com/Bun133/BukkitFly/blob/main/Functions.md#effect)
・[Server](https://github.com/Bun133/BukkitFly/blob/main/Functions.md#server)
・[Display](https://github.com/Bun133/BukkitFly/blob/main/Functions.md#display)

# HumanEntity

| ファイル名                                                                                                                            | ファイル内容                 |
|----------------------------------------------------------------------------------------------------------------------------------|------------------------|
| [HumanEntity.Kill](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/entity/human/Kill.kt) | プレイヤーをkill,キルログの変更をします |

# Component

| ファイル名                                                                                                                                           | ファイル内容            |
|-------------------------------------------------------------------------------------------------------------------------------------------------|-------------------|
| [Component.ComponentUtils](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/component/ComponentUtils.kt) | Component系のUtilです |

# FireWork

| ファイル名                                                                                                                                            | ファイル内容     |
|--------------------------------------------------------------------------------------------------------------------------------------------------|------------|
| [FireWork.FireworkUtil](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/entity/firework/FireworkUtil.kt) | 花火系のUtilです |

# Advancement

| ファイル名                                                                                                                             | ファイル内容                  |
|-----------------------------------------------------------------------------------------------------------------------------------|-------------------------|
| [Advancement.Toast](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/advancement/Toast.kt) | 実績を使ってプレイヤーにToastを表示します |

# ItemStack

| ファイル名                                                                                                                                     | ファイル内容                                 |
|-------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------|
| [ItemStack.AddOrDrop](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/stack/AddOrDrop.kt)         | アイテムをプレイヤーのインベントリに加える、できなければ足元にドロップします |
| [DelegatedItemStack](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/stack/DelegatedItemStack.kt) | ItemStackからデータを読み取り、'by'で移譲するためのクラスです  |

# Inventory

| ファイル名                                                                                                                                              | ファイル内容                             |
|----------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------|
| [Inventory.ForceRemover](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/inventory/player/ForceRemover.kt) | PlayerQuitEventでremoveできない現象を回避します |

# Effect

| ファイル名                                                                                                                             | ファイル内容           |
|-----------------------------------------------------------------------------------------------------------------------------------|------------------|
| [Effect.LineEffect](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/effect/LineEffect.kt) | 直線状にエフェクトを発生させます |
| [Effect.BoxEffect](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/effect/BoxEffect.kt)   | 箱状にエフェクトを発生させます  |

# Server

| ファイル名                                                                                                                                       | ファイル内容                     |
|---------------------------------------------------------------------------------------------------------------------------------------------|----------------------------|
| [Server.PluginPredictor](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/server/PluginPredictor.kt) | クラスローダーからプラグインインスタンスを推測します |
| [Server.BanUtil](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/server/BanUtil.kt)                 | プレイヤーのBANの処理を簡略化します        |

# Display

| ファイル名                                                                                                                                   | ファイル内容                 |
|-----------------------------------------------------------------------------------------------------------------------------------------|------------------------|
| [MapDisplay](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/display/MapDisplay.kt)             | 複数のマップスタックをDisplayにします |
| [MapSingleDisplay](https://github.com/Bun133/BukkitFly/blob/main/src/main/java/com/github/bun133/bukkitfly/display/MapSingleDisplay.kt) | 一つのマップスタックをDisplayにします |
