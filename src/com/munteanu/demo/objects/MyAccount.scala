package com.munteanu.demo.objects

/**
 * Created by romunteanu on 7/3/2015.
 */
class MyAccount {
  val id: Int = MyAccount.newUniqueNumber
  private var balance = 0.0
  def deposit(amount: Double) { balance += amount }
  def currentBalance = balance

  override def toString = s"MyAccount(id=$id, balance=$currentBalance)"
}

object MyAccount {
  private var lastNumber: Int = 0
  private def newUniqueNumber = {
    lastNumber += 1; lastNumber
  }
}
