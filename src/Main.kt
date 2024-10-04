import kotlin.math.abs

data class Point(val x: Double, val y: Double)

class Triangle(val p1: Point, val p2: Point, val p3: Point) {
    private fun area(a: Point, b: Point, c: Point) = abs((a.x * (b.y - c.y) + b.x * (c.y - a.y) + c.x * (a.y - b.y)) / 2.0)
    fun contains(point: Point) = abs(area(p1, p2, p3) - (area(point, p1, p2) + area(point, p2, p3) + area(point, p1, p3))) < 1e-9
}

fun main() {
    println("Программа для проверки нахождения точки внутри треугольника на координатной плоскости.")

        fun readCoordinate(prompt: String): Double {
            while (true) {
                print(prompt)
                readLine()?.let {
                    it.toDoubleOrNull()?.let { return it }
                    println("Ошибка ввода: Пожалуйста, введите корректное число.")
                } ?: println("Ошибка ввода: Ввод не может быть пустым.")
            }
        }

    println("Введите координаты вершин треугольника:")
    val triangle = Triangle(Point(readCoordinate("X1: "), readCoordinate("Y1: ")),
    Point(readCoordinate("X2: "), readCoordinate("Y2: ")),
    Point(readCoordinate("X3: "), readCoordinate("Y3: ")))

    println("Введите координаты точки для проверки:")
    val point = Point(readCoordinate("X: "), readCoordinate("Y: "))

    println(if (triangle.contains(point)) "Точка находится внутри треугольника." else "Точка находится вне треугольника.")
}