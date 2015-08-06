package com.munteanu.demo.abstract_members

/**
 * Created by romunteanu on 8/6/2015.
 */
object MainAbstractMembers {
  def main(args: Array[String]): Unit = {

    trait AbstractTime {
      var hour: Int
      var minute: Int
    }

    trait AnalogousAbstractTime {
      def hour: Int       // getter
      def hour_=(x: Int)  // setter
      def minute: Int
      def minute_=(y: Int)
    }

    trait RationalTrait {
      val numerArg: Int
      val denomArg: Int
      require(denomArg != 0)
      private val g = gcd(numerArg, denomArg)
      val numer = numerArg / g
      val denom = denomArg / g
      private def gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)
      override def toString = numer +"/"+ denom
    }

    val x = 2
    // the code below will give: java.lang.IllegalArgumentException: requirement failed
//    new RationalTrait {
//      val numerArg = 1 * x
//      val denomArg = 2 * x
//    }

    val rt = new {
      val numerArg = 1 * x
      val denomArg = 2 * x
    } with RationalTrait
    println(rt)
  }
}