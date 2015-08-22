package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    // precondition
    if (c < 0 || r < 0) throw new IllegalArgumentException
    //  logic
    if (c == 0 || r == 0 || r == c) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)

  }

  /**
   * Exercise 2
   */

  def balance(chars: List[Char]): Boolean = {
    // precondition
    if (chars == null) throw new IllegalArgumentException

    //logic
    def charClean(one: Char): Boolean = one == '(' || one == ')'

    def clean(chars: List[Char]): List[Char] =
      if (chars.isEmpty) chars
      else if (charClean(chars.head)) { chars.head :: clean(chars.tail) }
      else
        clean(chars.tail)

    def isCouple(chars: List[Char]): Boolean = chars.head == '(' && chars.tail.head == ')'

    def getFirst2(chars: List[Char]): List[Char] = List(chars.head, chars.tail.head)

    def cutCouple(chars: List[Char]): List[Char] = if (chars.length <= 2) chars else if (isCouple(getFirst2(chars))) cutCouple(chars.tail.tail) else chars.head :: cutCouple(chars.tail)

    chars.isEmpty || (
      if (chars.length == 1) !charClean(chars.head) else isCouple(cutCouple(clean(chars))))
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    def filter(value: Int, list: List[Int]): List[Int] = list.filter((i: Int) => i <= value)

    def truthtable(n: Int): List[List[Int]] = {
      if (n < 1) {
        List(List[Int]())
      } else {
        val subtable = truthtable(n - 1)
        for (row <- subtable; v <- 0 until 2)
          yield row :+ v
      }
    }

    def sum(coin: Int, truthElement: Int): Int = if (truthElement == 1) coin else 0

    def sumRecord(coins: List[Int], truthrecord: List[Int]): Int =
      if (coins.tail.isEmpty) {
        sum(coins.head, truthrecord.head)
      } else {
        sum(coins.head, truthrecord.head) + sumRecord(coins.tail, truthrecord.tail)
      }

    def processTruthTable(money: Int, coins: List[Int], truthTable: List[List[Int]]): Int =
      if (truthTable.tail.isEmpty) {
        sumRecord(coins, truthTable.head)
      } else {
        sumRecord(coins, truthTable.head) + processTruthTable(money, coins, truthTable.tail)
      }
    processTruthTable(money, coins, truthtable(coins.length))
  }

}
