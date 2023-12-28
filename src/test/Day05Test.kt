import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day05Test {
    @Nested
    inner class TestInput {
        private val testInput = listOf(
            "seeds: 79 14 55 13",
            "",
            "seed-to-soil map:",
            "50 98 2",
            "52 50 48",
            "",
            "soil-to-fertilizer map:",
            "0 15 37",
            "37 52 2",
            "39 0 15",
            "",
            "fertilizer-to-water map:",
            "49 53 8",
            "0 11 42",
            "42 0 7",
            "57 7 4",
            "",
            "water-to-light map:",
            "88 18 7",
            "18 25 70",
            "",
            "light-to-temperature map:",
            "45 77 23",
            "81 45 19",
            "68 64 13",
            "",
            "temperature-to-humidity map:",
            "0 69 1",
            "1 0 69",
            "",
            "humidity-to-location map:",
            "60 56 37",
            "56 93 4",
        )

        @Test
        fun part1() {
            check(Day05.part1(testInput) == 35L)
        }

        @Test
        fun part2() {
            check(Day05.part2(testInput) == 46L)
        }
    }

    @Nested
    inner class RealInput {
        private var input: List<String> = listOf()

        @BeforeEach
        fun setup() = runBlocking {
            if (input.isEmpty()) input = fetchInputForDay(5)
        }

        @Test
        fun part1() {
            check(Day05.part1(input) == 84470622L)
        }

        @Test
        fun part2() {
            check(Day05.part2(input) == 10L)
        }
    }
}
