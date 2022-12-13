import kotlin.test.Test
import kotlin.test.assertEquals

class Day12Test {

    private val input = """
       Sabqponm
       abcryxxl
       accszExk
       acctuvwj
       abdefghi
    """.trimIndent().lines()

    @Test
    fun `Part 1 with example data`() {
        assertEquals(31, Day12.part1(input))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(29, Day12.part2(input))
    }
}
