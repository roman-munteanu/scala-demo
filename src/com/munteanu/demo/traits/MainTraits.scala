package com.munteanu.demo.traits

/**
 * Created by romunteanu on 7/29/2015.
 */
object MainTraits {
  def main(args: Array[String]): Unit = {

    trait Philosophical {
      def philosophize(): Unit = {
        println("I consume memory, therefore I exist!")
      }
    }

    class Frog extends Philosophical {
      override def toString = "Green"
    }

    val frog: Philosophical = new Frog
    frog.philosophize()

    class Animal

    class Phrog extends Animal with Philosophical {
      override def toString = "Green"
      override def philosophize(): Unit = {
        println("It ain't easy being " + toString + "!")
      }
    }

    val phrog: Philosophical = new Phrog
    phrog.philosophize()


    // Shapes
    class Point(val x: Int, val y: Int)

    abstract class Shape {
      def calculateArea: Double
    }

    trait Rectangular {
      def topLeft: Point
      def bottomRight: Point

      def left = topLeft.x
      def right = bottomRight.x
      def top = topLeft.y
      def bottom = bottomRight.y

      def width = right - left
      def height = top - bottom
    }

    trait Circular {
      def center: Point
      def radius: Int
    }

    class Rectangle(val topLeft: Point, val bottomRight: Point) extends Shape with Rectangular {
      override def calculateArea: Double = width * height
    }

    class Circle(val center: Point, val radius: Int) extends Shape with Circular {
      override def calculateArea: Double = scala.math.Pi * scala.math.pow(radius, 2)
    }

    val rect1: Shape = new Rectangle(new Point(1, 1), new Point(10, 10))
    println(s"rectangle's area: ${rect1.calculateArea}")

    val circle1: Shape = new Circle(new Point(0, 0), 2)
    println(s"circle's area: ${circle1.calculateArea}")

//    class Rational(n: Int, d: Int) extends Ordered[Rational] {
//      def compare(that: Rational) = (this.numer * that.denom) - (that.numer * this.denom)
//    }

    val s1: String = "Alice"
    val s2: String = "Bob"
    println(s1.compareTo(s2))
  }
}
