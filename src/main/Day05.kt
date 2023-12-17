fun main() {
    val input = readInput("main/Day05")
    printTime { println(Day05.part1(input)) }
    printTime { println(Day05.part2(input)) }
}

class Day05 {
    companion object {
        fun part1(input: List<String>): Long {

            val seeds: Set<Long> = input[0].subSequence(7, input[0].length).split(" ").map { it.toLong() }.toSet()

            val almanac: MutableList<MutableList<AlmanacEntry>> = mutableListOf()
            for (index in 1..input.lastIndex) {
                if (input[index].endsWith(" map:")) {
                    almanac.add(mutableListOf())
                } else if (input[index].isNotEmpty()) {
                    almanac[almanac.lastIndex].add(AlmanacEntry(input[index]))
                }
            }
            return seeds.map {
                var source: Long = it
                for (category in almanac) {
                    for (entry in category) {
                        if (source in entry.sourceStart until entry.sourceStart + entry.range) {
                            val offset = entry.destinationStart - entry.sourceStart
                            source += offset
                            break
                        }
                    }
                }
                source
            }.min()
        }

        fun part2(input: List<String>): Int {
            return input.size
        }
    }

    class AlmanacEntry(val input: String) {
        val sourceStart: Long
        val destinationStart: Long
        val range: Long

        init {
            val nums = input.split(" ").filter { it.isNotEmpty() }.map { it.toLong() }
            destinationStart = nums[0]
            sourceStart = nums[1]
            range = nums[2]
        }
    }
}
