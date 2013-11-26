package me.blakesmith.digitallyimported

import me.blakesmith.util.Json
import me.blakesmith.pls.PlsParser

import me.blakesmith.digitallyimported.models._

import scala.concurrent.{Future, future}
import scala.concurrent.ExecutionContext.Implicits.global

import org.apache.http.HttpResponse
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.DefaultHttpClient

import org.apache.commons.io.IOUtils

import java.io.StringWriter


class DiClient {
  val httpClient = new DefaultHttpClient
  val host = "http://listen.di.fm"

  def getChannels: Future[List[Channel]] =
    future {
      val get = new HttpGet("%s/%s".format(host, "public3"))
      val resp = httpClient.execute(get)
      checkError(resp)
      Json.deserialize[List[Channel]](responseBody(resp))
    }

  def getChannel(key: String): Future[Channel] =
    getChannels map { channels =>
      channels.find(_.key == key).getOrElse(throw new ChannelNotFoundException("Channel with key %s not found".format(key)))
    }

  def getStreamLocation(key: String): Future[String] =
    future {
      val get = new HttpGet("%s/%s/%s.pls".format(host, "public3", key))
      val resp = httpClient.execute(get)
      checkError(resp)
      PlsParser(responseBody(resp)) match {
        case Left(error) => throw new IllegalStateException(error)
        case Right(pls) => pls.entries(0).file
      }
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
      case 200 =>
      case code => throw new IllegalArgumentException("Unknown error: %d".format(code))
    }
}

class ChannelNotFoundException(message: String) extends Exception
