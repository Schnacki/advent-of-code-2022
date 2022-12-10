object Day10 : Day {

    sealed interface Operation
    object NOOP : Operation
    data class Add(val inc: Int) : Operation

    private fun parseInput(input: List<String>): List<Operation> = input
        .map { if (it == "noop") NOOP else Add(it.split(" ")[1].toInt()) }

    private fun executeProgram(ops: List<String>): List<Int> {
        var x = 1 // :(
        return parseInput(ops).flatMap { op ->
            when (op) {
                is Add -> listOf(x, x).also { x += op.inc }
                is NOOP -> listOf(x)
            }
        }
    }

    override fun part1(input: List<String>): Int =
        executeProgram(input).let { reg ->
            listOf(20, 60, 100, 140, 180, 220).sumOf { it * reg[it - 1] }
        }

    override fun part2(input: List<String>): List<String> =
        executeProgram(input)
            .mapIndexed { index, x -> if ((index + 1) % 40 in (x..x + 2)) '#' else '.' }
            .chunked(40)
            .map { String(it.toCharArray()) }
}
