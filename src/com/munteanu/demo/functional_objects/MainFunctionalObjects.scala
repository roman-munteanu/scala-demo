package com.munteanu.demo.functional_objects

/**
 * Created by romunteanu on 7/24/2015.
 */
object MainFunctionalObjects {
  def main(args: Array[String]): Unit = {

    class Rational(n: Int, d: Int) {
      require(d != 0)
      val numer: Int = n
      val denom: Int = d
      private val g: Int = gcd(n.abs, d.abs)

      def this(n: Int) = this(n, 1)

      def add(that: Rational): Rational =
        new Rational(numer * that.denom + denom * that.numer, denom * that.denom)

      def * (that: Rational): Rational =
        new Rational(numer * that.numer, denom * that.denom)

      // overloaded
      def * (i: Int): Rational =
        new Rational(numer * i, denom)

      def lessThan(that: Rational): Boolean =
        this.numer * that.denom < that.numer * this.denom

      override def toString: String = s"$numer/$denom"

      // greatestCommonDivisor
      private def gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)
    }

    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)
    println("1/2 + 2/3 = " + (oneHalf add twoThirds))

    val threeFourth = new Rational(3, 4)
    val oneFifth = new Rational(1, 5)
    println("3/4 * 1/5 = " + threeFourth.*(oneFifth))

    // implicit conversion
    implicit def intToRational(i: Int): Rational = new Rational(i)
    println(2 * new Rational(2, 3))

  }
}
