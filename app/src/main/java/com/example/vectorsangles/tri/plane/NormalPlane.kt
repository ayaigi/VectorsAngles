package com.example.vectorsangles.tri.plane

import com.example.vectorsangles.tri.Vector

class NormalPlane(val normalVector: Vector, val support: Vector) : Plane {
    fun toCoordinatesPlane() = CoordinatesPlane(
        normalVector.x,
        normalVector.y,
        normalVector.z,
        normalVector.scalarProduct(support)
    )
}