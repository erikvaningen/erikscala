package recfun

object ErikBalance {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  def charClean(one: Char): Boolean = one == '(' || one == ')'
                                                  //> charClean: (one: Char)Boolean

  def clean(chars: List[Char]): List[Char] = if (chars.isEmpty) chars else if (charClean(chars.head)) { chars.head :: clean(chars.tail) } else clean(chars.tail)
                                                  //> clean: (chars: List[Char])List[Char]

  def isCouple(chars: List[Char]): Boolean = chars.head == '(' && chars.tail.head == ')'
                                                  //> isCouple: (chars: List[Char])Boolean

  def getFirst2(chars: List[Char]): List[Char] = List(chars.head, chars.tail.head)
                                                  //> getFirst2: (chars: List[Char])List[Char]

  def cutCouple(chars: List[Char]): List[Char] = if (chars.length <= 2) chars else if (isCouple(getFirst2(chars))) cutCouple(chars.tail.tail) else chars.head :: cutCouple(chars.tail)
                                                  //> cutCouple: (chars: List[Char])List[Char]

  println(clean("fd\nsfdsfdhsjkfsd".toList).length)
                                                  //> 0
  println("\n".length)                            //> 1

  println(cutCouple(clean("fd\nsfds()fdhsjkfsd".toList)).length)
                                                  //> 2

  println(cutCouple(clean("fdsfds()fdhsjkfsd".toList)).length)
                                                  //> 2
  println(isCouple(cutCouple(clean("fdsfds()fdhsjkfsd".toList))))
                                                  //> true
  println(" \n ".toList.length)                   //> 3
  println("\n".length)                            //> 1
  println(clean("\n".toList).length)              //> 0

}