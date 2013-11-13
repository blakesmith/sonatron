package me.blakesmith.sonatron

import javax.jws.WebMethod
import javax.jws.WebService
import javax.xml.ws.Endpoint

private trait GreetingService {

  @WebMethod
  def greet(name: String): String
}

@WebService
private class GreetingServiceServer extends GreetingService {
  override def greet(name: String): String = "Hello %s".format(name)
}

object App {
  def main(args: Array[String]): Unit = {
    Endpoint.publish("http://localhost:8080/greeting", new GreetingServiceServer)
  }
}
