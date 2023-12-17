fun main() {
    val input = readInput("main/Day04")
    printTime { println(Day04.part1(input)) }
    printTime { println(Day04.part2(input)) }
}

class Day04 {
    companion object {
        fun part1(input: List<String>): Int {
            val cards = input.map { Scratchcard(it) }
            val pointMap = (0..cards.maxOf { it.winners }).associateWith { 1.shl(it - 1) }
            return cards.sumOf { pointMap[it.winners] ?: 0 }
        }

        fun part2(input: List<String>): Int {
            val cards = input.map { Scratchcard(it) }
            for ((index, card) in cards.withIndex()) {
                val copyStart = minOf(index + 1, cards.size)
                val copyEnd = minOf(card.winners + index, cards.lastIndex)
                for (copyCard in copyStart..copyEnd) {
                    cards[copyCard].copies += cards[index].copies
                }
            }
            return cards.sumOf { it.copies }
        }
    }

    class Scratchcard(input: String) {
        var copies: Int = 1
        var winners: Int = 0

        init {
            val numSets = input.split(*delimiters).subList(1, 3)
                .map { nums ->
                    nums.split(whitespaces).filter { num -> num.isNotEmpty() }.map { num -> num.toInt() }
                        .toSet()
                }
            winners = numSets[0].intersect(numSets[1]).size
        }
    }
}


private val delimiters = arrayOf(":", "|")
private val whitespaces = Regex("\\s{1,2}")
