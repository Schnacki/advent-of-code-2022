import java.net.URL

object App {

    private const val CHECK = "\u001B[32m✔\u001B[0m"

    private fun readResourceLines(f: String): List<String> = (App::class.java.getResource(f) as URL).readText().lines()

    fun solveDay(day: Int, d: Day) {
        val input = readResourceLines("day$day.txt")
        println("┣━━━━━━╋━━━━━━━━━━━━━━━╋━━━━━━━━━━━━━━━┫")
        println("┃  %02d  ┃ %-11s %s ┃ %-11s %s ┃".format(day, d.part1(input), CHECK, d.part2(input), CHECK))
    }
}

fun main() {
    println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓")
    println("┃         Advent of Code 2022          ┃")
    println("┣━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┫")
    println("┃ Day  ┃ Part 1        ┃ Part 2        ┃")
    App.solveDay(1, Day1)
    App.solveDay(2, Day2)
    App.solveDay(3, Day3)
    App.solveDay(4, Day4)
    App.solveDay(5, Day5)
    App.solveDay(6, Day6)
    App.solveDay(7, Day7)
    println("┗━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┛")
}
