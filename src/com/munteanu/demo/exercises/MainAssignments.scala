package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 9/16/2015.
 */
object MainAssignments extends App {

  object Lists {
//    def max(xs: List[Int]): Int = {
//      var tmp = 0
//      for (n <- xs)
//        if (n > tmp)
//          tmp = n
//      tmp
//    }
    def max(xs: List[Int]): Int = xs match {
      case Nil => 0
      case head :: Nil => head
      case first :: second :: rest => max((if (first > second) first else second) :: rest)
    }
    def sum(xs: List[Int]): Int = xs match {
      case Nil => 0
      case head :: tail => head + sum(tail)
    }
  }

  val sampleList = List(1, 7, 5)
//  println(Lists.max(sampleList))

//  println(Lists.sum(sampleList))

  // pascal(0,2)=1, pascal(1,2)=2 and pascal(1,3)=3
  // 1
  // 1 1
  // 1 2 1
  // 1 3 3 1
  // 1 4 6 4 1

//  def pascal(c: Int, r: Int): Int = {
//  }

  def triangle(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case head :: Nil => Nil
    case head :: tail => (head + tail.head) :: triangle(tail)
  }
//  println(triangle(List(1,2,1)).mkString(" "))

  def func(n: Int): List[Int] = {
    var xs = List(1, 1)
    for (i <- 0 until n)
      xs = (1 :: triangle(xs)) :+ 1
    xs
  }
//  println(func(0))


  // Parentheses Balancing
  // ( ( ) ( ) )
  // ( ) ) (

/*

  def balance(chars: List[Char]): Boolean = {

    val parentheses = chars collect {
      case c if c == '(' || c == ')' => c
    }
//    println(parentheses.mkString(" "))

    def stripParentheses(str: String): String = {
      if (str.contains("()")) {
        stripParentheses(str.replace("()", ""))
      } else
        str
    }

    stripParentheses(parentheses.mkString("")).isEmpty
  }
*/

  def balance(chars: List[Char]): Boolean = {

    val parentheses = chars collect {
      case c if c == '(' || c == ')' => c
    }

    true
  }

  def stripParentheses(xs: List[Char]): List[Char] = xs match {
    case left :: right :: rest if left == '(' && right == ')' => stripParentheses(rest)
    case head :: tail => head :: stripParentheses(tail)
    case Nil => Nil
  }

  def processList(ls: List[Char]): List[Char] = {
    val processed = stripParentheses(ls)
    if (processed.length == ls.length)
      processed
    else
      processList(processed)
  }

  println(processList("())(()".toList).mkString(" "))
  println(processList("(()())".toList).mkString(" "))
  println(processList("(((()".toList).mkString(" "))


//  println(balance("(if (zero? x) max (/ 1 x))".toList))
//  println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
//  println(balance(":-)".toList))
//  println(balance("())(".toList))


}
