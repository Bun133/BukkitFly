package com.github.bun133.bukkitfly.display

import java.awt.Graphics2D

interface Display {
    fun flush(f: (Graphics2D) -> Unit)
}