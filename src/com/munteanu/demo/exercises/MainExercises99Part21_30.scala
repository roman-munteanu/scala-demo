package com.munteanu.demo.exercises

import scala.collection.mutable.ListBuffer

/**
 * Created by romunteanu on 8/20/2015.
 */
object MainExercises99Part21_30 {
  def main(args: Array[String]): Unit = {

    val sample = List('a, 'b, 'c, 'd, 'e, 'f)

    // 21
    println("21: Insert an element at a given position into a list.")
    def insertAtN[A](el: A, n: Int, ls: List[A]): List[A] = {
      ls flatMap {e => if (ls.indexOf(e) == n) List(el ,e) else List(e)}
    }
//    println(insertAtN('new, 1, sample))

    def insertAtNRec[A](el: A, n: Int, ls: List[A]): List[A] = ls match {
      case list if n == 0 => el :: list
      case h :: tail if n > 0 => h :: insertAt(el, n - 1, tail)
      case _ => throw new IndexOutOfBoundsException
    }
//    println(insertAtNRec('new, 2, sample))


    def insertAt[A](el: A, n: Int, ls: List[A]): List[A] = ls.splitAt(n) match {
      case (pre, post) => pre ::: el :: post
    }
//    println(insertAt('new, 3, sample))

    // 22
    println("22: Create a list containing all integers within a given range.")
    def myRange(m: Int, n: Int): List[Int] = {
      if (m <= n)
        m :: myRange(m + 1, n)
      else
        Nil
    }
//    println(myRange(4, 9))

    // 23
    println("23: Extract a given number of randomly selected elements from a list.")
    // randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
    import util.Random
    def randomSelect[A](n: Int, ls: List[A]): List[A] = {
      if (n > 0)
        ls(Random.nextInt(ls.length - 1)) :: randomSelect(n - 1, ls)
      else
        Nil
    }
//    println(randomSelect(3, sample))

    // 24
    println("24: Lotto: Draw N different random numbers from the set 1..M.")
//    val r = Range(1, m)
    def lottoNonOptimal(n: Int, m: Int): List[Int] = {
      val buf = new ListBuffer[Int]
      var nn = n

      while (nn > 0) {
        val num = (new Random).nextInt(m)
        if (!buf.contains(num)) {
          buf += Random.nextInt(m)
          nn -= 1
        }
      }
      buf.toList
    }
//    println(lottoNonOptimal(6, 49))


    def lotto(n: Int, m: Int): List[Int] = {
      if (n > 0)
        Random.nextInt(m) :: lotto(n - 1, m)
      else
        Nil
    }

    // 25
    println("25: Generate a random permutation of the elements of a list.")
    // randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
    // List('b, 'a, 'd, 'c, 'e, 'f)
    def randomPermute[A](ls: List[A]): List[A] = {
      val idx = Random.nextInt(ls.length - 1)
      val (pre, post) = ls.splitAt(idx)
      pre.init ::: post.head :: pre.last :: post.tail
    }
    println(randomPermute(sample))



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
