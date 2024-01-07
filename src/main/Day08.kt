fun main() {
    val input = readInput("main/Day08")
    printTime { println(Day08.part1(input)) }
    printTime { println(Day08.part2(input)) }
}

class Day08 {
    companion object {
        fun part1(input: List<String>): Int {
            val instructions = input[0]

            val nodeInput = input.subList(2, input.size)

            val network =
                nodeInput.map { it.replace(Regex("[=(),]"), "").split(Regex("\\s+")) }
                    .map { (id, leftId, rightId) -> Node(id, leftId, rightId) }.associateBy { it.id }
            for (node in network.values) {
                node.left = network[node.leftId]
                node.right = network[node.rightId]
            }

            var steps = 0
            val start = network["AAA"]!!
            var current: Node = start
            var end: Node? = null

            while (end == null) {
                val step: Char = instructions[steps % instructions.length]
                current = when (step) {
                    'L' -> current.left!!
                    else -> current.right!!
                }
                steps++
                if (current.id == "ZZZ") end = current
            }
            return steps
        }

        fun part2(input: List<String>): Int {
            return input.size
        }
    }

    class Node(val id: String, val leftId: String, val rightId: String) {
        var left: Node? = null
        var right: Node? = null

        override fun toString(): String {
            return "Node(id='$id', leftId='$leftId', rightId='$rightId')"
        }
    }
}
