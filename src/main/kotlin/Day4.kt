object Day4 : Day {
    private fun parseRanges(line: String): Pair<IntRange, IntRange> {
        val (f1, f2, s1, s2) = line.split(",", "-").map(String::toInt)
        return f1..f2 to s1..s2
    }

    override fun part1(input: List<String>): Int = input
        .map(::parseRanges)
        .count { (r1, r2) -> r2.first in r1 && r2.last in r1 || r1.first in r2 && r1.last in r2 }

    override fun part2(input: List<String>): Int = input
        .map(::parseRanges)
        .count { (r1, r2) -> r2.first in r1 || r2.last in r1 || r1.first in r2 || r1.last in r2 }
}
