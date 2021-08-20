import java.io.File

fun isValidPart1(inputLine: String): Boolean {
  val rule = inputLine.substringBefore(": ")
  val password = inputLine.substringAfter(": ")

  val letter = rule.last()
  val range = rule.substringBefore(" ")
  val min = range.substringBefore("-").toInt()
  val max = range.substringAfter("-").toInt()

  val letterCount = password.filter { it == letter }.count()
  return letterCount in min..max
}

fun isValidPart2(inputLine: String): Boolean {
  val rule = inputLine.substringBefore(": ")
  val password = inputLine.substringAfter(": ")

  val letter = rule.last()
  val indices = rule.substringBefore(" ")
  val idx1 = indices.substringBefore("-").toInt() - 1
  val idx2 = indices.substringAfter("-").toInt() - 1

  return (password[idx1] == letter) xor (password[idx2] == letter)
}

fun main() {
  val lines = File("input.txt").useLines { it.toList() }
  println("Part 1: " + lines.count { isValidPart1(it) })
  println("Part 2: " + lines.count { isValidPart2(it) })
}

