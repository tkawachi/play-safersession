package com.github.tkawachi.play.safersession

import play.api.mvc.{RequestHeader, Session}

trait Implicits {
  implicit class SaferSessionImplicit(session: Session) {
    def safer: SaferSession = new SaferSession(session)
  }

  implicit class SaferRequestHeaderImplicit(rh: RequestHeader) {
    def saferSession: SaferSession = rh.session.safer
  }

  implicit def saferSessionToSession(safer: SaferSession): Session = safer.session
}
