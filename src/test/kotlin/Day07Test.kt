import kotlin.test.Test
import kotlin.test.assertEquals

class Day07Test {

    private val input = listOf(
        "$ cd /",
        "$ ls",
        "dir a",
        "14848514 b.txt",
        "8504156 c.dat",
        "dir d",
        "$ cd a",
        "$ ls",
        "dir e",
        "29116 f",
        "2557 g",
        "62596 h.lst",
        "$ cd e",
        "$ ls",
        "584 i",
        "$ cd ..",
        "$ cd ..",
        "$ cd d",
        "$ ls",
        "4060174 j",
        "8033020 d.log",
        "5626152 d.ext",
        "7214296 k"
    )

    @Test
    fun `Part 1 with example data`() {
        assertEquals(95437, Day07.part1(input))
    }

    @Test
    fun `Part 2 with example data`() {
        assertEquals(24933642, Day07.part2(input))
    }
}
