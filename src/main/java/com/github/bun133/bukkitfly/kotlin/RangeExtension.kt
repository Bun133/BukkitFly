package com.github.bun133.bukkitfly.kotlin

infix fun ClosedRange<Double>.step(step: Double): Iterable<Double> {
    require(start.isFinite() && endInclusive.isFinite()) { "Range is infinite or NaN." }
    require(step > 0.0) { "Step must be positive, was: $step." }
    val sequence = generateSequence(start) { previous ->
        if (previous >= endInclusive) null
        else previous + step
    }
    return sequence.asIterable()
}