package com.munteanu.demo.exercises

import scala.collection.mutable.ListBuffer

/**
 * Created by romunteanu on 8/20/2015.
 */
object MainExercises99Part21_30 {
  def main(args: Array[String]): Unit = {

    /*
//    val pattern = "\"\\s*([^ ]+)\\s*==\\s*([^ ]+)\\s*\"".r
    val pattern = """\"\s*([^\s]+)\s*==\s*([^\"]+)\s*\"""".r
//    val pattern = "([a-zA-Z]+)==([a-zA-Z0-9\\s]+)".r

    val filter = "\" name  == Topup Consumer    \""
    println(filter)
    filter match {
      case pattern(key, value) => println(s"key: '$key' value: '$value'")
      case _ => println("doesn't match")
    }


    val sample = " \" name == Packaging Service Platform \" "

    val pattern = """^\"([^\"]+)\"$""".r
    sample.trim match {
      case pattern(inside) => println(inside)
      case _ => println("doesn't match")
    }

    val validFilterKeys = List("name")
    case class Filter(key: String, value: String)

    def validate(maybeFilter: Option[String]) =  maybeFilter match {
      case None => None
      case Some(filter: String) if filter.trim.startsWith("\"") && filter.trim.endsWith("\"") => filter.replace("\"", "").trim.split("==") match {
        case Array(key, value)  =>
          if (validFilterKeys.contains(key.trim)) Right(Some(Filter(key.trim, value.trim))) else Left("UnsupportedFilterKeyErrorMessage")
        case _ => Left("InvalidFilterErrorMessage")
      }
      case _ => Left("InvalidFilterErrorMessage")
    }

    println(validate(Some(sample)))
    */

  }
}
