package com.munteanu.demo

/**
 * Created by romunteanu on 7/3/2015.
 */
class MyTime(val hours: Int, val minutes: Int) {

  private def getTotalMinutes = 60*hours + minutes

  def before(other: MyTime) = { getTotalMinutes < other.getTotalMinutes }

}
