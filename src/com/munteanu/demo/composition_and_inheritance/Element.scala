package com.munteanu.demo.composition_and_inheritance

/**
 * Created by romunteanu on 7/28/2015.
 */
abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
}
