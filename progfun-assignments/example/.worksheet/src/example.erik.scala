package example

object erik {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(51); val res$0 = 


 
  sqrt(0.001);System.out.println("""res0: <error> = """ + $show(res$0));$skip(16); val res$1 = 
  sqrt(0.1e-20);System.out.println("""res1: <error> = """ + $show(res$1));$skip(15); val res$2 = 
  sqrt(0.1e20);System.out.println("""res2: <error> = """ + $show(res$2))}
//   sqrt(0.1e50)

}
