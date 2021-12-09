package com.example.vectorsangles.convert

import com.example.vectorsangles.tri.Plane
import com.example.vectorsangles.tri.Vector

fun main(){
    //convert((PI / 4).toFloat(), (PI / 4).toFloat())
}
/**
 * values in Radians
 */
class Convert(altitude: Float, azimuth: Float) {
    val Gamma: Float
    val Delta: Float
    init {
        val n = Vector(1,0,0)
        val s = Vector(-1,0,0)
        val sn = n - s
        val x = Vector.fromPolarH(altitude, azimuth)
        val p = Plane.fromPoints(n, s, x)
        Delta = p.normalVector().angle(x)
        Gamma = x.angle(sn)
    }
}
