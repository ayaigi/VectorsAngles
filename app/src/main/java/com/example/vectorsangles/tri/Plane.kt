package com.example.vectorsangles.tri

import com.example.vectorsangles.invalid
import com.example.vectorsangles.tri.plane.CoordinatesPlane
import com.example.vectorsangles.tri.plane.NormalPlane
import com.example.vectorsangles.tri.plane.ParameterPlane
import kotlin.math.absoluteValue
import com.example.vectorsangles.tri.plane.Plane as PlaneInterface

class Plane(plane: PlaneInterface) {
    private val para: ParameterPlane
    private val normal: NormalPlane
    private val coor: CoordinatesPlane

    companion object {
        fun fromPoints(
            a: Vector,
            b: Vector,
            c: Vector
        ): Plane {
            val ac = a - c
            val ab = a - b
            return Plane(ParameterPlane(a, ac, ab))
        }
    }

    init {
        when (plane) {
            is NormalPlane -> {
                normal = plane
                coor = normal.toCoordinatesPlane()
                para = coor.toParameter()
            }
            is ParameterPlane -> {
                para = plane
                normal = para.toNormal()
                coor = normal.toCoordinatesPlane()
            }
            is CoordinatesPlane -> {
                coor = plane
                para = coor.toParameter()
                normal = para.toNormal()
            }
            else -> invalid("")
        }
    }

    fun dotTest(v: Vector): Boolean {
        val l = coor.run {
            v.x * a + v.y * b + v.z * c
        }
        val r = (l - coor.sum).absoluteValue
        return r < 0.1f
    }

    fun normalVector(): Vector = normal.normalVector

    fun penetrationPoint(v: Line): Float? {
        val r1 = 1
        TODO()
    }
}
