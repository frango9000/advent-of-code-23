fun main() {
    val input = readInput("Day00")
    printTime { println(Day00.part1(input)) }
    printTime { println(Day00.part2(input)) }
}


class Day00 {
    companion object {
        fun part1(input: List<String>): Int {
            return input.size
        }

        fun part2(input: List<String>): Int {
            return input.size
        }
    }
}
