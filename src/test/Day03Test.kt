import org.junit.jupiter.api.Test

class Day03Test {
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
