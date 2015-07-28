package com.munteanu.demo.composition_and_inheritance

/**
 * Created by romunteanu on 7/28/2015.
 */
object MainCompositionAndInheritance {
  def main(args: Array[String]): Unit = {

    val ae = new ArrayElement(Array("Red", "Brown", "Fox"))
    println(s"width: ${ae.width} height: ${ae.height}")

    abstract class Elem {
      def demo() {
        println("Elem's implementation")
      }
    }

    class ArrayElem extends Elem {
      override def demo() {
        println("ArrayElem's implementation")
      }
    }

//    class ArrayElem extends Elem {
//      final override def demo() {
//        println("ArrayElem's implementation")
//      }
//    }

//    final class ArrayElem extends Elem {
//      override def demo() {
//        println("ArrayElem's implementation")
//      }
//    }

    class LineElem extends ArrayElem {
      override def demo() {
        println("LineElem's implementation")
      }
    }

    class UniformElem extends Elem {
      def invokeDemo(e: Elem) = {
        e.demo()
      }
    }

    println(new UniformElem().invokeDemo(new ArrayElem))
    println(new UniformElem().invokeDemo(new LineElem))

  }
}
