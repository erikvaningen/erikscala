package recfun

object ErikBalance {
  println("Welcome to the Scala worksheet")

  def collectionVolume(money: Int, coin: Int): Int = Math.abs(money / coin)

  def calculate(money: Int, volume: Int, coin: Int): Int = if (volume == 0) { volume * coin } else volume * coin + calculate(money, volume - 1, coin)

  def countChange(money: Int, coins: List[Int]): Int =
    if (coins.isEmpty || money == 0) {
      0
    } else {
      if (coins.tail.isEmpty) { // calculateHead }
      else {
        0

      }
    }
  collectionVolume(5, 3)
  countChange(2, List(1, 0))

}