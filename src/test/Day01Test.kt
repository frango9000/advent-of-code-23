import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day01Test {
    @Nested
    inner class TestInput {
        private val testInput = listOf(
            "1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"
        )

        private val testInput2 = listOf(
            "two1nine",
            "eightwothree",
            "abcone2threexyz",
            "xtwone3four",
            "4nineeightseven2",
            "zoneight234",
            "7pqrstsixteen",
        )

        @Test
        fun part1() {
            check(Day01.part1(testInput) == 142)
        }

        @Test
        fun part2() {
            check(Day01.part2(testInput2) == 281)
        }
    }


    @Nested
    inner class RealInput {
        private var input: List<String> = listOf()

        @BeforeEach
        fun setup() = runBlocking {
            if (input.isEmpty()) input = fetchInputForDay(1)
        }

        @Test
        fun part1() {
            check(Day01.part1(input) == 55971)
        }

        @Test
        fun part2() {
            check(Day01.part2(input) == 54719)
        }
    }
}
