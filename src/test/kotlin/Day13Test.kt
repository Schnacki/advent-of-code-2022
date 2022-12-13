import kotlin.test.Test
import kotlin.test.assertEquals

class Day13Test {

    private val input = """
        [1,1,3,1,1]
        [1,1,5,1,1]

        [[1],[2,3,4]]
        [[1],4]

        [9]
        [[8,7,6]]

        [[4,4],4,4]
        [[4,4],4,4,4]

        [7,7,7,7]
        [7,7,7]

        []
        [3]

        [[[]]]
        [[]]

        [1,[2,[3,[4,[5,6,7]]]],8,9]
        [1,[2,[3,[4,[5,6,0]]]],8,9]
    """.trimIndent().lines()

    @Test
    fun `Part 1 with example data`() {
        assertEquals(13, Day13.part1(input))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(140, Day13.part2(input))
    }
}
