package com.munteanu.demo.functions_and_closures

/**
 * Created by romunteanu on 7/27/2015.
 */
object MainFunctionsAndClosures extends App {

  var increase = (x: Int) => x + 1
  println(increase(10))

  var increaseWithMoreLines = (x: Int) => {
    println("alpha")
    println("beta")
    x + 1
  }
  println(increaseWithMoreLines(5))

  val numbers = List(-11, -10, -5, 0, 5, 10, 11)
//  numbers.foreach((x: Int) => println(x))
  numbers.foreach(println _)

//  println(numbers.filter((x: Int) => x > 0))
//  println(numbers.filter(x => x > 0))
  println(numbers.filter(_ > 0))

  val f = (_: Int) + (_: Int)
  println(f(5, 10))

}
