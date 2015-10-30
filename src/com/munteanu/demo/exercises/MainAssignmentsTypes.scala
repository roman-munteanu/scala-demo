package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 10/19/2015.
 */
object MainAssignmentsTypes {
  def main(args: Array[String]) = {

    // example
    def f = new Function1[Int, Int] {
      def apply(x: Int) = x * x
    }

    trait List[+T] {
      def isEmpty: Boolean
      def head: T
      def tail: List[T]
//      def prepend(elem: T): List[T] = new Cons(elem, this)
      def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
    }

//    class Nil[T] extends List[T] {
//      override def isEmpty: Boolean = true
//      override def tail: Nothing = throw new NoSuchElementException("Nil.tail")
//      override def head: Nothing = throw new NoSuchElementException("Nil.head")
//    }

    object Nil extends List[Nothing] {
      override def isEmpty: Boolean = true
      override def tail: Nothing = throw new NoSuchElementException("Nil.tail")
      override def head: Nothing = throw new NoSuchElementException("Nil.head")
    }

    class Cons[T](val head: T, val tail: List[T]) extends List[T] {
      override def isEmpty: Boolean = false
    }

//    val f0 = new Function0[List[Int]] {
//      def apply() = new Nil[Int]
//    }
//    val f2 = new Function2[Int, Int, List[Int]] {
//      override def apply(v1: Int, v2: Int): List[Int] = {
//        new Cons(v1, new Cons(v2, new Nil[Int]))
//      }
//    }

    object List {
      def apply(): List[Int] = Nil // new Nil[Int]
      def apply(a: Int): List[Int] = new Cons(a, Nil) // new Cons(a, new Nil[Int])
      def apply(a: Int, b: Int): List[Int] = new Cons(a, new Cons(b, Nil)) // new Cons(a, new Cons(b, new Nil[Int]))
    }


    abstract class Nat {
      def isZero: Boolean
      def predecessor: Nat
      def successor: Nat
      def + (that: Nat): Nat
      def - (that: Nat): Nat
    }

    object Zero extends Nat {
      override def isZero: Boolean = true
      override def predecessor: Nothing = throw new NoSuchElementException("Zero.predecessor")
      override def successor: Nat = new Succ(this)
      override def +(that: Nat): Nat = that
      override def -(that: Nat): Nat = if (that.isZero) this else throw new NoSuchElementException("Zero.-")
    }

    class Succ(n: Nat) extends Nat {
      override def isZero: Boolean = false
      override def predecessor: Nat = n
      override def successor: Nat = new Succ(this)
      override def +(that: Nat): Nat = new Succ(n + that)
      override def -(that: Nat): Nat =
        if (that isZero) this else n - that.predecessor
    }


  } // main
}
