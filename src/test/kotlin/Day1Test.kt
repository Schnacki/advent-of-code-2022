import kotlin.test.Test
import kotlin.test.assertEquals

class Day1Test {

    private val input = listOf(
        "1000", "2000", "3000", "", "4000", "", "5000", "6000", "", "7000", "8000", "9000", "", "10000"
    )

    @Test
    fun `Part 1 with example data`() {
        assertEquals(24000, Day1.part1(input))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(45000, Day1.part2(input))
    }
}