package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 8/18/2015.
 */
object MainExercises99 {
  def main(args: Array[String]): Unit = {

    // 1
    println("1: Find the last element of a list.")
    val myList = List(1, 1, 2, 3, 5, 8)
    println(myList.head)
    println(myList.tail)
//    println("drop-take: " + myList.drop(2).take(3))
//    println("slice: " + myList.slice(2, 5))

    def lastElement1[A](list: List[A]): A = list match {
      case h :: Nil => h
      case _ :: otherElements  => lastElement1(otherElements)
      case _ => throw new NoSuchElementException
    }
    println(lastElement1(myList))

    def lastElement2(list: List[Int]): Int = {
      list.reverse.head
    }
    println(lastElement2(myList))

    def lastElement3(list: List[Int]): Int = {
      list(list.length-1)
    }
    println(lastElement3(myList))

    println(myList.last)

    // 2
    println("2: Find the last but one element of a list.")
    def lastButOneElement[A](list: List[A]): A = list match {
      case x :: y :: Nil => x
      case _ :: tail => { println(tail); lastButOneElement(tail) }
      case _ => throw new NoSuchElementException
    }
    println(lastButOneElement(myList))

    // 3
    println("3: Find the Kth element of a list.")
//    def nthElement[A](n: Int, list: List[A]): A = list match {
//      case x :: tail if n == 0 => x
//      case _ :: tail => { println(tail); nthElement(n - 1, tail) }
//      case _ => throw new NoSuchElementException
//    }
    def nthElement[A](n: Int, list: List[A]): A = (n, list) match {
      case (0, h :: _) => h
      case (k, _ :: tail) => { println(tail); nthElement(k - 1, tail) }
      case (_, Nil) => throw new NoSuchElementException
    }
    println(nthElement(2, myList))

    // 4
    println("4: Find the number of elements of a list.")
    def numberOfElements[A](list: List[A]): Int = {
      list.map(_ => 1).sum
    }
    println(numberOfElements(myList))

    def numberOfElements2[A](list: List[A]): Int = {
      list.foldLeft(0) { (z, _) => z + 1 }
    }
    println(numberOfElements2(myList))

    def lengthRecursive[A](ls: List[A]): Int = ls match {
      case Nil => 0
      case _ :: tail => 1 + lengthRecursive(tail)
    }
    println(lengthRecursive(myList))

    // 5
    println("5: Reverse a list")
    def listReverse[A](ls: List[A]): List[A] = ls match {
      case Nil => Nil
      case list => list.last :: listReverse(list.dropRight(1))
    }
    println(listReverse(myList))

    def listReverse2[A](ls: List[A]): List[A] = {
      ls.foldLeft(List[A]()) { (r, h) => h :: r }
    }
    println(listReverse2(myList))

    // 6
    println("6: Find out whether a list is a palindrome.")
    // TODO
//    val sampleList1 = List(1, 2, 3, 2, 1)
//    val sampleList2 = List(1, 2, 3, 4, 2, 1)
//    def isPalindrome[A](ls: List[A]): Boolean = {
//      case Nil => false
//      case x :: Nil => true
//      case h :: tail if h == tail.last => isPalindrome(tail.dropRight(1))
//    }
//    println(isPalindrome(sampleList1))
//    println(isPalindrome(sampleList2))
  }
}
