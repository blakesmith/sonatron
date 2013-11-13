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

import scala.concurrent.Await
import scala.concurrent.duration._

import me.blakesmith.sonatron.exception.Fault
import me.blakesmith.sonatron.provider.Provider
import me.blakesmith.soundcloud.SoundCloudProvider


@WebService(targetNamespace = "http://www.sonos.com/Services/1.1", name = "SonosSoap")
class SonatronServiceServer(provider: Provider) {
  def getSessionId(sid: GetSessionId): GetSessionIdResponse = {
    val resp = new GetSessionIdResponse
    resp.setGetSessionIdResult("1234");
    resp
  }

  def getMetadata(params: GetMetadata): GetMetadataResponse = {
    val resp = new GetMetadataResponse
    resp
  }

  def search(search: Search): SearchResponse = {
    val resp = new SearchResponse
    resp
  }

  def getMediaMetadata(params: GetMediaMetadata): GetMediaMetadataResponse = {
    val resp = new GetMediaMetadataResponse
    resp
  }

  def getMediaURI(params: GetMediaURI): GetMediaURIResponse = {
    val resp = new GetMediaURIResponse
    resp
  }

  def getLastUpdate: LastUpdate = {
    val update = new LastUpdate
    update
  }

  def getExtendedMetadata(params: GetExtendedMetadata): GetExtendedMetadataResponse = {
    val resp = new GetExtendedMetadataResponse
    resp
  }

  def getExtendedMetadataText(params: GetExtendedMetadataText): GetExtendedMetadataTextResponse = {
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
    val code = Await.result(provider.getDeviceLinkCode(householdId), 5.seconds)
    link.setRegUrl(code.url)
    link.setLinkCode(code.linkCode)
    link.setShowLinkCode(code.showLinkCode)
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

