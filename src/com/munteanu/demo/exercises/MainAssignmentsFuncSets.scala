package com.munteanu.demo.exercises

/**
 * Created by romunteanu on 10/8/2015.
 */
object MainAssignmentsFuncSets extends App {

  type Set = Int => Boolean

  def contains(s: Set, elem: Int): Boolean = s(elem)

  println(contains((x: Int) => x < 0, 3))
  println(contains((x: Int) => x < 0, -1))

  // 2.1
  def f: Set = (x: Int) => x < 0

  def singletonSet(elem: Int): Set = elem => contains(f, elem)

  def union(s: Set, t: Set): Set = (x: Int) => s(x) || t(x)

  def intersect(s: Set, t: Set): Set = (x: Int) => s(x) && t(x)

  def diff(s: Set, t: Set): Set = (x: Int) => s(x) && !t(x)

  def filter(s: Set, p: Int => Boolean): Set = (x: Int) => s(x) && p(x)

  // 2.2
  def forall(s: Set, p: Int => Boolean): Boolean = {
    def iter(a: Int): Boolean = {
      if (???) ???
      else if (???) ???
      else iter(???)
    }
    iter(???)

//    x: Int => p(x)
  }

  def exists(s: Set, p: Int => Boolean): Boolean = forall(s, (x: Int) => p(x))

  def map(s: Set, f: Int => Int): Set = (x: Int) => s(f(x))

}
