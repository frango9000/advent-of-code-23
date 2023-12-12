import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day00Test {
    @Nested
    inner class TestInput {
        private val testInput = listOf(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
        )

        @Test
        fun part1() {
            check(Day00.part1(testInput) == 10)
        }

        @Test
        fun part2() {
            check(Day00.part2(testInput) == 10)
        }
    }


    @Nested
    @Disabled
    inner class RealInput {
        private var input: List<String> = listOf()

        @BeforeEach
        fun setup() = runBlocking {
            if (input.isEmpty()) input = fetchInputForDay(0)
        }

        @Test
        fun part1() {
            check(Day03.part1(input) == 10)
        }

        @Test
        fun part2() {
            check(Day03.part2(input) == 10)
        }
    }
}
