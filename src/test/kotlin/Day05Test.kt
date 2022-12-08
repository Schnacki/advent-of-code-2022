import kotlin.test.Test
import kotlin.test.assertEquals

class Day05Test {

    private val input = listOf(
        "    [D]    ",
        "[N] [C]    ",
        "[Z] [M] [P]",
        " 1   2   3",
        "",
        "move 1 from 2 to 1",
        "move 3 from 1 to 3",
        "move 2 from 2 to 1",
        "move 1 from 1 to 2",
    )

    @Test
    fun `Part 1 with example data`() {
        assertEquals("CMZ", Day05.part1(input))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals("MCD", Day05.part2(input))
    }
}
