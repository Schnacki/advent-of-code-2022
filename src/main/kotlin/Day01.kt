object Day01 : Day {
    // Unfortunately no real list deconstruction in kotlin :(
    private fun generatedAccumulatedList(input: List<String>): List<Int> = input
        .fold(listOf(0)) { cals, f -> if (f.isBlank()) cals + 0 else cals.dropLast(1) + (cals.last() + f.toInt()) }

    override fun part1(input: List<String>): Int = generatedAccumulatedList(input).max()

    override fun part2(input: List<String>): Int = generatedAccumulatedList(input).sortedDescending().take(3).sum()
}
