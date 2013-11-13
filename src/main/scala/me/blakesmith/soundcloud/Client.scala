package me.blakesmith.soundcloud

import com.soundcloud.api.{ApiWrapper, Endpoints, Token};

import java.net.URI


class Client(token: String, secret: String) {
  val wrapper = new ApiWrapper(token, secret, URI.create("http://localhost:8081/connect"), null)

  def authorizationUrl: URI =
    wrapper.authorizationCodeUrl(Endpoints.CONNECT, Token.SCOPE_NON_EXPIRING)
}
