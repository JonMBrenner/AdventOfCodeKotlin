import java.io.File

fun getExpenseSet(): Set<Int> {
  val expenseSet = mutableSetOf<Int>()
  File("input.txt").forEachLine { expenseSet.add(it.toInt()) }
  return expenseSet
}

fun findSolution(expenses: Set<Int>) {
  for (expense in expenses) {
    val complement = 2020 - expense
    if (expenses.contains(complement)) {
      println(expense * complement)
      return
    }
  }
  println("no solution exists")
}

fun main() {
  val expenses = getExpenseSet()
  findSolution(expenses);
}

