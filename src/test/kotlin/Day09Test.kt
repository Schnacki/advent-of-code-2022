import kotlin.test.Test
import kotlin.test.assertEquals

class Day09Test {

    private val input = listOf(
        "R 4",
        "U 4",
        "L 3",
        "D 1",
        "R 4",
        "D 1",
        "L 5",
        "R 2"
    )

    private val largerInput = listOf(
        "R 5",
        "U 8",
        "L 8",
        "D 3",
        "R 17",
        "D 10",
        "L 25",
        "U 20"
    )

    @Test
    fun `Part 1 with example data`() {
        assertEquals(13, Day09.part1(input))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(1, Day09.part2(input))
        assertEquals(36, Day09.part2(largerInput))
    }
}
