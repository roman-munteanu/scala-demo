package com.munteanu.demo.objects

/**
 * Created by romunteanu on 7/3/2015.
 */
object DoNothingAction extends UndoableAction("Do nothing") {
  override def undo() {
    println(description +  ": undo")
  }
  override def redo() {
    println(description +  ": redo")
  }
}
