object Day12 : Day {
    data class Area(val map: Map<Point, Char>, val start: Point, val end: Point)

    data class Point(val x: Int, val y: Int) {
        fun neighbours() = listOf(Point(x, y + 1), Point(x, y - 1), Point(x + 1, y), Point(x - 1, y))
    }

    private fun parseArea(input: List<String>): Area {
        lateinit var start: Point
        lateinit var end: Point
        val map = input.flatMapIndexed { x, row ->
            row.mapIndexed { y, col ->
                when (col) {
                    'S' -> (Point(x, y) to 'a').also { start = Point(x, y) }
                    'E' -> (Point(x, y) to 'z').also { end = Point(x, y) }
                    else -> Point(x, y) to col
                }
            }
        }.toMap()
        return Area(map, start, end)
    }

    private fun calculateDistances(area: Area): MutableMap<Point, Int> {
        val distances = mutableMapOf<Point, Int>()
        fun walk(distance: Int, pos: Point) {
            val prevDistance = distances[pos]
            if (prevDistance == null || prevDistance > distance) {
                distances[pos] = distance
                pos.neighbours()
                    .filter { area.map.containsKey(it) && (area.map[it]!! >= area.map[pos]!! - 1) }
                    .forEach { walk(distance + 1, it) }
            }
        }
        walk(0, area.end)
        return distances
    }

    override fun part1(input: List<String>): Int =
        parseArea(input).let { area -> calculateDistances(area)[area.start]!! }

    override fun part2(input: List<String>): Int =
        parseArea(input).let { area ->
            val distances = calculateDistances(area)
            area.map.filterValues { it == 'a' }.keys.mapNotNull { distances[it] }.min()
        }
}
