import kotlin.test.Test
import kotlin.test.assertEquals

class Day03Test {

    private val input = listOf(
        "vJrwpWtwJgWrhcsFMMfFFhFp",
        "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
        "PmmdzqPrVvPwwTWBwg",
        "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
        "ttgJtRGJQctTZtZT",
        "CrZsJsPPZsGzwwsLwLmpwMDw"
    )

    @Test
    fun `Part 1 with example data`() {
        assertEquals(157, Day03.part1(input))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(70, Day03.part2(input))
    }
}
