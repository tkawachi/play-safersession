package com.github.tkawachi.play.safersession

import _root_.play.api.mvc.Session

case class SaferSession(session: Session) {
  def get[A](key: SessionKey[A])(implicit formatter: StringFormatter[A]): Option[A] =
    session.get(key.string).flatMap(formatter.decode)

  def +[A](kv: (SessionKey[A], A))(implicit formatter: StringFormatter[A]): SaferSession = {
    copy(session + (kv._1.string -> formatter.encode(kv._2)))
  }
}
