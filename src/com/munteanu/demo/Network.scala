package com.munteanu.demo

import scala.collection.mutable.ArrayBuffer

/**
 * Created by romunteanu on 7/3/2015.
 */
class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
    // a member of any network
//    val contacts = new ArrayBuffer[Network#Member]
  }

  private val members = new ArrayBuffer[Member]

  def join(name: String) = {
    val m = new Member(name)
    members += m
    m
  }
}
