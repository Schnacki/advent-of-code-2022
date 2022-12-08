object Day08 : Day {
    override fun part1(input: List<String>): Int {
        val matrix = input.map(String::toCharArray)
        var visibilityCount = 0
        for (x in matrix.indices) {
            for (y in matrix[x].indices) {
                val height = matrix[x][y]
                val visibleX1 = (0 until x).all { matrix[it][y] < height }
                val visibleX2 = (x + 1 until matrix.size).all { matrix[it][y] < height }
                val visibleY1 = (0 until y).all { matrix[x][it] < height }
                val visibleY2 = (y + 1 until matrix[x].size).all { matrix[x][it] < height }
                if (visibleX1 || visibleX2 || visibleY1 || visibleY2) visibilityCount++
            }
        }
        return visibilityCount
    }

    override fun part2(input: List<String>): Int {
        val matrix = input.map(String::toCharArray)
        var highestScore = 0
        for (x in 1 until matrix.size - 1) {
            for (y in 1 until matrix[x].size - 1) {
                val height = matrix[x][y]
                val visibleX1 = (x - 1 downTo 1).takeWhile { matrix[it][y] < height }.size + 1
                val visibleX2 = (x + 1 until matrix.size - 1).takeWhile { matrix[it][y] < height }.size + 1
                val visibleY1 = (y - 1 downTo 1).takeWhile { matrix[x][it] < height }.size + 1
                val visibleY2 = (y + 1 until matrix[x].size - 1).takeWhile { matrix[x][it] < height }.size + 1
                val score = visibleX1 * visibleX2 * visibleY1 * visibleY2
                if (score >= highestScore) highestScore = score
            }
        }
        return highestScore
    }
}
