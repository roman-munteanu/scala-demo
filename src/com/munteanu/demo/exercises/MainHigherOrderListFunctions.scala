package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 11/4/2015.
 */
object MainHigherOrderListFunctions {
  def main(args: Array[String]): Unit = {

    def squareList1(xs: List[Int]): List[Int] = xs match {
      case Nil     => xs
      case y :: ys => (y * y) :: squareList1(ys)
    }

    def squareList2(xs: List[Int]): List[Int] =
      xs map (x => x * x)

    val sampleList = List(1,2,3,4)

    println(squareList1(sampleList))
    println(squareList2(sampleList))


    def pack[T](xs: List[T]): List[List[T]] = xs match {
      case Nil      => Nil
//      case x :: xs1 =>
//        val pair: (List[T], List[T]) = xs1 span (a => a equals x)
//        List(x :: pair._1) ::: pack(pair._2)
      case x :: xs1 =>
        val (left, right) = xs span (a => a equals x)
        left :: pack(right)
    }

//    def encode[T](xs: List[T]): List[Tuple2[T, Int]] = xs match {
//        case Nil => Nil
//        case x :: xs1 =>
//          val (left, right) = xs span (a => a equals x)
//          (left.head, left.length) :: pack(right)
//      }

    def encode[T](xs: List[T]): List[(T, Int)] =
      pack(xs) map (ys => (ys.head, ys.length))

    val letters = List("a", "a", "a", "b", "c", "c", "a")

    println(pack(letters))
    println(encode(letters))
  }
}
