package com.munteanu.demo.actors

/**
 * Created by romunteanu on 7/6/2015.
 */
object DemoActors {
  def main(args: Array[String]): Unit = {

//    val actor1 = new HiActor
//    actor1.start()
//    Thread.sleep(3000)
//    actor1 ! "Hi"

//    val fraudControl = new FraudControl
//    fraudControl.start()
//    Thread.sleep(1000)
//    fraudControl ! Charge(4111111L, "Bait and Tackle", 19.95)

    val accountActor = new AccountActor
    accountActor.start()

    Thread.sleep(1000)
    accountActor ! Deposit(1.25)

    Thread.sleep(2000)
    accountActor ! Withdraw(0.26)

  }
}
