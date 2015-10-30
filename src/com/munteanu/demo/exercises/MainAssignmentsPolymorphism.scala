package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 10/13/2015.
 */
object MainAssignmentsPolymorphism {
  def main(args: Array[String]) = {

    def nth[T](n: Int, ls: List[T]): T =
      if (ls.isEmpty || n < 0 || n > ls.length - 1) throw new IndexOutOfBoundsException
      else if (n > 0) nth(n - 1, ls.tail)
      else ls.head

    val sample = List(3,4,7)
    println(nth(0, sample))
//    println(nth(1, sample))
    println(nth(-1, sample))
//    println(nth(3, sample))
  }
}
