package com.munteanu.demo

/**
 * Created by romunteanu on 7/3/2015.
 */
object DemoNetwork {
  def main(args: Array[String]) : Unit = {

    val vkontakte = new Network
    val facebook = new Network

    val fred = vkontakte.join("Fred")
    val ann = vkontakte.join("Ann")
    fred.contacts += ann

    val bob = facebook.join("Bob")
     // type mismatch unless Network#Member
     // fred.contacts += bob

  }
}
