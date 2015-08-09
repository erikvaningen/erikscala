package erik;

import org.junit.runner.RunWith
import org.scalatest.FunSuite

import org.scalatest.junit.JUnitRunner
import Sqrt._

@RunWith(classOf[JUnitRunner])
class SqrtTest extends FunSuite {

  test("sqrt") {
    assert(sqrt(2) > 1.4)
    
    
    sqrt(0.001)
    sqrt(0.1e-20)
    sqrt(0.1e20)
    sqrt(0.1e50)
  }

}
