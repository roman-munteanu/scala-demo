package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 11/2/2015.
 */
object MainFunctionsOnLists {
  def main(args: Array[String]): Unit = {

//    def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
//      case List() => throw new NoSuchElementException("")
//      case y :: ys if n > 0 => y :: removeAt(n - 1, ys)
//      case y :: ys if n == 0 => ys
//    }

    def removeAt[T](n: Int, xs: List[T]): List[T] = (xs take n) ::: (xs drop n + 1)

//    println(removeAt(1, List('a', 'b', 'c', 'd')) )

//    def flatten(xs: List[Any]): List[Any] = ???
//
//    println(
//      flatten(List(List(1, 1), 2, List(3, List(5, 8))))
//    )

    // http://[082-22-81-01/].each(char => char++)
//    "082-22-81-01/".toCharArray.foreach(char => print((char + 1).asInstanceOf[Char] ))


    // Pairs and Tuples
    /*
    def msort(xs: List[Int]): List[Int] = {
      val n = xs.length / 2
      if (n == 0) xs
      else {
        val (fst, snd) = xs splitAt n
        merge(msort(fst), msort(snd))
      }
    }

    def merge(xs: List[Int], ys: List[Int]): List[Int] = {
      (xs, ys) match {
        case (Nil, Nil) => Nil
        case (Nil, ys1) => ys1
        case (xs1, Nil) => xs1
        case (x :: xs1, y :: ys1) =>
          if (x < y) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    }

//    println(merge(List(4,9,2,5), List(6,1,3)))
    println(msort(List(4,-9,2,5,6,1,3)))
    */

    /*
    def msort[T](xs: List[T])(cmp: (T, T) => Boolean): List[T] = {
      val n = xs.length / 2
      if (n == 0) xs
      else {
        val (fst, snd) = xs splitAt n
        merge(msort(fst)(cmp), msort(snd)(cmp))(cmp)
      }
    }

    def merge[T](xs: List[T], ys: List[T])(cmp: (T, T) => Boolean): List[T] = {
      (xs, ys) match {
        case (Nil, Nil) => Nil
        case (Nil, ys1) => ys1
        case (xs1, Nil) => xs1
        case (x :: xs1, y :: ys1) =>
          if (cmp(x, y)) x :: merge(xs1, ys)(cmp)
          else y :: merge(xs, ys1)(cmp)
      }
    }

    println(msort(List(4,-9,2,5,6,1,3))((x: Int, y: Int) => x < y))
    println(msort(List("gamma", "alpha", "delta", "beta"))((x: String, y: String) => x.compareTo(y) < 0))
     */

    import math.Ordering

    def msort[T](xs: List[T])(implicit ord: Ordering[T]): List[T] = {
      val n = xs.length / 2
      if (n == 0) xs
      else {
        val (fst, snd) = xs splitAt n
        merge(msort(fst), msort(snd))
      }
    }

    def merge[T](xs: List[T], ys: List[T])(implicit ord: Ordering[T]): List[T] = {
      (xs, ys) match {
        case (Nil, Nil) => Nil
        case (Nil, ys1) => ys1
        case (xs1, Nil) => xs1
        case (x :: xs1, y :: ys1) =>
          if (ord.lt(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    }

//    println(msort(List(4,-9,2,5,6,1,3))(Ordering.Int))
//    println(msort(List("gamma", "alpha", "delta", "beta"))(Ordering.String))
    println(msort(List(4,-9,2,5,6,1,3)))
    println(msort(List("gamma", "alpha", "delta", "beta")))



  }
}
