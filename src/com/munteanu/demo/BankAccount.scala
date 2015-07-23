package com.munteanu.demo

/**
 * Created by romunteanu on 7/3/2015.
 */
class BankAccount(private var balance: Float) {
//  private var balance: Float = 0
  def currentBalance = { balance }
  def deposit(amount: Float) {
    balance += amount
  }
  def withdraw(amount: Float) {
    balance -= amount
  }
}
