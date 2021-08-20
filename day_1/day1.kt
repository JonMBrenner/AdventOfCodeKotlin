import java.io.File

fun getSortedExpenseList(): List<Int> {
  return File("input.txt").useLines { lines ->
    lines.map { it.toInt() }
         .sorted()
         .toList()
  }
}

fun multiplyTargetPair(expenses: List<Int>, targetSum: Int): Int? {
  var left = 0
  var right = expenses.size - 1
  while (left < right) {
    val curSum = expenses[left] + expenses[right]
    when {
      curSum == targetSum -> return expenses[left] * expenses[right]
      curSum < targetSum  -> left++
      else                -> right--
    }
  }
  return null
}

fun main() {
  val expenses = getSortedExpenseList()
  println("Part 1: " + multiplyTargetPair(expenses, 2020))
}

