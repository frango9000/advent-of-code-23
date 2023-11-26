import org.junit.jupiter.api.Test

class Day00Test {
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
