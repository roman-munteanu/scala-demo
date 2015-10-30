package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 10/20/2015.
 */
object MainAssignmentsPatternMatching {
  def main(args: Array[String]) = {

    trait Expr

    object Expr {
      def eval(e: Expr): Int = e match {
        case Number(n) => n
        case Sum(e1, e2) => eval(e1) + eval(e2)
      }
      def show(e: Expr): String = e match {
        case Number(n) => n.toString
        case Var(x) => x
        case Sum(e1, e2) => show(e1) + " + " + show(e2)
        case Prod(Sum(a, b), y) => "(" + show(a) + " + " + show(b) + ") * " + show(y)
        case Prod(x, y) => show(x) + " * " + show(y)
      }
    }

    case class Number(num: Int) extends Expr

    case class Sum(e1: Expr, e2: Expr) extends Expr

    case class Prod(x: Expr, y: Expr) extends Expr

    case class Var(name: String) extends Expr

    val num1 = Number(1)
    val num2 = Number(2)
    val sum  = Sum(num1, num2)

    val expr1 = Sum(Prod(Number(2), Var("x")), Var("y"))
    val expr2 = Prod(Sum(Number(2), Var("x")), Var("y"))

//    println(Expr.eval(num1))
//    println(Expr.eval(sum))
//    println(Expr.show(sum))
//
//    println(Expr.show(expr1))
//    println(Expr.show(expr2))

    def isort(xs: List[Int]): List[Int] = xs match {
      case List() => List()
      case y :: ys => insert(y, isort(ys))
    }

    def insert(x: Int, xs: List[Int]): List[Int] = xs match {
      case List() => List(x)
      case y :: ys =>
        if (x >= y) y :: insert(x, ys)
        else x :: xs
    }

    println(isort(List(7, 3, 9, 2)))

//    println(insert(7, List(2, 3, 3, 9, 9)))

  }
}
