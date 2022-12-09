object Day03 : Day {
    private fun prioritize(item: Char) = if (item.isUpperCase()) item - 'A' + 27 else item - 'a' + 1

    private fun findCommonItem(compartments: List<String>): Char =
        compartments.map(String::toSet).reduce { a, b -> a.intersect(b) }.first()

    private fun prioritizeItems(input: List<String>, chunkIntoCompartments: (List<String>) -> List<List<String>>) =
        chunkIntoCompartments(input)
            .map(::findCommonItem)
            .sumOf(::prioritize)

    override fun part1(input: List<String>) =
        prioritizeItems(input) { rucksacks -> rucksacks.map { it.chunked(it.length / 2) } }

    override fun part2(input: List<String>) = prioritizeItems(input) { rucksacks -> rucksacks.chunked(3) }
}
