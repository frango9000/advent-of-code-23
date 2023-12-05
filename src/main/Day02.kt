fun main() {
    val input = readInput("main/Day02")
    printTime { println(Day02.part1(input)) }
    printTime { println(Day02.part2(input)) }
}

class Day02 {
    companion object {
        fun part1(input: List<String>): Int {
            val games = input.map { Game(it) }
            val validGames = games.filter { it.red <= 12 && it.green <= 13 && it.blue <= 14 }
            return validGames.sumOf { it.id }
        }

        fun part2(input: List<String>): Int {
            val games = input.map { Game(it) }
            return games.sumOf { it.green * it.red * it.blue }
        }
    }

    class Game(input: String) {
        val id: Int
        var blue: Int = 0
        var red: Int = 0
        var green: Int = 0

        init {
            val inputSplit = input.split(":")
            id = inputSplit[0].split(" ")[1].toInt()
            inputSplit[1].split(";").forEach { colors ->
                for (dice in colors.split(",").map { it.trim() }) {
                    val count = dice.split(" ")[0].toInt()
                    val color = dice.split(" ")[1]
                    when (color) {
                        "blue" -> blue = maxOf(blue, count)
                        "red" -> red = maxOf(red, count)
                        "green" -> green = maxOf(green, count)
                    }
                }
            }
        }
    }
}
