import java.net.URL

object App {

    private const val GREEN_ARROW = "\u001B[32m✔\u001B[0m"

    private fun readResourceLines(f: String): List<String> = (App::class.java.getResource(f) as URL).readText().lines()

    fun solveDay(day: Int, d: Day) {
        val input = readResourceLines("day$day.txt")
        println("┣━━━━━━━━━━━━━━━━━━━━━━━━━┫")
        println("┃ Day %02d 1: %11s %s ┃".format(day, d.part1(input), GREEN_ARROW))
        println("┃ Day %02d 2: %11s %s ┃".format(day, d.part2(input), GREEN_ARROW))
    }
}

fun main() {
    println("┏━━━━━━━━━━━━━━━━━━━━━━━━━┓")
    println("┃   Advent of Code 2022   ┃")
    App.solveDay(1, Day1)
    App.solveDay(2, Day2)
    App.solveDay(3, Day3)
    App.solveDay(4, Day4)
    App.solveDay(5, Day5)
    App.solveDay(6, Day6)
    App.solveDay(7, Day7)
    println("┗━━━━━━━━━━━━━━━━━━━━━━━━━┛")
}
