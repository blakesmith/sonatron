package me.blakesmith.youtube

import scala.concurrent.{Future, future}
import scala.concurrent.ExecutionContext.Implicits.global

import me.blakesmith.sonatron.provider.{DeviceLinkCode, DeviceAuthToken, Metadata, MediaURI}

import me.blakesmith.sonatron.provider.Provider


class YoutubeProvider(key: String) extends Provider {
  val client = new YoutubeClient(key)

  def getDeviceLinkCode(householdId: String): Future[DeviceLinkCode] =
    future { DeviceLinkCode("", "", false) }

  def getDeviceAuthToken(householdId: String, linkCode: String): Future[Option[DeviceAuthToken]] = future { Some(DeviceAuthToken("", "")) }

  def getMetadataResponse(userId: String, index: Int, count: Int, recursive: Boolean): Future[Metadata] =
    future { Metadata.placeHolder }

  def getMediaMetadata(userId: String, id: String): Future[Metadata] =
    client.getVideo(id).map(Metadata.fromVideo(_))

  def getMediaURI(userId: String, id: String): Future[MediaURI] =
    client.getAudioStream(id) map { url => MediaURI(url, Map()) }

  def search(userId: String, searchId: String, term: String, index: Int, count: Int): Future[Metadata] =
    client.search(userId, searchId, term, index, Array(50, count).min) map { result =>
      Metadata.fromSearchResult(result)
    }
}
