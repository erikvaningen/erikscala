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
    if (c == 0 || r == 0 || r == c) 1
    else
      pascal(c - 1, r - 1) + pascal(c, r - 1)

  }

  /**
   * Exercise 2
   */

  def balance(chars: List[Char]): Boolean = {

    //logic
    def charClean(one: Char): Boolean = one == '(' || one == ')'

    def clean(chars: List[Char]): List[Char] =
      if (chars.isEmpty) chars
      else if (charClean(chars.head)) { chars.head :: clean(chars.tail) }
      else
        clean(chars.tail)

    def isCouple(chars: List[Char]): Boolean = chars.length == 2 && chars.head == '(' && chars.tail.head == ')'

    def getFirst2(chars: List[Char]): List[Char] = List(chars.head, chars.tail.head)

    def cutCouple(chars: List[Char]): List[Char] =
      if (chars.length <= 2) chars
      else if (isCouple(getFirst2(chars)))
        cutCouple(chars.tail.tail)
      else
        chars.head :: cutCouple(chars.tail)

    chars.isEmpty ||
      (chars.length == 1 && !charClean(chars.head)) ||
      clean(chars).isEmpty ||
      (chars.length > 1 && isCouple(cutCouple(cutCouple(clean(chars)))))

  }

  /**
   * Exercise 3
   */

  def countChange(money: Int, coins: List[Int]): Int = {
    println(money + " " + coins)

    if (money == 0) {
      1
    } else if (money > 0 && !coins.isEmpty) {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    } else {
      0
    }
  }

}
