package com.munteanu.demo.case_classes

/**
 * Created by romunteanu on 7/30/2015.
 */
object MainWithOptionType {
  def main(args: Array[String]): Unit = {

    val capitals = Map("Norway" -> "Oslo", "Sweden" -> "Stockholm")

    def getCapital(country: String): String = capitals get country match {
      case Some(s) => s
      case None => "?"
    }

    println(getCapital("Sweden"))
    println(getCapital("North Pole"))

    val secondElement: List[Int] => Int = {
      case x :: y :: _ => y
    }
    println(secondElement(List(7, 8, 9)))

    val pfSecond: PartialFunction[List[Int], Int] = {
      case x :: y :: _ => y
    }
    println(pfSecond.isDefinedAt(List(5,6,7)))
    println(pfSecond.isDefinedAt(List()))

  }
}
