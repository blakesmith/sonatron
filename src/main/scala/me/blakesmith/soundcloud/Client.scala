package me.blakesmith.soundcloud

import com.soundcloud.api.{ApiWrapper, Endpoints, Request, Token};

import me.blakesmith.util.Json

import scala.concurrent.{Future, future}
import scala.concurrent.ExecutionContext.Implicits.global

import org.apache.commons.io.IOUtils
import org.apache.http.HttpResponse

import java.io.StringWriter
import java.net.URI


class Client(val token: String, val secret: String, val accessToken: Token=null) {
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
      val resp = wrapper.get(req)
      checkError(resp)
      Json.deserialize[TrackActivityResponse](responseBody(resp))
    }

  def resolveStreamLocation(url: String): Future[String] =
    future {
      val req = Request.to(url)
      val resp = wrapper.get(req)
      checkError(resp)
      val headers = resp.getHeaders("Location")
      headers.length match {
        case 1 => headers(0).getValue
        case _ => throw new IllegalArgumentException("Could not find the location header for the stream")
      }
    }

  def getTrack(id: Int): Future[Track] =
    future {
      val req = Request.to("/tracks/%d".format(id))
      val resp = wrapper.get(req)
      checkError(resp)
      Json.deserialize[Track](responseBody(resp))
    }

  def search(term: String): Future[List[Track]] =
    future {
      val req = Request.to("/tracks?q=%s".format(term))
      val resp = wrapper.get(req)
      checkError(resp)
      Json.deserialize[List[Track]](responseBody(resp))
    }

  private def responseBody(resp: HttpResponse): String = {
    val is = resp.getEntity.getContent
    val writer = new StringWriter
    IOUtils.copy(is, writer, "UTF-8")
    val body = writer.toString
    body
  }

  private def checkError(resp: HttpResponse): Unit =
    resp.getStatusLine.getStatusCode match {
      case 200 | 302 =>
      case 400 => throw new BadRequestException("Bad API request")
      case 401 => throw new UnauthorizedException("Bad credentials")
      case 403 => throw new ForbiddenException("You don't have permission to access that resource")
      case 404 => throw new NotFoundException("Not found")
      case 406 => throw new NotAccessibleException("That resource is not accessible at the moment")
      case 422 => throw new UnprocessableEntityException("A paremeter in your request is in the incorrect format")
      case 429 => throw new RatelimitException("You've exceeded your maximum number of requests")
      case 500 => throw new InternalServerErrorException("Internal server error")
      case 503 => throw new ServiceUnavailableException("Service is unavailable")
      case 504 => throw new GatewayTimeoutException("Gateway timeout")
      case code => throw new IllegalArgumentException("Unknown error: %d".format(code))
    }
}

class SoundcloudException extends Exception
class BadRequestException(message: String) extends SoundcloudException
class UnauthorizedException(message: String) extends SoundcloudException
class ForbiddenException(message: String) extends SoundcloudException
class NotFoundException(message: String) extends SoundcloudException
class NotAccessibleException(message: String) extends SoundcloudException
class UnprocessableEntityException(message: String) extends SoundcloudException
class RatelimitException(message: String) extends SoundcloudException
class InternalServerErrorException(message: String) extends SoundcloudException
class ServiceUnavailableException(message: String) extends SoundcloudException
class GatewayTimeoutException(message: String) extends SoundcloudException
