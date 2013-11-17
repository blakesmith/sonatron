package me.blakesmith.sonatron.provider

import scala.concurrent.Future

trait Provider {
  def getDeviceLinkCode(householdId: String): Future[DeviceLinkCode]
  def getDeviceAuthToken(householdId: String, linkCode: String): Future[Option[DeviceAuthToken]]
  def getMetadataResponse(userId: String, index: Int, count: Int, recursive: Boolean): Future[Metadata]
  def getMediaMetadata(userId: String, id: String): Future[Metadata]
}
