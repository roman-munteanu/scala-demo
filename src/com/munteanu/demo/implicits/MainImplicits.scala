package com.munteanu.demo.implicits

/**
 * Created by romunteanu on 8/18/2015.
 */
object MainImplicits {
  def main(args: Array[String]): Unit = {

    case class Delimiters(left: String, right: String)

    def quote(what: String)(implicit delims: Delimiters) =
      delims.left + what + delims.right

    println(quote("Bonjour le Monde!")(Delimiters("<<", ">>")))

    // implicit conversion with implicit parameters
    def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]) =
      if (order(a) < b) a else b

    println(smaller(40, 2))
  }
}
