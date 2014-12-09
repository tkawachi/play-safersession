package com.github.tkawachi.play.safersession

trait DefaultFormatter {

  implicit def longStringFormatter = new StringFormatter[Long] {
    override def encode(a: Long) = a.toString

    override def decode(s: String) = try Some(s.toLong) catch {
      case e: NumberFormatException => None
    }
  }

}
