import kotlin.test.Test
import kotlin.test.assertEquals

class Day2Test {

    private val input = listOf("A Y", "B X", "C Z")

    @Test
    fun `Part 1 with example data`() {
        assertEquals(15, Day2.part1(input))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(12, Day2.part2(input))
    }
}