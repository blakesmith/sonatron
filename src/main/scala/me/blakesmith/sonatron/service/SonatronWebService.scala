package me.blakesmith.sonatron.services

import org.scalatra._

import scala.concurrent.{Future, ExecutionContext, future}
import scala.concurrent.ExecutionContext.Implicits.global

import me.blakesmith.soundcloud.{Client => SoundCloud}

class SonatronWebService(soundCloud: SoundCloud) extends ScalatraServlet with FutureSupport {
  protected implicit def executor: ExecutionContext = global

  get("/connect") {
    val f = params.get("code") match {
      case Some(code) =>
        soundCloud.authorizationToken(code) map { token =>
          // Store
          "It worked! Open your Sonos controller to continue installation"
        }
      case None => future("No code provided, please try logging in again")
    }
    val recover = f recoverWith {
      case _ => future("Something went wrong, please try again")
    }
    new AsyncResult { val is = recover }
  }
}
