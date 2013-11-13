package me.blakesmith.sonatron.services

import org.scalatra._

import scala.concurrent.{Future, ExecutionContext, future}
import scala.concurrent.ExecutionContext.Implicits.global

import me.blakesmith.soundcloud.{Client => SoundCloud}

class SonatronWebService extends ScalatraServlet with FutureSupport {
  val soundCloud = new SoundCloud("e10f65a53ebbf3a7156182d2987a8ec2", "3768ee10efdaf0170ab1f03217cf6210")

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
    f recoverWith {
      case _ => future("Something went wrong, please try again")
    }
    new AsyncResult { val is = f }
  }
}
