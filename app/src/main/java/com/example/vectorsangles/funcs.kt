package com.example.vectorsangles

import kotlin.math.PI


fun invalid(s: String = ""): Nothing = throw Exception(s)

fun Float.radToDeg() = (this * (180 / PI)).toFloat()