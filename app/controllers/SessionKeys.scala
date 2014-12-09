package controllers

import com.github.tkawachi.play.safersession.SessionKey

object SessionKeys {
  object UserId extends SessionKey[Long]("uid")
  object SomeString extends SessionKey[String]("ss")
}
