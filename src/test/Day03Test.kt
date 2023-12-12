import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day03Test {
    @Nested
    inner class TestInput {
        private val testInput = listOf(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598..",
        )

        @Test
        fun part1() {
            check(Day03.part1(testInput) == 4361)
        }

        @Test
        fun part2() {
            check(Day03.part2(testInput) == 467835)
        }
    }

    @Nested
    inner class RealInput {
        private var input: List<String> = listOf()

        @BeforeEach
        fun setup() = runBlocking {
            if (input.isEmpty()) input = fetchInputForDay(3)
        }

        @Test
        fun part1() {
            check(Day03.part1(input) == 559667)
        }

        @Test
        fun part2() {
            check(Day03.part2(input) == 86841457)
        }
    }
}
