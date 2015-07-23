package com.munteanu.demo

import math._

/**
 * Created by romunteanu on 7/2/2015.
 */
object DemoLoopsAndProcedures {
  def main(args: Array[String]): Unit = {

    val result = 8*5 +
      2
//    println("Result: " + result)

    val x0 = 5
    val x = 12
    val y0 = 3
    val y = 7
    val distance = {val dx = x - x0; val dy = y - y0; sqrt(dx*dx + dy*dy)}
    println("Distance: " + distance)

    var factorial: Int = 1
    var n = 5
    while (n > 0) {
      factorial *= n
      n -= 1
    }
    println("Factorial: " + factorial)

    for (i <- 1 to 7) {
      print(i)
    }

    val s = "Gemheap"
    var r = 0
    for (i <- 0 until s.length) {
      r += i
    }
    println(r)

    val arr: Array[Int] = Array(1,3,5,7)
    for (j <- 0 until arr.length) {
      print(arr(j))
    }

    var sum = 0
    for (ch <- "Hello") sum += ch
    println("sum: " + sum)

    println("simple for loop:")
    for (i <- 1 to 10) print(i + " ")
    println()

    for (i <- 1 to 3; j <- 1 to 3 if i != j) print((10*i + j) + " ")
    println()

    def fac (n: Int) = {
      var r = 1
      for (i <- 1 to n) r = r * i
      r
    }
    val fRes = fac(5)
    println("def fac: " + fRes)


    def decorate(str: String, left: String = "[", right: String = "]") = left + str + right
//    def decorate(str: String, left: String = "[", right: String = "]"): String = { left + str + right }
    println("decorate: " + decorate("test"))

    // variable number of arguments
    def sumArgs(args: Int*) = {
      var result = 0
      for (arg <- args) result += arg
      result
    }

    val sumRes = sumArgs(1,2,3,4)
    println("sumArgs: " + sumRes)


    // exercises
    def signum(x: Int) = if (x > 0) 1 else if (x == 0) 0 else -1
    println("signum: " + signum(-7))

    // from 10 to 1
//    for (i <- 0 to 9; from = 10 - i) print(from + " ")
//    println()

    println("countdown procedure:")
    def countdown(n: Int): Unit = {
//      var tmp = n
//      while (tmp > 0) {
//        println(tmp)
//        tmp -= 1
//      }
      for (i <- n.to(1, -1)) print(i + " ")
    }
    countdown(7)


    var prod = 1
    for (ch <- "Hello") prod *= ch.toInt
    println("product of the unicode codes: " + prod)

    // TODO
//    println("product without a loop: " + "Hello".product.toInt)

  }
}
