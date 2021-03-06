package me.blakesmith.sonatron.provider

case class DeviceLinkCode(url: String, linkCode: String, showLinkCode: Boolean)
case class DeviceAuthToken(token: String, privateKey: String)
case class MediaURI(url: String, headers: Map[String, String])
