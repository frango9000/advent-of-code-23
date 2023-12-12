import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day02Test {
    @Nested
    inner class TestInput {
        private val testInput = listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green",
        )

        @Test
        fun part1() {
            check(Day02.part1(testInput) == 8)
        }

        @Test
        fun part2() {
            check(Day02.part2(testInput) == 2286)
        }
    }

    @Nested
    inner class RealInput {
        private var input: List<String> = listOf()

        @BeforeEach
        fun setup() = runBlocking {
            if (input.isEmpty()) input = fetchInputForDay(2)
        }

        @Test
        fun part1() {
            check(Day02.part1(input) == 2377)
        }

        @Test
        fun part2() {
            check(Day02.part2(input) == 71220)
        }
    }
}
