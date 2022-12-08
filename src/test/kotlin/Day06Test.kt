import kotlin.test.Test
import kotlin.test.assertEquals

class Day06Test {

    @Test
    fun `Part 1 with example data`() {
        assertEquals(7, Day06.part1(listOf("mjqjpqmgbljsphdztnvjfqwrcgsmlb")))
        assertEquals(6, Day06.part1(listOf("nppdvjthqldpwncqszvftbrmjlhg")))
        assertEquals(10, Day06.part1(listOf("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")))
        assertEquals(11, Day06.part1(listOf("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(19, Day06.part2(listOf("mjqjpqmgbljsphdztnvjfqwrcgsmlb")))
        assertEquals(23, Day06.part2(listOf("bvwbjplbgvbhsrlpgdmjqwftvncz")))
        assertEquals(23, Day06.part2(listOf("nppdvjthqldpwncqszvftbrmjlhg")))
        assertEquals(29, Day06.part2(listOf("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")))
        assertEquals(26, Day06.part2(listOf("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")))
    }
}
