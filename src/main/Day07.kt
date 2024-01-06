fun main() {
    val input = readInput("main/Day07")
    printTime { println(Day07.part1(input)) }
    printTime { println(Day07.part2(input)) }
}

class Day07 {
    companion object {
        fun part1(input: List<String>): Int {
            val hands =
                input.map { it.split(" ") }.map { CamelCardHand(it[0], it[1].toInt(), "23456789TJQKA", false) }.sorted()
            return hands.withIndex().sumOf { (index, hand) -> (index + 1) * hand.bid }
        }

        fun part2(input: List<String>): Int {
            val hands =
                input.map { it.split(" ") }.map { CamelCardHand(it[0], it[1].toInt(), "J23456789TQKA", true) }.sorted()
            return hands.withIndex().sumOf { (index, hand) -> (index + 1) * hand.bid }
        }
    }


    class CamelCardHand(private val hand: String, val bid: Int, private val ranks: String, wildJs: Boolean) :
        Comparable<CamelCardHand> {
        private var type: CamelCardHandType = CamelCardHandType.HIGH_CARD

        init {
            val cardCount = mutableMapOf<Char, Int>()
            for (card in hand) {
                cardCount[card] = cardCount.getOrDefault(card, 0) + 1
            }
            if (wildJs) {
                val jacks = cardCount.getOrDefault('J', 0)
                if (jacks > 0) {
                    cardCount.remove('J')
                    val maxEntry = cardCount.maxByOrNull { it.value }?.key
                    if (maxEntry != null) {
                        cardCount[maxEntry] = cardCount[maxEntry]!! + jacks
                    } else cardCount['A'] = 5
                }
            }
            type = when {
                cardCount.size == 1 -> CamelCardHandType.FIVE_OF_A_KIND
                cardCount.size == 2 && cardCount.containsValue(4) -> CamelCardHandType.FOUR_OF_A_KIND
                cardCount.size == 2 -> CamelCardHandType.FULL_HOUSE
                cardCount.size == 3 && cardCount.containsValue(3) -> CamelCardHandType.THREE_OF_A_KIND
                cardCount.size == 3 -> CamelCardHandType.TWO_PAIR
                cardCount.size == 4 -> CamelCardHandType.ONE_PAIR
                else -> CamelCardHandType.HIGH_CARD
            }
        }

        override fun compareTo(other: CamelCardHand): Int {
            return when {
                this.type != other.type -> this.type.compareTo(other.type)
                else -> {
                    val thisHand = this.hand.map { ranks.indexOf(it) }
                    val otherHand = other.hand.map { ranks.indexOf(it) }

                    for (i in thisHand.indices) {
                        if (thisHand[i] != otherHand[i]) {
                            return thisHand[i].compareTo(otherHand[i])
                        }
                    }
                    return 0
                }
            }
        }
    }

    enum class CamelCardHandType {
        HIGH_CARD, ONE_PAIR, TWO_PAIR, THREE_OF_A_KIND, FULL_HOUSE, FOUR_OF_A_KIND, FIVE_OF_A_KIND
    }
}
