package me.blakesmith.sonatron.service

import javax.jws.{WebParam, WebMethod, WebResult, WebService}
import javax.xml.ws.{RequestWrapper, ResponseWrapper}
import javax.jws.soap.SOAPBinding
import javax.jws.soap.SOAPBinding.Style

import com.sonos.smapi.soap.{GetDeviceLinkCodeResponse, DeviceLinkCodeResult}
import com.sonos.smapi.soap.{GetDeviceAuthTokenResponse, DeviceAuthTokenResult}
import com.sonos.smapi.soap.{GetExtendedMetadata, GetExtendedMetadataResponse}
import com.sonos.smapi.soap.{GetExtendedMetadataText, GetExtendedMetadataTextResponse}
import com.sonos.smapi.soap.{GetMediaMetadata, GetMediaMetadataResponse}
import com.sonos.smapi.soap.{GetMediaURI, GetMediaURIResponse}
import com.sonos.smapi.soap.{GetMetadata, GetMetadataResponse}
import com.sonos.smapi.soap.{GetSessionId, GetSessionIdResponse}
import com.sonos.smapi.soap.LastUpdate
import com.sonos.smapi.soap.{Search, SearchResponse}

import me.blakesmith.sonatron.exception.Fault
import me.blakesmith.soundcloud.{Client => SoundCloud}

trait SonatronService {
  def getSessionId(sid: GetSessionId): GetSessionIdResponse
  def getMetadata(meta: GetMetadata): GetMetadataResponse
  def search(search: Search): SearchResponse
  def getMediaMetadata(params: GetMediaMetadata): GetMediaMetadataResponse
  def getMediaURI(params: GetMediaURI): GetMediaURIResponse
  def getLastUpdate: LastUpdate
  def getExtendedMetadata(params: GetExtendedMetadata): GetExtendedMetadataResponse
  def getExtendedMetadataText(params: GetExtendedMetadataText): GetExtendedMetadataTextResponse
  def getDeviceLinkCode(householdId: String): GetDeviceLinkCodeResponse
  def getDeviceAuthToken(householdId: String,
    linkCode: String): DeviceAuthTokenResult
}


@WebService(targetNamespace = "http://www.sonos.com/Services/1.1", name = "SonosSoap")
class SonatronServiceServer extends SonatronService {
  override def getSessionId(sid: GetSessionId): GetSessionIdResponse = {
    val resp = new GetSessionIdResponse
    resp.setGetSessionIdResult("1234");
    resp
  }

  override def getMetadata(params: GetMetadata): GetMetadataResponse = {
    val resp = new GetMetadataResponse
    resp
  }

  override def search(search: Search): SearchResponse = {
    val resp = new SearchResponse
    resp
  }

  override def getMediaMetadata(params: GetMediaMetadata): GetMediaMetadataResponse = {
    val resp = new GetMediaMetadataResponse
    resp
  }

  override def getMediaURI(params: GetMediaURI): GetMediaURIResponse = {
    val resp = new GetMediaURIResponse
    resp
  }

  override def getLastUpdate: LastUpdate = {
    val update = new LastUpdate
    update
  }

  override def getExtendedMetadata(params: GetExtendedMetadata): GetExtendedMetadataResponse = {
    val resp = new GetExtendedMetadataResponse
    resp
  }

  override def getExtendedMetadataText(params: GetExtendedMetadataText): GetExtendedMetadataTextResponse = {
    val resp = new GetExtendedMetadataTextResponse
    resp
  }

  @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
  @WebResult(targetNamespace = "http://www.sonos.com/Services/1.1")
  @RequestWrapper(localName = "getDeviceLinkCode", targetNamespace = "http://www.sonos.com/Services/1.1", className = "com.sonos.smapi.soap.GetDeviceLinkCode")
  @WebMethod(action = "http://www.sonos.com/Services/1.1#getDeviceLinkCode")
  @ResponseWrapper(localName = "getDeviceLinkCodeResponse", targetNamespace = "http://www.sonos.com/Services/1.1", className = "com.sonos.smapi.soap.GetDeviceLinkCodeResponse")
  def getDeviceLinkCode(householdId: String): GetDeviceLinkCodeResponse = {
    val resp = new GetDeviceLinkCodeResponse
    val link = new DeviceLinkCodeResult
    val soundCloud = new SoundCloud("e10f65a53ebbf3a7156182d2987a8ec2", "3768ee10efdaf0170ab1f03217cf6210")

    link.setRegUrl(soundCloud.authorizationUrl.toString)
    link.setLinkCode("NA")
    link.setShowLinkCode(false)

    resp.setGetDeviceLinkCodeResult(link)
    resp
  }

  @WebResult(name = "getDeviceAuthTokenResult", targetNamespace = "http://www.sonos.com/Services/1.1")
  @RequestWrapper(localName = "getDeviceAuthToken", targetNamespace = "http://www.sonos.com/Services/1.1", className = "com.sonos.smapi.soap.GetDeviceAuthToken")
  @WebMethod(action = "http://www.sonos.com/Services/1.1#getDeviceAuthToken")
  @ResponseWrapper(localName = "getDeviceAuthTokenResponse", targetNamespace = "http://www.sonos.com/Services/1.1", className = "com.sonos.smapi.soap.GetDeviceAuthTokenResponse")
  def getDeviceAuthToken(@WebParam(name = "householdId", targetNamespace = "http://www.sonos.com/Services/1.1") householdId: String,
    @WebParam(name = "linkCode", targetNamespace = "http://www.sonos.com/Services/1.1") linkCode: String): DeviceAuthTokenResult = {
    val authToken = new DeviceAuthTokenResult
    authToken.setAuthToken("token123")
    authToken.setPrivateKey("privateKey")
    Fault.sonosFault("Not authenticated yet", "NOT_LINKED_RETRY", 5)
    authToken
  }
}

