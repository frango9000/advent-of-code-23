fun main() {
    val input = readInput("main/Day06")
    printTime { println(Day06.part1(input)) }
    printTime { println(Day06.part2(input)) }
}

class Day06 {
    companion object {
        fun part1(input: List<String>): Int {
            val digits = input.map { "\\d+".toRegex().findAll(it).map { it.value.toLong() }.toList() }
            val races = digits[0].withIndex().map { (i, it) -> Race(it, digits[1][i]) }

            val betterRuns = races.map { it.getBetterRuns() }

            return betterRuns.reduce { acc, s -> acc * s }
        }

        fun part2(input: List<String>): Int {
            val digits = input.map { "\\d+".toRegex().findAll(it.replace(" ", "")).map { it.value.toLong() }.toList() }
            val races = digits[0].withIndex().map { (i, it) -> Race(it, digits[1][i]) }

            val betterRuns = races.map { it.getBetterRuns() }

            return betterRuns.reduce { acc, s -> acc * s }
        }
    }

    class Race(val time: Long, val distance: Long) {
        override fun toString(): String {
            return "Race(time=$time, distance=$distance)"
        }

        fun getBetterRuns(): Int {
            var betterRunCounter = 0
            for (pressedTime in 1..<this.time) {
                val distance = (this.time - pressedTime) * pressedTime
                if (distance > this.distance) betterRunCounter++
            }
            return betterRunCounter
        }
    }
}
