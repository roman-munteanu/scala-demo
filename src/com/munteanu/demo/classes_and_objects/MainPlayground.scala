package com.munteanu.demo.classes_and_objects

/**
 * Created by romunteanu on 7/24/2015.
 */
object MainPlayground extends App {

  val toyota = new Car("Toyota", "Yaris Verso")
  println(toyota)

  toyota.licensePlate = "AAB 177"
  println(toyota)

  val nissan = new FastCar("Nissan", "Qashqai")
  println(nissan)

  nissan.licensePlate = "AAO 951"
  println(nissan)

  val alice = new MyPerson("Alice Parker")
  println(alice)

  val johanna = new PrimaryPerson("Johanna Green")
//  johanna.fullName = "Fred Smith"
  println(johanna)
}
