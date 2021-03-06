package me.blakesmith.sonatron.services

import org.scalatra._
import org.scalatra.scalate.ScalateSupport

import scala.concurrent.{Future, ExecutionContext, future}
import scala.concurrent.ExecutionContext.Implicits.global

import me.blakesmith.sonatron.Config

class SonatronWebService extends ScalatraServlet with FutureSupport with ScalateSupport {
  val soundCloud = Config.soundCloud
  val soundCloudLinkDao = Config.soundCloudLinkDao

  protected implicit def executor: ExecutionContext = global

  get("/") {
    contentType="text/html"
    ssp("index", "title" -> "Sonos music services")
  }

  get("/instructions/soundcloud") {
    contentType="text/html"
    ssp("sc-instructions", "title" -> "Soundcloud Instructions")
  }

  get("/instructions/di") {
    contentType="text/html"
    ssp("di-instructions", "title" -> "DI Instructions")
  }

  get("/connect") {
    val f = (for {
      linkCode <- params.get("state")
      code <- params.get("code")
    } yield (linkCode, code)) match {
      case Some((linkCode, code)) =>
        soundCloud.authorizationToken(code) flatMap { token =>
          soundCloudLinkDao.saveAuthToken(linkCode, token) map { _ =>
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
