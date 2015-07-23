package com.munteanu.demo.higherorderfunctions

/**
 * Created by romunteanu on 7/8/2015.
 */
object MainHigherOrderFunctions extends App {

  val incrementer = 1
  def closure = {
    x: Int => x + incrementer
  }
  println(closure(10))


  def makeUpper(xs: List[String]) = xs map {_.toUpperCase}
  val myList = List("ads", "Xyz")
  println(makeUpper(myList).mkString(" "))
}
