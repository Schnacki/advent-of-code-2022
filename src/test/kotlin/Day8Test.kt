import kotlin.test.Test
import kotlin.test.assertEquals

class Day8Test {

    private val input = listOf(
        "30373",
        "25512",
        "65332",
        "33549",
        "35390"
    )

    @Test
    fun `Part 1 with example data`() {
        assertEquals(21, Day8.part1(input))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(8, Day8.part2(input))
    }
}
