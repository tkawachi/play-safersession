package com.github.tkawachi.play.safersession

trait DefaultStringFormatter {

  implicit def intStringFormatter = new StringFormatter[Int] {
    override def encode(a: Int) = a.toString
    override def decode(s: String) = try Some(s.toInt) catch {
      case e: NumberFormatException => None
    }
  }

  implicit def longStringFormatter = new StringFormatter[Long] {
    override def encode(a: Long) = a.toString
    override def decode(s: String) = try Some(s.toLong) catch {
      case e: NumberFormatException => None
    }
  }

  implicit def stringStringFormatter = new StringFormatter[String] {
    override def encode(a: String) = a
    override def decode(s: String) = Some(s)
  }

}
