package com.example.vectorsangles.tri

import kotlin.math.*

data class Vector(val x: Float, val y: Float, val z: Float) {

    constructor(x: Int, y: Int, z: Int) : this(x.toFloat(), y.toFloat(), z.toFloat())

    companion object {
        /**
         * angles in Radians
         *
         * a from Top
         */
        fun fromPolarT(a: Float, d: Float) = Vector(
            x = sin(a) * cos(d),
            y = sin(a) * sin(d),
            z = cos(a)
        )

        /**
         * angles in Radians
         *
         * a from Horizontal
         */
        fun fromPolarH(a: Float, d: Float): Vector {
            val a = ((PI / 2f) - a).toFloat()
            return Vector(
                x = sin(a) * cos(d),
                y = sin(a) * sin(d),
                z = cos(a)
            )
        }
    }

    fun crossProduct(v: Vector): Vector {
        return Vector(
            x = v.y * z - v.z * y,
            y = v.z * x - v.x * z,
            z = v.y * z - v.z * y
        )
    }

    fun scalarProduct(v: Vector): Float {
        return (x * v.x + y * v.y + z * v.z)
    }

    fun absolutValue(): Float {
        return sqrt(x * x + y * y + z * z)
    }

    fun angle(v: Vector): Float {
        return acos(scalarProduct(v) / (absolutValue() * v.absolutValue()))
    }

    operator fun plus(v: Vector) = Vector(
        x = x + v.x,
        y = y + v.y,
        z = z + v.z
    )

    operator fun minus(v: Vector) = Vector(
        x = x - v.x,
        y = y - v.y,
        z = z - v.z
    )

    operator fun times(v: Float) = Vector(
        x = x * v,
        y = y * v,
        z = z * v
    )

    operator fun div(v: Float) = Vector(
        x = x / v,
        y = y / v,
        z = z / v
    )
}