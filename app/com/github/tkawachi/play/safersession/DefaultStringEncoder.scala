package com.github.tkawachi.play.safersession

trait DefaultStringEncoder {

  implicit def byteStringEncoder = new StringEncoder[Byte] {
    override def encode(a: Byte) = a.toString
    override def decode(s: String) = try Some(s.toByte) catch {
      case _: NumberFormatException => None
    }
  }

  implicit def shortStringEncoder = new StringEncoder[Short] {
    override def encode(a: Short) = a.toString
    override def decode(s: String) = try Some(s.toShort) catch {
      case _: NumberFormatException => None
    }
  }

  implicit def intStringEncoder = new StringEncoder[Int] {
    override def encode(a: Int) = a.toString
    override def decode(s: String) = try Some(s.toInt) catch {
      case _: NumberFormatException => None
    }
  }

  implicit def longStringEncoder = new StringEncoder[Long] {
    override def encode(a: Long) = a.toString
    override def decode(s: String) = try Some(s.toLong) catch {
      case _: NumberFormatException => None
    }
  }

  implicit def charStringEncoder = new StringEncoder[Char] {
    override def encode(a: Char) = a.toString
    override def decode(s: String) = {
      val ary = s.toCharArray
      if (ary.size != 1) None else Some(ary(0))
    }
  }
  
  implicit def floatStringEncoder = new StringEncoder[Float] {
    override def encode(a: Float) = a.toString
    override def decode(s: String) = try Some(s.toFloat) catch {
      case _: NumberFormatException => None
    }
  }
  
  implicit def doubleStringEncoder = new StringEncoder[Double] {
    override def encode(a: Double) = a.toString
    override def decode(s: String) = try Some(s.toDouble) catch {
      case _: NumberFormatException => None
    }
  }

  implicit def booleanStringEncoder = new StringEncoder[Boolean] {
    override def encode(a: Boolean) = a.toString
    override def decode(s: String) = try Some(s.toBoolean) catch {
      case _: IllegalArgumentException => None
    }
  }

  implicit def stringStringEncoder = new StringEncoder[String] {
    override def encode(a: String) = a
    override def decode(s: String) = Some(s)
  }
}
