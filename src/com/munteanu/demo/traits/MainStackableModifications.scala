package com.munteanu.demo.traits

import scala.collection.mutable.ArrayBuffer

/**
 * Created by romunteanu on 7/29/2015.
 */
object MainStackableModifications {
  def main(args: Array[String]): Unit = {

    trait IntQueue {
      def get(): Int
      def put(x: Int)
    }

    class BasicIntQueue extends IntQueue {
      private val buff = new ArrayBuffer[Int]
      override def get(): Int = {
        if (buff.nonEmpty)
          buff.remove(0)
        else
          throw new Exception("Buffer is empty!")
      }
      override def put(x: Int) { buff += x }
    }

    trait Doubling extends IntQueue {
      abstract override def put(x: Int) { super.put(2 * x) }
    }

    class MyQueue extends BasicIntQueue with Doubling

    val myQueue = new MyQueue
    myQueue.put(10)
    println(myQueue.get())

    trait Incrementing extends IntQueue {
      abstract override def put(x: Int) { super.put(x + 1) }
    }

    trait Filtering extends IntQueue {
      abstract override def put(x: Int) { if (x >= 0) super.put(x) }
    }

    class AnotherQueue extends BasicIntQueue with Incrementing with Filtering

    val aQueue = new AnotherQueue
    aQueue.put(-1); aQueue.put(0); aQueue.put(1)
    println(aQueue.get())
    println(aQueue.get())
//    println(aQueue.get())

    class IncDouQueue extends BasicIntQueue with Incrementing with Doubling
    class DouIncQueue extends BasicIntQueue with Doubling with Incrementing

    val incDouQueue = new IncDouQueue
    incDouQueue.put(1)
    println(s"IncDouQueue: " + incDouQueue.get()) // 3

    val douIncQueue = new DouIncQueue
    douIncQueue.put(1)
    println(s"DouIncQueue: " + douIncQueue.get()) // 4
  }
}
