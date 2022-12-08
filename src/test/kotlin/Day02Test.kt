import kotlin.test.Test
import kotlin.test.assertEquals

class Day02Test {

    private val input = listOf(
        "A Y",
        "B X",
        "C Z"
    )

    @Test
    fun `Part 1 with example data`() {
        assertEquals(15, Day02.part1(input))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(12, Day02.part2(input))
    }
}
