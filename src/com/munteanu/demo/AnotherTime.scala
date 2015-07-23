package com.munteanu.demo

/**
 * Created by romunteanu on 7/3/2015.
 */
class AnotherTime {

  private var privateHours: Int = 0
  private var privateMinutes: Int = 0

  def this(hours: Int, minutes: Int) {
    this()
    this.hours = hours
    this.minutes = minutes
  }

  def hours = privateHours
  def hours_= (hours: Int) = {
    if (hours >= 0 && hours <= 23) privateHours = hours
  }

  def minutes = privateMinutes
  def minutes_= (minutes: Int) = {
    if (minutes >= 0 && minutes <= 59) privateMinutes = minutes
  }

  private def getTotalMinutes = 60*hours + minutes

  def before(other: AnotherTime) = { getTotalMinutes < other.getTotalMinutes }

  override def toString = s"AnotherTime($privateHours, $privateMinutes)"
}
