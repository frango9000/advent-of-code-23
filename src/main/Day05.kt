fun main() {
    val input = readInput("main/Day05")
    printTime { println(Day05.part1(input)) }
    printTime { println(Day05.part2(input)) }
}

class Day05 {
    companion object {
        fun part1(input: List<String>): Long {
            val seeds = input[0].subSequence(7, input[0].length).split(" ").map { it.toLong()..it.toLong() }
            val almanac: MutableList<MutableList<AlmanacMapping>> = parseAlmanac(input)
            val locations = mapSeedsToLocations(seeds, almanac)
            return locations.minOf { it.first }
        }

        fun part2(input: List<String>): Int {
            return input.size
        }

        private fun mapSeedsToLocations(
            seeds: List<LongRange>, almanac: MutableList<MutableList<AlmanacMapping>>
        ): List<LongRange> {
            var ids = seeds
            for (mappings in almanac) {
                ids = ids.map {
                    val output = mutableListOf<LongRange>()
                    var queue = mutableListOf<LongRange>(it.first..it.last)

                    while (queue.isNotEmpty()) {
                        val ranges = queue
                        queue = mutableListOf()
                        var splat = 0
                        for (range in ranges) {
                            for (mapping in mappings) {
                                val intersection = range.intersectRange(mapping.range)
                                if (!intersection.isEmpty()) {
                                    output.add(intersection.offset(mapping.offset))
                                    queue.addAll(range.subtract(intersection))
                                    splat++
                                    break
                                }
                            }
                        }
                        if (splat == 0) {
                            output.addAll(ranges)
                            queue = mutableListOf()
                        }
                    }
                    output
                }.flatten()
            }
            return ids
        }

        private fun parseAlmanac(input: List<String>): MutableList<MutableList<AlmanacMapping>> {
            val almanac: MutableList<MutableList<AlmanacMapping>> = mutableListOf()
            for (index in 1..input.lastIndex) {
                if (input[index].endsWith(" map:")) {
                    almanac.add(mutableListOf())
                } else if (input[index].isNotEmpty()) {
                    almanac[almanac.lastIndex].add(AlmanacMapping(input[index]))
                }
            }
            return almanac
        }
    }

    class AlmanacMapping(val input: String) {
        var offset: Long
        val range: LongRange

        init {
            val (destinationStart, sourceStart, length) = input.split(" ").filter { it.isNotEmpty() }
                .map { it.toLong() }
            range = sourceStart..sourceStart + length
            offset = destinationStart - sourceStart
        }

        override fun toString(): String {
            return "AlmanacMapping(range=$range, offset=$offset)"
        }
    }
}
