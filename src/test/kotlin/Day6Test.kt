import kotlin.test.Test
import kotlin.test.assertEquals

class Day6Test {


    @Test
    fun `Part 1 with example data`() {
        assertEquals(7, Day6.part1(listOf("mjqjpqmgbljsphdztnvjfqwrcgsmlb")))
        assertEquals(6, Day6.part1(listOf("nppdvjthqldpwncqszvftbrmjlhg")))
        assertEquals(10, Day6.part1(listOf("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")))
        assertEquals(11, Day6.part1(listOf("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(19, Day6.part2(listOf("mjqjpqmgbljsphdztnvjfqwrcgsmlb")))
        assertEquals(23, Day6.part2(listOf("bvwbjplbgvbhsrlpgdmjqwftvncz")))
        assertEquals(23, Day6.part2(listOf("nppdvjthqldpwncqszvftbrmjlhg")))
        assertEquals(29, Day6.part2(listOf("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")))
        assertEquals(26, Day6.part2(listOf("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")))
    }
}
