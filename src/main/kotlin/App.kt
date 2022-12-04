object App {
    private fun readInputLines(f: String): List<String> = App::class.java.getResource(f)!!.readText().lines()

    fun solveDay(day: Int, d: Day) {
        val input = readInputLines("day$day.txt")
        println("┣━━━━━━━━━━━━━━━━━━━━┫")
        println("┃ Day %02d 1: %8d ┃".format(day, d.part1(input)))
        println("┃ Day %02d 2: %8d ┃".format(day, d.part2(input)))
    }
}

fun main() {
    println("┏━━━━━━━━━━━━━━━━━━━━┓")
    println("┃ AOC 2022           ┃")
    App.solveDay(1, Day1)
    App.solveDay(2, Day2)
    App.solveDay(3, Day3)
    App.solveDay(4, Day4)
    println("┗━━━━━━━━━━━━━━━━━━━━┛")
}
