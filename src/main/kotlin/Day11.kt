object Day11 : Day {

    data class Monkey(
        val items: MutableList<Long>,
        val operation: (Long) -> Long,
        val divisible: Long,
        val positive: Int,
        val negative: Int,
        var inspectedItem: Long = 0
    ) {
        fun inspectItem(): Long = operation(items.removeFirst()).also { inspectedItem++ }
        fun nextMonkey(item: Long) = if (item % divisible == 0L) positive else negative
    }

    private fun parseMonkeys(input: List<String>) =
        input.chunked(7)
            .map { monkey ->
                Monkey(
                    items = monkey[1].dropWhile { !it.isDigit() }.split(", ").map { it.toLong() }.toMutableList(),
                    operation = monkey[2].dropWhile { it != '+' && it != '*' }
                        .split(" ")
                        .let { (operator, value) ->
                            { old: Long ->
                                val operand = if (value == "old") old else value.toLong()
                                when (operator) {
                                    "+" -> old + operand
                                    "*" -> old * operand
                                    else -> throw IllegalStateException()
                                }
                            }
                        },
                    divisible = monkey[3].takeLastWhile { it.isDigit() }.toLong(),
                    positive = monkey[4].takeLastWhile { it.isDigit() }.toInt(),
                    negative = monkey[5].takeLastWhile { it.isDigit() }.toInt()
                )
            }

    private fun doRound(monkeys: List<Monkey>, reduceWorry: (Long) -> Long) =
        monkeys.forEach { monkey ->
            while (monkey.items.isNotEmpty()) {
                val worry = reduceWorry(monkey.inspectItem())
                monkeys[monkey.nextMonkey(worry)].items.add(worry)
            }
        }

    private fun monkeyBusiness(monkeys: List<Monkey>): Long =
        monkeys
            .map(Monkey::inspectedItem)
            .sortedDescending()
            .let { (a, b) -> a * b }

    override fun part1(input: List<String>): Long =
        parseMonkeys(input).let { monkeys ->
            repeat(20) {
                doRound(monkeys) { it / 3 }
            }
            monkeyBusiness(monkeys)
        }

    override fun part2(input: List<String>): Long =
        parseMonkeys(input).let { monkeys ->
            val commonDivisor = monkeys.map(Monkey::divisible).reduce { a, b -> a * b }
            repeat(10_000) {
                doRound(monkeys) { it % commonDivisor }
            }
            monkeyBusiness(monkeys)
        }
}
