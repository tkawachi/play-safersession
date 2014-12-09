package com.github.tkawachi.play.safersession

trait StringFormatter[A] {
  def encode(a: A): String
  def decode(s: String): Option[A]
}
