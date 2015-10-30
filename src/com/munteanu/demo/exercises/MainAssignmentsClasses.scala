package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 10/12/2015.
 */
object MainAssignmentsClasses {
  def main(args: Array[String]) = {

    abstract class IntSet {
      def incl(x: Int): IntSet
      def contains(x: Int): Boolean
      def union(other: IntSet): IntSet
    }

    class Empty extends IntSet {
      override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
      override def contains(x: Int): Boolean = false
      override def union(other: IntSet): IntSet = other
      override def toString = "."
    }

    class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
      override def contains(x: Int): Boolean = {
        if (x < elem) left contains x
        else if (x > elem) right contains x
        else false
      }
      override def incl(x: Int): IntSet = {
        if (x < elem) new NonEmpty(elem, left incl x, right)
        else if (x > elem) new NonEmpty(elem, left, right incl x)
        else this
      }
      override def toString = "{" + left + elem + right + "}"

      override def union(other: IntSet): IntSet =
        ((left union right) union other) incl elem
    }

//    val t1 = new NonEmpty(3, new Empty, new Empty)
//    println(t1)
//    val t2 = t1 incl 4
//    println(t2)

    // in Scala arrays are not covariant
//    val a: Array[NonEmpty] = Array(new NonEmpty(1, new Empty, new Empty))
//    val b: Array[IntSet] = a
//    b(0) = new Empty
//    val s: NonEmpty = a(0)

  } // main
}
