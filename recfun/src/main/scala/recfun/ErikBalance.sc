package recfun

object ErikBalance {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  // A function which generalizes both sum and product:
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, init: Int)(a: Int, b: Int): Int =
    if (a > b) init
    else
      combine(f(a), mapReduce(f, combine, init)(a + 1, b))
                                                  //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, init: Int)(a: Int, b:
                                                  //|  Int)Int

  def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (a, b) => a * b, 1)(a, b)
                                                  //> product: (f: Int => Int)(a: Int, b: Int)Int

  product(x => x * x)(3, 4)                       //> res0: Int = 144

}