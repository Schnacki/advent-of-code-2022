import Day02.Outcome.Draw
import Day02.Outcome.Lost
import Day02.Outcome.Won

object Day02 : Day {

    enum class Outcome {
        Won, Lost, Draw;

        companion object {
            fun parse(c: Char) = when (c) {
                'X' -> Lost
                'Y' -> Draw
                'Z' -> Won
                else -> error("Invalid input $c.")
            }
        }
    }

    enum class Play(val score: Int) {
        Rock(1),
        Paper(2),
        Scissor(3);

        fun pointsForWinner(play: Play) = when {
            this.score % 3 == ((play.score + 1) % 3) -> 6
            this.score == play.score -> 3
            else -> 0
        }

        fun playScores(outcome: Outcome) = when (this to outcome) {
            Rock to Won -> Paper
            Rock to Lost -> Scissor
            Rock to Draw -> Rock
            Paper to Won -> Scissor
            Paper to Lost -> Rock
            Paper to Draw -> Paper
            Scissor to Won -> Rock
            Scissor to Lost -> Paper
            Scissor to Draw -> Scissor
            else -> error("")
        }

        companion object {
            fun parse(c: Char) = when (c) {
                'A', 'X' -> Rock
                'B', 'Y' -> Paper
                'C', 'Z' -> Scissor
                else -> error("Invalid input $c.")
            }
        }
    }

    override fun part1(input: List<String>) = input
        .map(String::toCharArray)
        .map { (a, _, b) -> Play.parse(a) to Play.parse(b) }
        .sumOf { (enemy, player) -> player.score + player.pointsForWinner(enemy) }

    override fun part2(input: List<String>) = input
        .map(String::toCharArray)
        .map { (a, _, b) -> Play.parse(a) to Outcome.parse(b) }
        .map { (play, outcome) -> play to play.playScores(outcome) }
        .sumOf { (enemy, player) -> player.score + player.pointsForWinner(enemy) }
}
