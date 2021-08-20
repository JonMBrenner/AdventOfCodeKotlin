import java.io.File

fun isValidPassword(inputLine: String): Boolean {
  val rule = inputLine.substringBefore(": ")
  val password = inputLine.substringAfter(": ")

  val letter = rule.last()
  val range = rule.substringBefore(" ")
  val min = range.substringBefore("-").toInt()
  val max = range.substringAfter("-").toInt()

  val letterCount = password.filter { it == letter }.count()
  return letterCount >= min && letterCount <= max
}

fun main() {
  val lines = File("input.txt").useLines { it.toList() }
  println("Part 1: " + lines.count { isValidPassword(it) })
}

