package recfun

object ErikBalance {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def filter(value: Int, list: List[Int]): List[Int] = list.filter((i: Int) => i <= value)
                                                  //> filter: (value: Int, list: List[Int])List[Int]

  def truthtable(n: Int): List[List[Int]] = {
    if (n < 1) {
      List(List[Int]())
    } else {
      val subtable = truthtable(n - 1)
      for (row <- subtable; v <- 0 until 2)
        yield row :+ v
    }
  }                                               //> truthtable: (n: Int)List[List[Int]]

  def sum(coin: Int, truthElement: Int): Int = if (truthElement == 1) coin else 0
                                                  //> sum: (coin: Int, truthElement: Int)Int

  def sumRecord(coins: List[Int], truthrecord: List[Int]): Int = if (coins.tail.isEmpty) sum(coins.head, truthrecord.head) else  sum(coins.head, truthrecord.head) + sumRecord(coins.tail, truthrecord.tail)
                                                  //> sumRecord: (coins: List[Int], truthrecord: List[Int])Int

  def countChange(money: Int, coins: List[Int]): Int = 3
                                                  //> countChange: (money: Int, coins: List[Int])Int

	println(sumRecord(List(2,5),List(1,0)) )  //> 2


}