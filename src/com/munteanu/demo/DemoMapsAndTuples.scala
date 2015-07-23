package com.munteanu.demo

/**
 * Created by romunteanu on 7/2/2015.
 */
object DemoMapsAndTuples {
  def main(args: Array[String]): Unit = {

    val immutableMap = Map("Alice" -> 10, "Tom" -> 3, "Joe" -> 8)
    println(immutableMap.mkString(" "))

    val mutableMap = collection.mutable.Map("Alice" -> 7, "Johanna" -> 6)

    val scores = new collection.mutable.HashMap[String, Int]
    scores("Freddie") = 15
    scores("Brian") = 11
    scores += ("Roger" -> 12, "John" -> 14)
    scores("Mike") = 8
    scores -= "Mike"
    println(scores.mkString(" "))

    val otherScores = Map(("Bob", 5), ("Ann", 10))
    println(otherScores("Bob"))
    println(otherScores.getOrElse("Steve", 0))

    for ((key, value) <- scores) println(key + " : " + value)

    val kSet = scores.keySet
    println("key set:")
    print(kSet.mkString(" "))

    println()
    println("values:")
    for (v <- scores.values) print(v + " ")

    // tuples
    println()
    val t = (1, 3.14, "Fred")
    println(t._3)

    val (first, second, third) = t;

    val symbols = Array("alpha", "beta", "gamma")
    val counts = Array(1,2,3)
    val pairs = symbols.zip(counts) // pairs.toMap
    println(pairs.mkString(" "))


  }
}
