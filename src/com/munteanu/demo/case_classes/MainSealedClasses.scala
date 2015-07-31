package com.munteanu.demo.case_classes

/**
 * Created by romunteanu on 7/30/2015.
 */
object MainSealedClasses {
  def main(args: Array[String]): Unit = {

    // A sealed class cannot have any new subclasses added except the ones in the same file.
    sealed abstract class Expr
    case class Var(name: String) extends Expr
    case class Number(num: Double) extends Expr
    case class UnOp(operator: String, arg: Expr) extends Expr
    case class BinOp(operator: String, left: Expr, right: Expr) extends Expr

    def describe(e: Expr): String = e match {
      case Var(_) => "a string"
      case Number(_) => "a number"
      case _ => throw new RuntimeException("should not happen")
    }
    println(describe(Var("x")))

    def describeWithUnchecked(e: Expr): String = (e: @unchecked) match {
      case Var(_) => "a string"
      case Number(_) => "a number"
    }

  }
}
