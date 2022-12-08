object App {
    private fun readInputLines(f: String): List<String> = App::class.java.getResource(f)!!.readText().lines()

    fun solveDay(day: Int, d: Day) {
        val input = readInputLines("day$day.txt")
        println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫")
        println("┃ Day %02d 1: %12s \u001B[32m✔\u001B[0m ┃".format(day, d.part1(input)))
        println("┃ Day %02d 2: %12s \u001B[32m✔\u001B[0m ┃".format(day, d.part2(input)))
    }
}

fun main() {
    println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━┓")
    println("┃ AOC 2022                 ┃")
    App.solveDay(1, Day1)
    App.solveDay(2, Day2)
    App.solveDay(3, Day3)
    App.solveDay(4, Day4)
    App.solveDay(5, Day5)
    App.solveDay(6, Day6)
    println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━┛")
}
