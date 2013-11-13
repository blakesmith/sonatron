package me.blakesmith.soundcloud

import com.soundcloud.api.{ApiWrapper, Endpoints, Token};

import scala.concurrent.{Future, future}
import scala.concurrent.ExecutionContext.Implicits.global

import java.net.URI


class Client(token: String, secret: String) {
  val wrapper = new ApiWrapper(token, secret, URI.create("http://localhost:8081/connect"), null)

  def authorizationUrl: Future[URI] =
    future { wrapper.authorizationCodeUrl(Endpoints.CONNECT, Token.SCOPE_NON_EXPIRING) }
}
