import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day07Test {
    @Nested
    inner class TestInput {
        private val testInput = listOf(
            "32T3K 765",
            "T55J5 684",
            "KK677 28",
            "KTJJT 220",
            "QQQJA 483"
        )

        @Test
        fun part1() {
            check(Day07.part1(testInput) == 6440)
        }

        @Disabled
        @Test
        fun part2() {
            check(Day07.part2(testInput) == 5)
        }
    }

    @Nested
    inner class RealInput {
        private var input: List<String> = listOf()

        @BeforeEach
        fun setup() = runBlocking {
            if (input.isEmpty()) input = fetchInputForDay(7)
        }

        @Test
        fun part1() {
            check(Day07.part1(input) == 250602641)
        }

        @Disabled
        @Test
        fun part2() {
            check(Day07.part2(input) == 10)
        }
    }
}
