package me.blakesmith.sonatron.provider

import scala.concurrent.Future

trait Provider {
  def getDeviceLinkCode(householdId: String): Future[DeviceLinkCode]
}
