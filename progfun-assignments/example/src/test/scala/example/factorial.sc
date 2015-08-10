package example

// p is for pyramid recursive, a term which I made up. t is tail recursive, an official term.

object factorial {

  def pfactorial(x: Int): Int = if (x == 0) 1 else x * pfactorial(x - 1)
                                                  //> pfactorial: (x: Int)Int

  def tfactorial(x: Int): Int = {

    def loop(x: Int, acc: Int): Int =
      if (x == 0) acc else loop(x - 1, acc * x)

    loop(x, 1)

  }                                               //> tfactorial: (x: Int)Int

  pfactorial(5)                                   //> res0: Int = 120
  tfactorial(5)                                   //> res1: Int = 120

}