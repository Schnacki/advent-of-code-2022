import Day13.OrderResult.*

object Day13 : Day {

    sealed interface Item

    @JvmInline
    value class IntItem(val item: Int) : Item

    @JvmInline
    value class ListItem(val item: List<Item>) : Item {
        constructor(item: Item) : this(listOf(item))
    }

    private fun parseToken(s: String): Pair<Item, String> {
        var a = s.drop(1) // [
        val list = mutableListOf<Item>()
        while (a[0] != ']') {
            if (a[0].isDigit()) {
                list.add(IntItem(a.takeWhile { it.isDigit() }.toInt()))
                a = a.dropWhile { it.isDigit() }
            } else if (a[0] == '[') {
                val (subList, rest) = parseToken(a)
                a = rest
                list.add(subList)
            }
            if (a[0] == ',') a = a.drop(1)
        }
        return ListItem(list) to a.drop(1)
    }

    private fun parsePacket(s: String): Item = parseToken(s).first

    enum class OrderResult { Right, Wrong, Undecided }

    private fun compare(left: Item, right: Item): OrderResult =
        when (left) {
            is IntItem -> when (right) {
                is IntItem -> {
                    when {
                        left.item < right.item -> Right
                        left.item > right.item -> Wrong
                        else -> Undecided
                    }
                }

                is ListItem -> compare(ListItem(left), right)
            }

            is ListItem -> when (right) {
                is IntItem -> compare(left, ListItem(right))
                is ListItem -> {
                    left.item.zip(right.item).forEach { (l, r) ->
                        compare(l, r).takeIf { it != Undecided }?.apply { return this }
                    }
                    if (left.item.size > right.item.size) Wrong
                    else if (left.item.size < right.item.size) Right
                    else Undecided
                }
            }
        }

    override fun part1(input: List<String>): Int =
        input.chunked(3)
            .map { it.take(2).map(::parsePacket) }
            .mapIndexed { index, packet -> if (compare(packet[0], packet[1]) == Right) index + 1 else 0 }
            .sum()

    override fun part2(input: List<String>): Int {
        val dividers = listOf(ListItem(ListItem(IntItem(2))), ListItem(ListItem(IntItem(6))))
        val packets = (input.filter(String::isNotBlank).map(::parsePacket) + dividers)
            .sortedWith { i1, i2 -> if (compare(i1, i2) == Right) -1 else 1 }
        return dividers.map(packets::indexOf).reduce { x, y -> (x + 1) * (y + 1) }
    }
}
