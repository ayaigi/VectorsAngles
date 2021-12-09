package com.example.vectorsangles.tri.plane

import com.example.vectorsangles.tri.Vector

data class ParameterPlane(val support: Vector, val multiA: Vector, val multiB: Vector) : Plane {
    fun toNormal() = NormalPlane(multiA.crossProduct(multiB), support)
}