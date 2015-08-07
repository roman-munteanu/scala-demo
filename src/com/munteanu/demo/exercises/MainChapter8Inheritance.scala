package com.munteanu.demo.exercises

import scala.collection.mutable.ArrayBuffer

/**
 * Created by romunteanu on 8/7/2015.
 */
object MainChapter8Inheritance {
  def main(args: Array[String]): Unit = {

    // 1
    class BankAccount(initialBalance: Double) {
      private var balance = initialBalance
      def currentBalance = balance
      def deposit(amount: Double) = { balance += amount; balance }
      def withdraw(amount: Double) = { balance -= amount; balance }
    }

    class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
      override def deposit(amount: Double) = {
        super.deposit(amount - 1)
      }
      override def withdraw(amount: Double) = {
        super.withdraw(amount + 1)
      }
    }

    val ca = new CheckingAccount(10)
    ca.deposit(1)
    println("current balance: " + ca.currentBalance)
    ca.withdraw(1)
    println("current balance: " + ca.currentBalance)

    // 4
    abstract class Item {
      def price: Int
      def description: String
      override def toString: String = s"Item[price: $price, description: $description]"
    }

    class SimpleItem(val price: Int, val description: String) extends Item

    class Bundle {
      var items: ArrayBuffer[Item] = new ArrayBuffer[Item]
      def addItem(item: Item) {
        items += item
      }
//      def price: Int = {
//        items.foldLeft(0) { (sum, item) => sum + item.price }
//      }
      def price: Int = items.map(_.price).sum
      def description: String = items.map(item => item.description).mkString(" ")
      override def toString: String = s"Bundle[price: $price, description: $description]"
    }

    val bundle = new Bundle
    bundle.addItem(new SimpleItem(15, "Rhino"))
    bundle.addItem(new SimpleItem(25, "Wyvern"))
    bundle.addItem(new SimpleItem(30, "Golden Dragon"))
//    for (it <- bundle.items) { println(it) }
    println(bundle)

    // 5
    class Point(val x: Int, val y: Int)
    object Point {
      def apply(x: Int, y: Int): Point = new Point(x, y)
    }
    class LabeledPoint(val label: String, x: Int, y: Int) extends Point(x, y)

    // 6
    abstract class Shape {
      def centerPoint
    }
    class Rectangle extends Shape {
      override def centerPoint = ???
    }
    class Circle extends Shape {
      override def centerPoint = ???
    }
    
    // 7
    class Square(cornerPoint: Point, width: Int) extends java.awt.Rectangle(cornerPoint.x, cornerPoint.y, width, width) {
      def this(width: Int) {
        this(Point(0, 0), width)
      }
      def this() {
        this(Point(0, 0), 0)
      }
    }

    // 8

  }
}
