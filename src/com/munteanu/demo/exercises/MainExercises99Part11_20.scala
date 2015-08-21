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

    val aList = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

    // 16
    println("16: Drop every Nth element from a list.")
    //    dropN(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    //    res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    def dropN[A](n: Int, ls: List[A]): List[A] = ls.filter(e => (ls.indexOf(e) + 1) % n != 0)
    //    println(dropN(3, aList))

    // 17
    println("17: Split a list into two parts. The length of the first part is given. Use a Tuple for your result.")
    // splitN(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    // res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    def splitN[A](n: Int, ls: List[A]): (List[A], List[A]) = (ls.take(n), ls.drop(n))
    //    println(splitN(3, aList))

    // 18
    println("18: Extract a slice from a list.")
    // Given two indices, I and K, the slice is the list containing the elements from and including the Ith element up to but not including the Kth element of the original list. Start counting the elements with 0.
    //    slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    //    res0: List[Symbol] = List('d, 'e, 'f, 'g)

    def sliceIK0[A](i: Int, k: Int, ls: List[A]): List[A] = ls.dropRight(ls.length - k).drop(i)
    //    println(sliceIK0(3, 7, aList))

    // TODO
    //    def sliceIK[A](i: Int, k: Int, ls: List[A]): List[A] = ls match {
    //      case h :: tail if i > 0  && k > 0 => println("i > 0: " + tail); sliceIK(i - 1, k, tail)
    //      case list      if i == 0 && k > 0 => println("i == 0: " + list.reverse); sliceIK(i - 1, k, list.reverse)
    //      case h :: tail if i < 0 && k > 0 => println("k > 0: " + tail); sliceIK(-1, k - 1, tail)
    //      case list      if i < 0 && k == 0 => println("0 0: " + list.reverse); list.reverse
    //      case _ => ls
    //    }
    //    println(sliceIK(3, aList.length - 7, aList))

    // 20
    println("20: Remove the Kth element from a list. Return the list and the removed element in a Tuple. Elements are numbered from 0.")
    def removeKth[A](k: Int, ls: List[A]): (List[A], A) = {
      (for (e <- ls; if ls.indexOf(e) != k) yield e, ls(k))
    }
    println(removeKth(1, aList))

  }
}
