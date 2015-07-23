package com.munteanu.demo.caseclasses

/**
 * Created by romunteanu on 7/10/2015.
 */
object MainCaseClasses extends App {

  case class Dog(name: String, breed: String)

  val myDog = Dog("Spike", "Sheppard")
  println(myDog.toString)
}
