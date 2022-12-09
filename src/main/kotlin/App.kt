import java.net.URL

private const val AOC_BANNER = "┃      \uD83C\uDF84 \u001B[1mAdvent of Code 2022\u001B[0m \uD83C\uDF84       ┃"
private const val CHECK = "\u001B[32m✔\u001B[0m"

object App {
    private fun readResourceLines(f: String): List<String> = (App::class.java.getResource(f) as URL).readText().lines()

    fun solveDay(day: Int, d: Day) {
        val input = readResourceLines("Day%02d.txt".format(day))
        println("┣━━━━━━╋━━━━━━━━━━━━━━━╋━━━━━━━━━━━━━━━┫")
        println("┃  %02d  ┃ %-11s %s ┃ %-11s %s ┃".format(day, d.part1(input), CHECK, d.part2(input), CHECK))
    }
}

fun main() {
    println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓")
    println(AOC_BANNER)
    println("┣━━━━━━┳━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━┫")
    println("┃ Day  ┃ Part 1        ┃ Part 2        ┃")
    App.solveDay(1, Day01)
    App.solveDay(2, Day02)
    App.solveDay(3, Day03)
    App.solveDay(4, Day04)
    App.solveDay(5, Day05)
    App.solveDay(6, Day06)
    App.solveDay(7, Day07)
    App.solveDay(8, Day08)
    App.solveDay(9, Day09)
    println("┗━━━━━━┻━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━┛")
}
