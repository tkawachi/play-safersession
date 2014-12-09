package controllers

import com.github.tkawachi.play.safersession.{SaferCookie, CookieName, SessionKey}
import play.api._
import play.api.mvc._
import com.github.tkawachi.play.safersession.Imports._

import scala.util.Random

object SessionKeys {
  object UserId extends SessionKey[Long]("uid")
}

object CookieNames {
  object DoubleCookie extends CookieName[Double]("double")
}

object Application extends Controller {
  import SessionKeys._
  import CookieNames._

  val rng = new Random

  def index = Action { implicit request =>
    // get() returns Option[Long] because UserId is SessionKey[Long]
    val prevId: Option[Long] = request.saferSession.get(UserId)
    val nextId = rng.nextLong()

    val prevDouble: Option[Double] = request.saferCookies.get(DoubleCookie).map(_.value)
    val nextDouble = rng.nextDouble()

    Ok(s"In session: prev userId: $prevId, next: $nextId.\n" +
      s"In cookie: prev double: $prevDouble, next: $nextDouble")
      // You can set only Long to UserId.
      .withSession(request.saferSession + (UserId -> nextId))
      .withCookies(SaferCookie(DoubleCookie, nextDouble))
  }

}
