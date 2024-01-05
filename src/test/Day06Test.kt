import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day06Test {
    @Nested
    inner class TestInput {
        private val testInput = listOf(
            "Time:      7  15   30",
            "Distance:  9  40  200"
        )

        @Test
        fun part1() {
            check(Day06.part1(testInput) == 288)
        }

        @Test
        fun part2() {
            check(Day06.part2(testInput) == 71503)
        }
    }

    @Nested
    inner class RealInput {
        private var input: List<String> = listOf()

        @BeforeEach
        fun setup() = runBlocking {
            if (input.isEmpty()) input = fetchInputForDay(6)
        }

        @Test
        fun part1() {
            check(Day06.part1(input) == 227850)
        }

        @Test
        fun part2() {
            check(Day06.part2(input) == 42948149)
        }
    }
}
