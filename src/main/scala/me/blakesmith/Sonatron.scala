package me.blakesmith.sonatron

import javax.xml.ws.Endpoint

import me.blakesmith.sonatron.service.SonatronServiceServer

object App {
  def main(args: Array[String]): Unit = {
    Endpoint.publish("http://localhost:8080/", new SonatronServiceServer)
  }
}
