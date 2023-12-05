#!/bin/sh

# Check if an input was provided
if [ -z "$1" ]
then
  echo "No input provided. Please provide a day number."
  exit 1
fi

# Get the day number from the input
day_number=$1

# Check if the files already exist
if [ -f "src/test/Day${day_number}Test.kt" ] || [ -f "src/main/Day${day_number}.kt" ]
then
  echo "Files for Day${day_number} already exist."
  exit 1
fi

# Create the necessary directories if they don't exist
mkdir -p src/test
mkdir -p src/main

# Create the test and main files with the specified contents
echo \
"import org.junit.jupiter.api.Test

class Day${day_number}Test {
    private val testInput = listOf(
        \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\", \"10\"
    )

    @Test
    fun part1() {
        check(Day${day_number}.part1(testInput) == 10)
    }

    @Test
    fun part2() {
        check(Day${day_number}.part2(testInput) == 10)
    }
}
" > src/test/Day${day_number}Test.kt

echo \
"fun main() {
    val input = readInput(\"main/Day${day_number}\")
    printTime { println(Day${day_number}.part1(input)) }
    printTime { println(Day${day_number}.part2(input)) }
}

class Day${day_number} {
    companion object {
        fun part1(input: List<String>): Int {
            return input.size
        }

        fun part2(input: List<String>): Int {
            return input.size
        }
    }
}
" > src/main/Day${day_number}.kt

touch src/main/Day${day_number}.txt

git add src/test/Day${day_number}Test.kt src/main/Day${day_number}.kt
