package com.munteanu.demo

import scala.collection.mutable.ArrayBuffer

/**
 * Created by romunteanu on 7/2/2015.
 */
object DemoArrays {
  def main(args: Array[String]): Unit = {

    val mArr: Array[String] = Array("Joe", "Ann", "Mike")
    mArr(0) = "Alice"
    // ArrayIndexOutOfBoundsException
    // mArr(mArr.length) = "Bob"
    println(mArr.mkString(" "))

    // ten elements all initialized as null
    val a = new Array[String](10)

    val s = Array("Gem", "heap")
    s(0) = "memory"
    for (elem <- s) println(elem)

    val b = ArrayBuffer[Int]()
    b += 1
    b += (1,2,5,6,8)
    b ++= Array(11,12,17)
    b.trimEnd(2)
    b.insert(2, 7,7,7)
    for (elem <- b) print(elem + " ")

    for (i <- 0 until b.size) println(i + ": " + b(i))

    for (j <- 0.until(a.size).reverse) print(j + " ")
    println()

    val arr = Array(1,2,3,4)
    val result = for (elem <- arr if (elem % 2 == 0)) yield 2*elem
    for (elem <- result) print(elem + " ")

    // alternatively
    // arr.filter(_ % 2 == 0).map(2 * _)

    println()
    val ab = ArrayBuffer(1,9,2,7)
    val abSorted = ab.sortWith(_ < _)
    println(abSorted.mkString(" - "))

    val aa = Array(2,5,1,3,4)
    util.Sorting.quickSort(aa)
    println(aa.mkString(" - "))

    val sumVal = Array(1,7,2,9).sum
    val maxVal = Array(1,7,2,9).max
    printf("sum: %d max: %d", sumVal, maxVal)

  }
}
