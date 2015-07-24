package com.munteanu.demo.type_classes

/**
 * Created by romunteanu on 7/24/2015.
 */
object MainTypeClasses extends App {

  val numbers: Vector[Double] = Vector[Double](1, 2.0, 3, 4, 5, 7, 10)

//  println(v.reduce((a, b) => a + b))

  println(Statistics.mean(numbers))
  println(Statistics.median(numbers))
}
