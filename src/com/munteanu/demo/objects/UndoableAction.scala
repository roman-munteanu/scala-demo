package com.munteanu.demo.objects

/**
 * Created by romunteanu on 7/3/2015.
 */
abstract class UndoableAction(val description: String) {
  def undo: Unit
  def redo: Unit
}
