package com.github.tkawachi.play.safersession

import play.api.mvc.Cookies

case class SaferCookies(cookies: Cookies) {
  def get[A](name: CookieName[A])(implicit encoder: StringEncoder[A]): Option[SaferCookie[A]] =
    cookies.get(name.string).flatMap {cookie =>
      encoder.decode(cookie.value).map { value =>
        new SaferCookie(name, value, cookie.maxAge, cookie.path, cookie.domain, cookie.secure, cookie.httpOnly)
      }
    }
}
