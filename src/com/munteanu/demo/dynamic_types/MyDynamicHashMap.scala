package com.munteanu.demo.dynamic_types

import scala.collection.mutable.HashMap
import scala.language.dynamics

/**
 * Created by romunteanu on 7/23/2015.
 */
class MyDynamicHashMap extends HashMap[String, Any] with Dynamic {

  def updateDynamic(key: String)(value: String): Unit = update(key, value)

  def selectDynamic(key: String): Option[Any] = get(key)
}
