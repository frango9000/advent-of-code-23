import org.junit.jupiter.api.Test

class Day01Test {
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
