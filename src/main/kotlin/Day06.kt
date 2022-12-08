object Day06 : Day {
    private fun solveForWindowSize(input: String, size: Int) =
        input.windowed(size).indexOfFirst { it.length == it.toSet().size } + size

    override fun part1(input: List<String>): Int = solveForWindowSize(input[0], 4)

    override fun part2(input: List<String>): Int = solveForWindowSize(input[0], 14)
}
