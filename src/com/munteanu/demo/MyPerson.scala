package com.munteanu.demo

/**
 * Created by romunteanu on 7/2/2015.
 */
class MyPerson {

  var name: String = ""
  var age: Int = 0

  def this(name: String) {
    this()
    this.name = name
  }

  def this(name: String, age: Int) {
    this(name)
    this.age = age
  }
}
