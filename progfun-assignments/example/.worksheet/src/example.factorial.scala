package example

// p is for pyramid recursive, a term which I made up. t is tail recursive, an official term.

object factorial {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(207); 

  def pfactorial(x: Int): Int = if (x == 0) 1 else x * pfactorial(x - 1);System.out.println("""pfactorial: (x: Int)Int""");$skip(147); 

  def tfactorial(x: Int): Int = {

    def loop(x: Int, acc: Int): Int =
      if (x == 0) acc else loop(x - 1, acc * x)

    loop(x, 1)

  };System.out.println("""tfactorial: (x: Int)Int""");$skip(18); val res$0 = 

  pfactorial(5);System.out.println("""res0: Int = """ + $show(res$0));$skip(16); val res$1 = 
  tfactorial(5);System.out.println("""res1: Int = """ + $show(res$1))}

}
