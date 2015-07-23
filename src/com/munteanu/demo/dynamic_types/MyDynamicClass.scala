package com.munteanu.demo.dynamic_types

import scala.language.dynamics

/**
 * Created by romunteanu on 7/23/2015.
 */
class MyDynamicClass extends Dynamic {
  def applyDynamic(methodName: String)(args: Any*) = s"custom dynamic result with methodName: $methodName"

  def applyDynamicNamed(name: String)(args: (String, Any)*) {
    println(s"""Creating a $name, for:\n "${args.head._1}": "${args.head._2}" """)
  }
}
