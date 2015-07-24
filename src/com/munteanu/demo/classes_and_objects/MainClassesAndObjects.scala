package com.munteanu.demo.classes_and_objects

/**
 * Created by romunteanu on 7/24/2015.
 */
object MainClassesAndObjects {
  def main(args: Array[String]): Unit = {

    class SomeAccumulator {
      var sum = 0
    }
    val acc1 = new SomeAccumulator
    val acc2 = acc1
    acc1.sum = 3
    println(acc2.sum) // output: 3


    class ChecksumAccumulator {
      private var sum = 0
      def add(b: Byte): Unit = sum += b
      def checksum(): Int = ~(sum & 0xFF) + 1
    }

    val csa = new ChecksumAccumulator
    csa.add(2)
    println(csa.checksum())

    object ChecksumAccumulator {
      private var cache = Map[String, Int]()

      def calculate(s: String): Int = {
        if (cache.contains(s))
          cache(s)
        else {
          val acc = new ChecksumAccumulator
          for (c <- s)
            acc.add(c.toByte)
          val cs: Int = acc.checksum()
          cache += (s -> cs)
          cs
        }
      }
    }

    for (season <- List("Summer", "Fall", "Winter", "Spring"))
      println(season + ": " + ChecksumAccumulator.calculate(season))
  }
}
