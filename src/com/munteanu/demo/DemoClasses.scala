package com.munteanu.demo

import java.util.{Calendar, Date}

/**
 * Created by romunteanu on 7/2/2015.
 */
object DemoClasses {
  def main(args: Array[String]): Unit = {

    val counter = new Counter
    counter.increment()
    counter.increment()
    // inaccessible field
//     counter.value = 50;
//    println(counter.current())
    println(counter.current)

    val person = new Person
    person.age = 31
    person.age = 25
    println(person.age)

    val message = new Message
    println(message.timeStamp)

    val acc = new Account("alice", "alice.parker@test.com")
    // println("username: %s, email: %s", acc.username, acc.email)
    println(acc)
    // cannot reset val email
    // acc.email = "custom@test.com"
    val calendar: Calendar = Calendar.getInstance
    calendar.set(Calendar.YEAR, 1984)
    calendar.set(Calendar.MONTH, Calendar.MAY)
    calendar.set(Calendar.DAY_OF_MONTH, 21)
    acc.dateOfBirth = calendar.getTime
    println("dateOfBirth: " + acc.dateOfBirth)

  }
}
