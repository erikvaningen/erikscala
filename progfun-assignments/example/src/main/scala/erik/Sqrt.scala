package erik

import common._

/**
 * @author Erik
 */
object Sqrt {

  def sqrIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x))
      guess
    else
      sqrIter(improve(guess, x), x) 

  def isGoodEnough(guess: Double, x: Double): Boolean = Math.abs((guess * guess - x)) < (x/100)

  def improve(guess: Double, x: Double): Double = (x / guess + guess) / 2

  def sqrt(x: Double): Double = sqrIter(1, x) 

}