import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path
import kotlin.io.path.readLines
import kotlin.system.measureNanoTime

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * The cleaner shorthand for printing output.
 */
fun Any?.println() = println(this)


fun printTime(pre: String = "\n[", post: String = "]\n\n", function: () -> Unit) {
    print("$pre${measureNanoTime { function() }.toFloat() / 1000000}ms$post")
}


suspend fun fetchInputForDay(day: Int): List<String> {
    return HttpClient().get("https://adventofcode.com/2023/day/$day/input") {
        header("Cookie", "session=${System.getenv("SESSION_COOKIE")}")
    }.call.response.bodyAsText().split("\n").filter { it.isNotEmpty() }
}

fun LongRange.intersectRange(that: LongRange): LongRange {
    val start = maxOf(this.first, that.first)
    val endInclusive = minOf(this.last, that.last)
    return start..endInclusive
}

fun LongRange.offset(offsetBy: Long): LongRange {
    return (this.first + offsetBy)..(this.last + offsetBy)
}

fun LongRange.subtract(that: LongRange): List<LongRange> {
    val intersection = this.intersectRange(that)
    val ranges = mutableListOf<LongRange>()

    if (this.first < intersection.first) {
        ranges.add(this.first until intersection.first)
    }
    if (intersection.last < this.last) {
        ranges.add((intersection.last + 1)..this.last)
    }

    return ranges
}
