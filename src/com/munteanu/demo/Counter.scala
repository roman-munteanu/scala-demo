package com.munteanu.demo

/**
 * Created by romunteanu on 7/2/2015.
 */
class Counter {
  private var value: Int = 0
  def increment() { value += 1 }
  def current() = value

//  def increment(): Unit = { value += 1 }
//  def current(): Int = { value }
}
