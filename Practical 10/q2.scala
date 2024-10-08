class Rational2(val numerator: Int, val denominator: Int) {
  require(denominator != 0, "Denominator cannot be zero")
  
  private def simplify(n: Int, d: Int): (Int, Int) = {
    val g = BigInt(n).gcd(BigInt(d)).toInt
    (n / g, d / g)
  }
  
  private val (simplifiedNumerator, simplifiedDenominator) = simplify(numerator, denominator)
  
  def neg: Rational2 = new Rational2(-simplifiedNumerator, simplifiedDenominator)
  
  def sub(that: Rational2): Rational2 = {
    val commonDenominator = simplifiedDenominator * that.simplifiedDenominator
    val newNumerator = (simplifiedNumerator * that.simplifiedDenominator) - 
                        (that.simplifiedNumerator * simplifiedDenominator)
    val (simplifiedNum, simplifiedDen) = simplify(newNumerator, commonDenominator)
    new Rational2(simplifiedNum, simplifiedDen)
  }
  
  override def toString: String = s"$simplifiedNumerator/$simplifiedDenominator"
}

@main def testRational(): Unit = {
  val x = new Rational2(3, 4)
  val y = new Rational2(5, 8)
  val z = new Rational2(2, 7)

  val result = x.sub(y).sub(z)
  
  println(s"x: $x")        
  println(s"y: $y")      
  println(s"z: $z")       
  println(s"x - y - z: $result") 
}
