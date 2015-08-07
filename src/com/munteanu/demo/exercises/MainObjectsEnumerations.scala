package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 8/7/2015.
 */
object MainObjectsEnumerations {
  def main(args: Array[String]): Unit = {

    object Conversion {
      def conversionRatio: Double = 0
      def inchesToCentimeters(howMany: Int): Double = ???
      def gallonsToLiters(howMany: Int): Double = ???
      def milesToKilometers(howMany: Int): Double = ???
    }

    abstract class UnitConversion {
      def conversionRatio: Double
      def convert(howMany: Int): Double = {
        require(conversionRatio != 0)
        howMany * conversionRatio
      }
    }

    object MilesToKilometers extends UnitConversion {
      override val conversionRatio = 1.8
    }
    println("MilesToKilometers: " + MilesToKilometers.convert(3))

    object InchesToCentimeters extends UnitConversion {
      override def conversionRatio: Double = 2.14
    }

    // companion objects
    class Point(val x: Int, val y: Int) {
      override def toString: String = s"Point[x: $x, y: $y]"
    }
    object Point {
      def apply(x: Int, y: Int) = new Point(x, y)
    }
    println(Point(3, 4))

    object Helper {
      def reverseOrder(str: String): String = {
//        str.split(" ").toList.reverse.foldLeft("") {(z, f) => z + f + " "}
//        str.split(" ").toList.reverse.mkString(" ")
        str.split(" ").toList.reverse.foldLeft(new StringBuilder) { (sb, s) => sb append " " append s }.toString()
      }
    }
    println(Helper.reverseOrder("scalable for stands Scala"))


    object CardSuit extends Enumeration {
      type CardSuit = Value
      val Hearts = Value("&hearts;")
      val Diamonds = Value("&diams;")
      val Clubs = Value("&clubs;")
      val Spades = Value("&spades;")
    }

    import CardSuit._
//    def checkForRedCardSuit(cs: CardSuit): Boolean = cs match {
//      case Hearts => true
//      case Diamonds => true
//      case _ => false
//    }

    def isRed(suit: CardSuit): Boolean = suit == Hearts || suit == Diamonds

    for (cs <- CardSuit.values) {
      println(s"suit: $cs is red: " + isRed(cs))
    }
  }
}
