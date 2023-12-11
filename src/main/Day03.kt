fun main() {
    val input = readInput("main/Day03")
    printTime { println(Day03.part1(input)) }
    printTime { println(Day03.part2(input)) }
}

class Day03 {
    companion object {
        fun part1(input: List<String>): Int {
            val suffixed = input.map { """$it.""" }

            val parts = mutableListOf<Int>()
            for ((i, line) in suffixed.withIndex()) {
                var seq = ""
                for ((j, char) in line.withIndex()) {
                    val isNum = char in '0' until '9' + 1
                    if (isNum) {
                        seq += char
                    }
                    if ((!isNum) && seq.isNotEmpty()) {
                        val capIndex = j - seq.length - 1
                        val caps =
                            (if (capIndex < 0) "" else suffixed[i][capIndex] + "") + suffixed[i][j]
                        val above = if (i == 0) "" else suffixed[i - 1].substring(maxOf(0, capIndex), j + 1)
                        val below =
                            if (i == suffixed.lastIndex) "" else suffixed[i + 1].substring(maxOf(0, capIndex), j + 1)
                        val adjacentSymbols = (caps + above + below).replace(".", "").replace(Regex("[1234567890]"), "")
                        if (adjacentSymbols.isNotEmpty()) {
                            val num = seq.toInt()
                            parts.add(num)
                        }
                        seq = ""
                    }
                }
            }
            return parts.sum()
        }

        fun part2(input: List<String>): Int {
            return input.size
        }
    }
}

//  %/-\*\$@&#\+=
