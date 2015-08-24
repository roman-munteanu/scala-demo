package com.munteanu.demo.lists

import scala.collection.mutable.ListBuffer

/**
 * Created by romunteanu on 8/24/2015.
 */
object MainListClassInPractice {
  def main(args: Array[String]): Unit = {

    val fibonacci = List(1,1,2,3,5,8,13)

    def incAll(xs: List[Int]): List[Int] = {
      val result = new ListBuffer[Int]
      for (x <- xs) result += x + 1
      result.toList
    }
    println(incAll(fibonacci))


  }
}
