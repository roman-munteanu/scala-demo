package com.munteanu.demo

/**
 * Created by romunteanu on 7/3/2015.
 */
object DemoClassesExercise {
  def main(args: Array[String]): Unit = {

    // BankAccount
    val bankAccount = new BankAccount(0.15F)
    bankAccount.deposit(1.25F)
    println("balance: " + bankAccount.currentBalance)
    bankAccount.withdraw(0.26F)
    println("balance: " + bankAccount.currentBalance)

    // MyTime
    val timeOne = new MyTime(8, 23)
    val timeTwo = new MyTime(7, 45)
    println("is before: " + timeOne.before(timeTwo))
    println("is before: " + timeTwo.before(timeOne))

    val anotherTimeOne = new AnotherTime(25, 60)
    println(anotherTimeOne)
    val anotherTimeTwo = new AnotherTime(23, -59)
    println(anotherTimeTwo)
  }
}
