package com.munteanu.demo.actors

import scala.actors.Actor

/**
 * Created by romunteanu on 7/6/2015.
 */
class FraudControl extends Actor {
  def act() {
    while (true) {
      receive {
//        case Charge(ccnum, merchant, amt) => println("ccnum: %d, merchant: %s, amount: %d", ccnum, merchant, amt)
        case Charge(ccnum, merchant, amt) => println("ccnum: " + ccnum + ", merchant: " + merchant + ", amount: " + amt)
      }
    }
  }
}
