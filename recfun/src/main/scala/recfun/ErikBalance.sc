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

  def balance(chars: List[Char]): Boolean = chars.isEmpty || cutCouple(clean(chars)).length == 2
                                                  //> balance: (chars: List[Char])Boolean

  println(cutCouple("(())".toList).length)        //> 2
  println(cutCouple("()(())".toList).length)      //> 2
  println(cutCouple(")(()(())".toList).length)    //> 4
  println(cutCouple(")(()(fdf())".toList).length) //> 7
  println(cutCouple(clean("fdsfds()fdhsjkfsd".toList)).length)
                                                  //> 2
  println(balance("fdsfds()fdhs(jkf)sd".toList))  //> true
  println(balance("".toList))                     //> true
  println(" \n ".toList.length)                   //> 3
 println(clean("\n".toList).length)               //> 0

}