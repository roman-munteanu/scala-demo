package com.munteanu.demo.actors

import scala.actors.Actor

/**
 * Created by romunteanu on 7/6/2015.
 */
class HiActor extends Actor {
  def act() {
    while (true) {
      receive {
        case "Hi" => println("Greetings!")
        case "Bye" => exit()
      }
    }
  }
}
