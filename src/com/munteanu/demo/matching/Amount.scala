package com.munteanu.demo.matching

/**
 * Created by romunteanu on 7/6/2015.
 */
abstract class Amount {
  case class Dollar(value: Double) extends Amount
  case class Currency(value: Double, unit: String) extends Amount
}
