import kotlin.test.Test
import kotlin.test.assertEquals

class Day4Test {

    val input = listOf(
        "2-4,6-8",
        "2-3,4-5",
        "5-7,7-9",
        "2-8,3-7",
        "6-6,4-6",
        "2-6,4-8"
    )

    @Test
    fun part1() {
        assertEquals(2, Day4.part1(input))
    }

    @Test
    fun part2() {
        assertEquals(4, Day4.part2(input))
    }
}
