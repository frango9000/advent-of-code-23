import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day08Test {
    @Nested
    inner class TestInput {
        private val testInput1 = listOf(
            "RL",
            "",
            "AAA = (BBB, CCC)",
            "BBB = (DDD, EEE)",
            "CCC = (ZZZ, GGG)",
            "DDD = (DDD, DDD)",
            "EEE = (EEE, EEE)",
            "GGG = (GGG, GGG)",
            "ZZZ = (ZZZ, ZZZ)"
        )

        private val testInput2 = listOf(
            "LLR",
            "",
            "AAA = (BBB, BBB)",
            "BBB = (AAA, ZZZ)",
            "ZZZ = (ZZZ, ZZZ)"
        )

        @Test
        fun part1() {
            check(Day08.part1(testInput1) == 2)
            check(Day08.part1(testInput2) == 6)
        }

        @Disabled
        @Test
        fun part2() {
            check(Day08.part2(testInput1) == 10)
        }
    }

    @Nested
    inner class RealInput {
        private var input: List<String> = listOf()

        @BeforeEach
        fun setup() = runBlocking {
            if (input.isEmpty()) input = fetchInputForDay(8)
        }

        @Test
        fun part1() {
            check(Day08.part1(input) == 18157)
        }

        @Disabled
        @Test
        fun part2() {
            check(Day08.part2(input) == 10)
        }
    }
}
