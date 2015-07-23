package com.munteanu.demo.actors

import scala.actors.Actor

/**
 * Created by romunteanu on 7/6/2015.
 */
class AccountActor extends Actor {
  var balance: Double = 0.0
  def act() {
    while (true) {
      receive {
        case Deposit(amt) => {
          balance += amt
          println("AccountActor - balance (deposit): " + balance)
        }
        case Withdraw(amt) => {
          balance -= amt
          println("AccountActor - balance (withdraw): " + balance)
        }
      }
    }
  }
}
