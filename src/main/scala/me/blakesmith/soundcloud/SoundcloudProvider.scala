package me.blakesmith.soundcloud

import java.util.UUID

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import me.blakesmith.sonatron.Config
import me.blakesmith.sonatron.provider.{DeviceLinkCode, DeviceAuthToken, Metadata}
import me.blakesmith.sonatron.provider.Provider

import com.soundcloud.api.Token


class SoundCloudProvider(token: String, secret: String) extends Provider {
  val client = Config.soundCloud
  val linkDao = Config.linkDao

  def getDeviceLinkCode(householdId: String): Future[DeviceLinkCode] = {
    val linkCode = UUID.randomUUID.toString.slice(0, 31)
    client.authorizationUrl(linkCode) map { url =>
      DeviceLinkCode(url.toString, linkCode, false)
    }
  }

  def getDeviceAuthToken(householdId: String, linkCode: String): Future[Option[DeviceAuthToken]] =
    linkDao.getAuthToken(linkCode) map {
      case Some(token) => Some(DeviceAuthToken(linkCode, token.access))
      case None => None
    }

  def getMetadataResponse(id: String, index: Int, count: Int, recursive: Boolean): Future[Metadata] =
    for {
      authed <- authorizedClient(id, client) map(_.getOrElse(throw new RuntimeException("Could not find user access token: %s".format(id))))
      activities <- authed.recentActivities
    } yield new Metadata

  private def authorizedClient(id: String, unauthorizedClient: Client): Future[Option[Client]] =
    linkDao.getAuthToken(id) map {
      case Some(token) => Some(new Client(unauthorizedClient.token, unauthorizedClient.secret, token))
      case None => None
    }
}
