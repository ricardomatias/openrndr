package org.openrndr.math

data class Vector2(val x: Double, val y: Double) {
    val length: Double
        get() = Math.sqrt(x * x + y * y)

    val squaredLength: Double
        get() = x* x + y * y


    val perpendicular: Vector2 get() = Vector2(-y, x)

    val normalized: Vector2 get() = this / length

    infix fun dot(right: Vector2) = x * right.x + y * right.y

    val yx get() = Vector2(y, x)
    val xx get() = Vector2(x, x)
    val yy get() = Vector2(y, y)
    val xy0 get() = Vector3(x, y, 0.0)
    val xy01 get() = Vector4(x, y, 0.0, 1.0)

    fun vector3(x:Double = this.x, y:Double = this.y, z:Double=0.0):Vector3 {
        return Vector3(x, y, z)
    }

    operator fun plus(vector2: Vector2) = Vector2(x + vector2.x, y + vector2.y)
    operator fun minus(vector2: Vector2) = Vector2(x - vector2.x, y - vector2.y)
    operator fun times(d: Double) = Vector2(x * d, y * d)
    operator fun div(d: Double) = Vector2(x / d, y / d)
    operator fun div(d : Vector2) = Vector2(x / d.x, y/d.y)

    companion object {
        val ZERO = Vector2(0.0, 0.0)
        val UNIT_X = Vector2(1.0, 0.0)
        val UNIT_Y = Vector2(0.0, 1.0)
        val INFINITY = Vector2(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)
    }
}

