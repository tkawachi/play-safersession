package com.github.tkawachi.play.safersession

trait StringEncoder[A] {
  def encode(a: A): String
  def decode(s: String): Option[A]
}
