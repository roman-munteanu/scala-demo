package com.munteanu.demo.case_classes

/**
 * Created by romunteanu on 7/10/2015.
 */
object MainCaseClasses extends App {

  case class Dog(name: String, breed: String)

  val myDog = Dog("Spike", "Sheppard")
  println(myDog.toString)

  def describe(x: Any) = x match {
    case x: Int => "integer: " + x
    case x: Boolean => "boolean: " + x
    case x: String => "string"
    case Nil => "empty list"
    case _ => "something else"
  }
  println(describe(true))
  println(describe(Nil))
  println(describe(List()))

  abstract class Expr
  case class Var(name: String) extends Expr
  case class Number(num: Double) extends Expr
  case class UnOp(operator: String, arg: Expr) extends Expr
  case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

  def evaluate(expr: Expr) = expr match {
    case BinOp(_, e, _) => "deep match: " + e
    case _ =>
  }

  def tupleMatching(expr: Any) = expr match {
    case (a, b, c) => "match " + a + b + c
    case _ =>
  }
  println(tupleMatching(("a ", 3, "-tuple")))

  // test whether an expression has type String
  // expr.isInstanceOf[String]

  // cast an expression to type String
  // expr.asInstanceOf[String]

  def isIntIntMap(m: Any) = m match {
    case m: Map[Int, Int] => true
    case _ => false
  }
  println(isIntIntMap(Map(1 -> 1)))

  def isStringArray(arr: AnyRef) = arr match {
    case arr: Array[String] => true
    case _ => false
  }
  println(isStringArray(Array(true)))
}
