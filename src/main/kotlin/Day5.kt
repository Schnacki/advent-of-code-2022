typealias Stack = ArrayDeque<Char>

object Day5 : Day {

    data class Move(val src: Int, val dest: Int, val amount: Int)

    private fun parseInput(input: List<String>): Pair<List<Stack>, List<Move>> {
        val delimiter = input.indexOfFirst(String::isBlank)
        val crates = input.take(delimiter - 1).reversed()
            .map { it.chunked(4).map { it[1] } }
        val stacks = List<Stack>(crates[0].size, ::ArrayDeque)
        crates.forEach { row ->
            row.forEachIndexed { index, crate -> if (crate != ' ') stacks[index].addFirst(crate) }
        }
        val moves = input.drop(delimiter + 1)
            .map { it.split(" ") }
            .map { Move(it[3].toInt() - 1, it[5].toInt() - 1, it[1].toInt()) }
        return stacks to moves
    }

    private fun solve(input: List<String>, applyMove: (amount: Int, src: Stack, dst: Stack) -> Unit): String {
        val (stacks, moves) = parseInput(input)
        moves.forEach { move -> applyMove(move.amount, stacks[move.src], stacks[move.dest]) }
        return stacks.map(Stack::first).joinToString("")
    }

    override fun part1(input: List<String>): String =
        solve(input) { amount, src, dst ->
            repeat(amount) { dst.addFirst(src.removeFirst()) }
        }

    override fun part2(input: List<String>): String =
        solve(input) { amount, src, dst ->
            val tmpList = mutableListOf<Char>()
            repeat(amount) { tmpList.add(src.removeFirst()) }
            tmpList.reversed().forEach(dst::addFirst)
        }
}
