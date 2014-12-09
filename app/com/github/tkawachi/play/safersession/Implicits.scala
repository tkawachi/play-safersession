package com.github.tkawachi.play.safersession

import play.api.mvc.{Cookie, Cookies, RequestHeader, Session}

trait Implicits {
  implicit class SaferSessionImplicit(session: Session) {
    def safer: SaferSession = new SaferSession(session)
  }

  implicit class SaferCookiesImplicit(cookies: Cookies) {
    def safer: SaferCookies = new SaferCookies(cookies)
  }

  implicit class SaferRequestHeaderImplicit(rh: RequestHeader) {
    def saferSession: SaferSession = rh.session.safer
    def saferCookies: SaferCookies = rh.cookies.safer
  }

  implicit def saferSessionToSession(safer: SaferSession): Session = safer.session

  implicit def saferCookieToCookie[A](safer: SaferCookie[A])(implicit encoder: StringEncoder[A]): Cookie = safer.cookie
}
