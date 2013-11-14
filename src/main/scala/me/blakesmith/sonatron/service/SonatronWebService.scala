package me.blakesmith.sonatron.services

import org.scalatra._

import scala.concurrent.{Future, ExecutionContext, future}
import scala.concurrent.ExecutionContext.Implicits.global

import me.blakesmith.sonatron.Config

class SonatronWebService extends ScalatraServlet with FutureSupport {
  val soundCloud = Config.soundCloud
  val linkDao = Config.linkDao

  protected implicit def executor: ExecutionContext = global

  get("/connect") {
    val f = (for {
      linkCode <- params.get("state")
      code <- params.get("code")
    } yield (linkCode, code)) match {
      case Some((linkCode, code)) =>
        soundCloud.authorizationToken(code) flatMap { token =>
          linkDao.saveAuthToken(linkCode, token) map { _ =>
            "It worked! Open your Sonos controller to continue installation"
          }
        }
      case None => future("No code provided, please try logging in again")
    }
    val recover = f recoverWith {
      case _ => future("Something went wrong, please try again")
    }
    new AsyncResult { val is = recover }
  }
}
