package com.munteanu.demo.composition_and_inheritance

/**
 * Created by romunteanu on 7/28/2015.
 */
class LineElement(s: String) extends ArrayElement(Array(s)) {
  override def width: Int = s.length
  override def height: Int = 1
}
