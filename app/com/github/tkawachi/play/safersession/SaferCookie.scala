package com.github.tkawachi.play.safersession

import play.api.mvc.Cookie

case class SaferCookie[A](name: CookieName[A], value: A, maxAge: Option[Int] = None,
                          path: String = "/", domain: Option[String] = None,
                          secure: Boolean = false, httpOnly: Boolean = true) {

  def cookie(implicit encoder: StringEncoder[A]) =
    new Cookie(name.string, encoder.encode(value), maxAge, path, domain, secure, httpOnly)
}
