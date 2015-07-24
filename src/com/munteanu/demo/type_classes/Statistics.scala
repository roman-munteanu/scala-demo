package com.munteanu.demo.type_classes

import com.munteanu.demo.type_classes.MyMath.NumberLike

/**
 * Created by romunteanu on 7/24/2015.
 */
object Statistics {
  def mean[T](xs: Vector[T])(implicit ev: NumberLike[T]): T =
    ev.divide(xs.reduce(ev.plus(_, _)), xs.size)
  def median[T: NumberLike](xs: Vector[T]): T = xs(xs.size / 2)
}
