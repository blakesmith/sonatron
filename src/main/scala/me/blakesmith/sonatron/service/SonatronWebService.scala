package me.blakesmith.sonatron.services

import org.scalatra._

class SonatronWebService extends ScalatraServlet {

  get("/connect") {
    params.get("error") match {
      case Some(_) =>
        val desc = params.get("error_description").getOrElse("Something went wrong")
        "You denied the request. Please authorize Sonatron to use your Soundcloud account: %s".format(desc)
      case None =>
        params.get("code") match {
          case Some(code) =>
            // TODO: Store
            "It worked! Please open your Sonos controller window"
          case None =>
            "Error, didn't receive a code from soundcloud"
        }
    }
  }
}
