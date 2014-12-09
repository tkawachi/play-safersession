package controllers

import controllers.SessionKeys._
import play.api._
import play.api.mvc._
import com.github.tkawachi.play.safersession.Imports._

import scala.util.Random

object Application extends Controller {

  val rng = new Random

  def index = Action { implicit request =>
    // get() returns Option[Long] because UserId is SessionKey[Long]
    val prevId = request.saferSession.get(UserId)
    val nextId = rng.nextLong()
    Ok(s"Prev userId: $prevId, next: $nextId")
      // You can set only Long to UserId.
      .withSession(request.saferSession + (UserId -> nextId))
  }

}
