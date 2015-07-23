package com.munteanu.demo.matching

/**
 * Created by romunteanu on 7/6/2015.
 */
object DemoMatching {
  def main(args: Array[String]): Unit = {

    val ch: Char = '+'

    val sign = ch match {
      case '+' => 1
      case '-' => -1
      case _ if Character.isDigit(ch) => Character.digit(ch, 10)
      case _ => 0
    }
    println(sign)

//    val obj = Array(1,2,3,4)
//    val obj = "test"
//    obj match {
//      case x: Int => 0
//      case y: String =>
//    }

//    val amt = new MyCurrency(125.0, "USD")
//    amt match {
//      case MyCurrency(_, u) => "currency: " + u
//      case Nothing => ""
//    }

    val f: PartialFunction[String, Int] = { case "+" => 1; case "-" => -1 }
    println(f("+"))
  }
}
