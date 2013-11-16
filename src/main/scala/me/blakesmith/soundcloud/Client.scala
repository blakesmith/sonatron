package me.blakesmith.soundcloud

import com.soundcloud.api.{ApiWrapper, Endpoints, Request, Token};

import me.blakesmith.util.Json

import scala.concurrent.{Future, future}
import scala.concurrent.ExecutionContext.Implicits.global

import org.apache.commons.io.IOUtils

import java.io.StringWriter
import java.net.URI


class Client(val token: String, val secret: String, accessToken: Token=null) {
  val wrapper = new ApiWrapper(token, secret, URI.create("http://localhost:8081/connect"), accessToken)

  def authorizationUrl(id: String): Future[URI] =
    future {
      wrapper.authorizationCodeUrl(Endpoints.CONNECT, Token.SCOPE_NON_EXPIRING, "display", id)
    }

  def authorizationToken(code: String): Future[Token] =
    future { wrapper.authorizationCode(code) }

  def recentActivities(): Future[TrackActivityResponse] =
    future {
      val req = Request.to("/me/activities/tracks/affiliated")
      val resp = wrapper.put(req)
      val is = resp.getEntity.getContent
      val writer = new StringWriter
      IOUtils.copy(is, writer, "UTF-8")
      Json.deserialize[TrackActivityResponse](writer.toString)
    }
}
