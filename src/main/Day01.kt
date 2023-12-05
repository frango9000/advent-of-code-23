fun main() {
    val input = readInput("main/Day01")
    printTime { println(Day01.part1(input)) }
    printTime { println(Day01.part2(input)) }
}


class Day01 {
    companion object {
        fun part1(input: List<String>): Int {
            return input.map { "\\d".toRegex().findAll(it).map { it.value }.toList() }
                .sumOf { ("${it[0]}${it[it.lastIndex]}").toInt() }
        }

        fun part2(input: List<String>): Int {
            return part1(input.map { replaceNumberSpelling(it) })
        }

        private fun replaceNumberSpelling(input: String): String {
            return input
                .replace("one", "o1ne")
                .replace("two", "t2wo")
                .replace("three", "t3hree")
                .replace("four", "f4our")
                .replace("five", "f5ive")
                .replace("six", "s6ix")
                .replace("seven", "s7even")
                .replace("eight", "e8ight")
                .replace("nine", "n9ine")
        }
    }
}
