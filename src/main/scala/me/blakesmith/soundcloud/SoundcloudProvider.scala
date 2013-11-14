package me.blakesmith.soundcloud

import java.util.UUID

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import me.blakesmith.sonatron.Config
import me.blakesmith.sonatron.provider.{DeviceLinkCode, DeviceAuthToken}
import me.blakesmith.sonatron.provider.Provider


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
}
