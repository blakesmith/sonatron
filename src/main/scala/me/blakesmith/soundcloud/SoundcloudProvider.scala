package me.blakesmith.soundcloud

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import me.blakesmith.sonatron.provider.{DeviceLinkCode, Provider}

class SoundCloudProvider(token: String, secret: String) extends Provider {
  val client = new Client(token, secret)

  def getDeviceLinkCode(householdId: String): Future[DeviceLinkCode] =
    client.authorizationUrl map { url =>
      DeviceLinkCode(url.toString, "NA", false)
    }
}
