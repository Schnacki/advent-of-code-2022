import kotlin.test.Test
import kotlin.test.assertEquals

class Day3Test {

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
        assertEquals(157, Day3.part1(input))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(70, Day3.part2(input))
    }
}