package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 8/18/2015.
 */
object MainChapter21Implicits {
  def main(args: Array[String]): Unit = {

    // 2: Define an operator +% that adds a given percentage to a value.
    implicit class ApplyPercentage(val value: Int) {
      def +%(perc: Float): Float = value * (1 + perc / 100)
    }
    println(120 +% 10)

    // 3: Define a ! operator that computes the factorial of an integer.
    implicit class Factorial(var value: Int) {
      def ff: Int = (1 to value).product
    }
//    println((1 to 5).foldLeft(1) {(z, f) => z * f})
      println(5 ff)
  }
}
