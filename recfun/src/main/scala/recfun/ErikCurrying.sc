package recfun

//Write a function that calculates the product of the values of a function for the points on a given interval

object ErikCurrying {

  def addRational(r1: Rational, r2: Rational): Float = (r1.n * r2.d + r2.n * r1.d) / (r1.d * r2.d)
                                                  //> addRational: (r1: recfun.Rational, r2: recfun.Rational)Float

  val a = new Rational(1, 2)                      //> a  : recfun.Rational = 1/2
  val b = new Rational(2, 2)                      //> b  : recfun.Rational = 2/2
  val c = new Rational(3, 2)                      //> c  : recfun.Rational = 3/2
  val d = new Rational(4, 2)                      //> d  : recfun.Rational = 4/2

  println(a + b ^? c ?^ d less a ==> b | c)       //> false
}

// a + b ^? c ?^ d less a ==> b | c
class Rational(x: Int, y: Int) {
  def n = x
  def d = y

  def ?^(r: Rational) = r
  def |(r: Rational) = r
  def ^?(r: Rational) = r

  def +(r: Rational) =
    new Rational(n * r.d + r.n * d, d * r.d)

  def less(r: Rational) = this.n * r.d < r.n * this.d

  def ==>(r: Rational) = r

  def -(r: Rational) = this + (new Rational(-r.n, r.d))

  def unary_-() = new Rational(-n, d)

  override def toString = n + "/" + d

}