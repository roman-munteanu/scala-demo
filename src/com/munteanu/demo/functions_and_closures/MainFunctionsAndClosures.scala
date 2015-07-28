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

  val numbers = List(-11, -10, -5, 0, 5, 10)
//  numbers.foreach((x: Int) => println(x))
  numbers.foreach(println _)

//  println(numbers.filter((x: Int) => x > 0))
//  println(numbers.filter(x => x > 0))
  println(numbers.filter(_ > 0))

  val f = (_: Int) + (_: Int)
  println(f(5, 10))

  // closures
  val more = 99
  val addMore = (x: Int) => x + more
  addMore(10)

  var sum = 0
  numbers.foreach(sum += _)
  println(s"sum: $sum")

  def makeIncreaser(someMore: Int) = (x: Int) => x + someMore
  val inc10 = makeIncreaser(10)
  val inc99 = makeIncreaser(99)
  println(inc10(1))
  println(inc99(10))

  // special calls
  def echo(args: String*) = args.foreach(arg => println(arg))
  echo("alpha", "beta", "gamma", "delta")

  val arr = Array("Red", "Green", "Blue")
  echo(arr: _*)

  def speed(distance: Float, time: Float): Float = distance / time
  println(speed(time = 10, distance = 100))
}
