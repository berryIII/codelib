package com.tanpp.scommon.config

/**
 * Author: tanpp
 * Date: 2021/9/15 17:50
 * Package: me.tanpp.scommon.config
 * Description:
 *
 */
trait AA {
  val aa = 1

  def log(): Unit
}

class Person {
  var age: Int = 0
}

class Student extends Person with AA {
  override def log(): Unit = {
    println("...")
  }
}
