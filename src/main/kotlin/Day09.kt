import kotlin.math.abs
import kotlin.math.sign

object Day09 : Day {
    enum class Direction(val x: Int, val y: Int) {
        U(1, 0), D(-1, 0), L(0, -1), R(0, 1)
    }

    data class Knot(val x: Int, val y: Int) {
        fun move(dir: Direction) = this.copy(x = x + dir.x, y = y + dir.y)
        fun isAdjacent(other: Knot) = abs(this.x - other.x) <= 1 && abs(this.y - other.y) <= 1
    }

    private fun move(knots: List<Knot>, dir: Direction): List<Knot> =
        knots.drop(1).scan(knots.first().move(dir)) { head, tail ->
            if (head.isAdjacent(tail)) tail
            else Knot(x = (head.x - tail.x).sign + tail.x, y = (head.y - tail.y).sign + tail.y)
        }

    private fun parseInput(input: List<String>): List<Direction> =
        input.map { it.split(" ") }
            .flatMap { (d, count) -> List(count.toInt()) { Direction.valueOf(d) } }

    private fun solveForRopeLength(input: List<String>, length: Int) =
        parseInput(input)
            .scan(List(length) { Knot(0, 0) }, ::move)
            .map { it.last() }
            .toSet()
            .size

    override fun part1(input: List<String>): Int = solveForRopeLength(input, 2)

    override fun part2(input: List<String>): Int = solveForRopeLength(input, 10)
}
