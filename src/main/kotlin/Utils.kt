import java.io.File
import java.math.BigInteger
import java.security.MessageDigest
import kotlin.io.path.Path

/**
 * Reads lines from the given input txt file.
 */
fun readInput(dir: String, name: String) = File(Path("src/main/kotlin",dir).toFile(), name).readLines()