package me.blakesmith.sonatron

import javax.xml.ws.Endpoint

import me.blakesmith.sonatron.service.SonatronServiceServer

object App {
  def main(args: Array[String]): Unit = {
    val jetty = new JettyLauncher
    jetty.runInBackground

    Endpoint.publish("http://0.0.0.0:8080/", new SonatronServiceServer)
  }
}
