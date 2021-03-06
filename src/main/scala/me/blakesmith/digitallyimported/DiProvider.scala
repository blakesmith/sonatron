package me.blakesmith.digitallyimported

import scala.concurrent.{Future, future}
import scala.concurrent.ExecutionContext.Implicits.global

import me.blakesmith.sonatron.provider.{DeviceLinkCode, DeviceAuthToken, Metadata, MediaURI}

import me.blakesmith.sonatron.provider.Provider

class DiProvider extends Provider {
  val client = new DiClient

  def getDeviceLinkCode(householdId: String): Future[DeviceLinkCode] =
    future { DeviceLinkCode("", "", false) }

  def getDeviceAuthToken(householdId: String, linkCode: String): Future[Option[DeviceAuthToken]] = future { Some(DeviceAuthToken("", "")) }

  def getSearchMenu(userId: String, id: String, index: Int, count: Int, recursive: Boolean): Future[Metadata] = future { Metadata.placeHolder }

  def getMetadataResponse(userId: String, index: Int, count: Int, recursive: Boolean): Future[Metadata] =
    client.getChannels map { chans => Metadata.fromChannels(chans) }

  def getMediaMetadata(userId: String, id: String): Future[Metadata] =
    client.getChannel(id) map { chan => Metadata.fromChannels(List(chan)) }

  def getMediaURI(userId: String, id: String): Future[MediaURI] =
    client.getStreamLocation(id) map { url => MediaURI(url, Map()) }

  def search(userId: String, searchId: String, term: String, index: Int, count: Int): Future[Metadata] = future { Metadata.empty }
}
