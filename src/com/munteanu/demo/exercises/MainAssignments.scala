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

  def pascal(c: Int, r: Int): Int = {

    def nextRow(xs: List[Int]): List[Int] = xs match {
      case Nil => Nil
      case head :: Nil => Nil
      case head :: tail => (head + tail.head) :: nextRow(tail)
    }

    def render(row: List[Int], r: Int): List[Int] = {
      val nr = (1 :: nextRow(row)) :+ 1
      if (r > 1)
        render(nr, r - 1)
      else
        nr
    }

    render(List(1), r)(c)
  }

  for (row <- 0 to 10) {
    for (col <- 0 to row)
      print(pascal(col, row) + " ")
    println()
  }

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

//  println(processList("())(()".toList).mkString(" "))
//  println(processList("(()())".toList).mkString(" "))
//  println(processList("(((()".toList).mkString(" "))


//  println(balance("(if (zero? x) max (/ 1 x))".toList))
//  println(balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList))
//  println(balance(":-)".toList))
//  println(balance("())(".toList))


  // assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)


//  def countChange(money: Int, coins: List[Int]): Int = {
//
//  }

//  def countChange(money: Int, coins: List[Int]): Int =
//    if (money == 0) 1
//    else if (coins.isEmpty || money < 0) 0
//    else countChange(money - coins.head, coins) + countChange(money, coins.tail)

  def countChange(money: Int, coins: List[Int]): Int = money match {
    case 0 => 1
    case m if m < 0 || coins.isEmpty => 0
    case _ => countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }


//  println(countChange(300,List(5,10,20,50,100,200,500)))
//  println(countChange(301,List(5,10,20,50,100,200,500)))
//  println(countChange(300,List(500,5,50,100,20,200,10)))


  // 4: [1,2]
//  var count = 0
//  for (i <- 0 to 4/1)
//    for (j <- 0 to 4/2)
//      if (1*i + 2*j - 4 == 0) count += 1
//  println(count) // 3

  // 8: [1,2,6]
  var count = 0
  for (i <- 0 to 8/1)
    for (j <- 0 to 8/2)
      for (k <- 0 to 8/6)
        if (1*i + 2*j + 6*k - 8 == 0) count += 1

//  println(count) // 7

  def func(args: Int*): Unit = {
    for (i <- 0 until args.length)
      println(args(i))
  }
  func(1,2,6)

}
