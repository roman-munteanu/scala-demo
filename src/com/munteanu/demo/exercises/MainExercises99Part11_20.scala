package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 8/19/2015.
 */
object MainExercises99Part11_20 {
  def main(args: Array[String]): Unit = {

    // 14
    println("14: Duplicate the elements of a list.")

    // a list of symbols
    val sampleList = List('a, 'b, 'c, 'c, 'd)
    def duplicateElements[A](ls: List[A]): List[A] = ls match {
      case Nil => Nil
      case h :: tail => h :: h :: duplicateElements(tail)
    }
    println(duplicateElements(sampleList))

    def duplicate[A](ls: List[A]): List[A] = ls flatMap { e => List(e, e) }
    println(duplicate(sampleList))

    // 15
    println("15: Duplicate the elements of a list a given number of times.")

//    implicit ord[Int]: Int => Ordered[Int].des
//    def duplicateN[A](n: Int, ls: List[A]): List[A] = ls match {
//      case list if n == 1 => list.sortWith(_.toString < _.toString)
//      case _ => ls ++ duplicateN(n - 1, ls)
//    }

    def duplicateN[A](n: Int, ls: List[A]): List[A] = {
      def inner(list: List[A], n: Int): List[A] = n match {
        case 1 => list
        case _ => list.head :: inner(list, n - 1)
      }
      ls flatMap { e => inner(List(e), n) }
    }
    println("duplicateN: " + duplicateN(5, sampleList))

    println(List.fill(3)('a))

//    println(List(7,2,42,1,5).sortWith(_ < _))
//    println(List('d', 'c', 'e', 'a').sortWith(_ < _))
//    println(List('d, 'c, 'e, 'a).sortWith(_.toString < _.toString))

    // 16

  }
}
