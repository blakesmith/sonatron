package me.blakesmith.dropbox

import java.util.UUID

import scala.concurrent.{Future, future}
import scala.concurrent.ExecutionContext.Implicits.global

import me.blakesmith.sonatron.db.LinkCodeDAO
import me.blakesmith.sonatron.provider.{DeviceLinkCode, DeviceAuthToken, Metadata, MediaURI, Provider}

class DropboxProvider(key: String, secret: String, linkDao: LinkCodeDAO[String]) extends Provider {
  private val client = new DropboxClient(key, secret)

  def getDeviceLinkCode(householdId: String): Future[DeviceLinkCode] = {
    val linkCode = UUID.randomUUID.toString.slice(0, 31)
    client.authorizationUrl.map(DeviceLinkCode(_, linkCode, false))
  }

  def getDeviceAuthToken(householdid: String, linkCode: String): Future[Option[DeviceAuthToken]] =
    linkDao.getAuthToken(linkCode) map {
      case Some(token) => Some(DeviceAuthToken(linkCode, token))
      case None => None
    }

  def getSearchMenu(userId: String, id: String, index: Int, count: Int, recursive: Boolean): Future[Metadata] =
    future { Metadata.empty }

  def getMetadataResponse(userId: String, index: Int, count: Int, recursive: Boolean): Future[Metadata] =
    future { Metadata.empty }

  def getMediaMetadata(userId: String, id: String): Future[Metadata] =
    future { Metadata.empty }

  def getMediaURI(userId: String, id: String): Future[MediaURI] =
    future { MediaURI("http://dropbox.com", Map()) }

  def search(userId: String, searchId: String, term: String, index: Int, count: Int): Future[Metadata] =
    future { Metadata.empty }
}
