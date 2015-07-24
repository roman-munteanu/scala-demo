package com.munteanu.demo.higher_order_functions

/**
 * Created by romunteanu on 7/8/2015.
 */
object MainHigherOrderFunctions extends App {

  val incrementer = 1
  def closure = {
    x: Int => x + incrementer
  }
//  println(closure(10))


  def makeUpper(xs: List[String]) = xs map {_.toUpperCase}
  val myList = List("ads", "Xyz")
//  println(makeUpper(myList).mkString(" "))


  case class Email(
    subject: String,
    text: String,
    sender: String,
    recipient: String)

  type EmailFilter = Email => Boolean

  def newMailsForUser(mails: Seq[Email], f: EmailFilter) = mails.filter(f)

  val sentByOneOf: Seq[String] => EmailFilter = senders => email => senders.contains(email)
  val notSentByAnyOf: Seq[String] => EmailFilter = senders => email => !senders.contains(email)
  val minimumSize: Int => EmailFilter = n => email => email.text.size >= n
  val maximumSize: Int => EmailFilter = n => email => email.text.size <= n


  val pmSender = "performance.management@example.com"
  val mails = Email(
    subject = "Objectives submitted by Roman Munteanu",
    text = "The following personal objectives were submitted: Scala, AKKA",
    sender = pmSender,
    recipient = "roman.munteanu@example.com"
    ) :: Nil

  println(newMailsForUser(mails, sentByOneOf(Seq(pmSender))))
}
