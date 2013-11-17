package me.blakesmith.sonatron.service

import java.util.UUID

import javax.annotation.Resource;
import javax.jws.{WebParam, WebMethod, WebResult, WebService}
import javax.xml.ws.{Holder, RequestWrapper, ResponseWrapper, WebServiceContext}
import javax.jws.soap.SOAPBinding
import javax.jws.soap.SOAPBinding.Style
import javax.xml.ws.handler.soap.SOAPMessageContext

import com.sonos.smapi.CredentialsHelper
import com.sonos.smapi.soap.{GetDeviceLinkCodeResponse, DeviceLinkCodeResult}
import com.sonos.smapi.soap.{GetDeviceAuthTokenResponse, DeviceAuthTokenResult}
import com.sonos.smapi.soap.{GetExtendedMetadata, GetExtendedMetadataResponse}
import com.sonos.smapi.soap.{GetExtendedMetadataText, GetExtendedMetadataTextResponse}
import com.sonos.smapi.soap.{GetMediaMetadata, GetMediaMetadataResponse}
import com.sonos.smapi.soap.MediaList
import com.sonos.smapi.soap.{GetMediaURI, GetMediaURIResponse}
import com.sonos.smapi.soap.{HttpHeader, HttpHeaders}
import com.sonos.smapi.soap.{GetMetadata, GetMetadataResponse}
import com.sonos.smapi.soap.{GetSessionId, GetSessionIdResponse}
import com.sonos.smapi.soap.LastUpdate
import com.sonos.smapi.soap.{Search, SearchResponse}

import scala.concurrent.{Future, ExecutionContext, future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._

import me.blakesmith.sonatron.Config
import me.blakesmith.sonatron.exception.Fault
import me.blakesmith.sonatron.provider.Provider
import me.blakesmith.soundcloud.SoundCloudProvider


@WebService(targetNamespace = "http://www.sonos.com/Services/1.1", name = "SonosSoap")
class SonatronServiceServer(provider: Provider) {
  @Resource
  private var context: WebServiceContext = _

  @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
  @WebResult(name = "getMetadataResponse", targetNamespace = "http://www.sonos.com/Services/1.1", partName = "parameters")
  @WebMethod(action = "http://www.sonos.com/Services/1.1#getMetadata")
  def getMetadata(@WebParam(partName = "parameters", name = "getMetadata", targetNamespace = "http://www.sonos.com/Services/1.1") params: GetMetadata): GetMetadataResponse = {
    val metadata = Await.result(provider.getMetadataResponse(
      userToken,
      params.getIndex,
      params.getCount,
      false
    ), 5.seconds)
    val mediaList = new MediaList
    mediaList.setIndex(0)
    mediaList.setCount(metadata.members.length)
    mediaList.setTotal(metadata.members.length) // TODO: Should be more

    metadata.members.foreach { meta =>
      mediaList.getMediaCollectionOrMediaMetadata.add(meta)
    }
    val resp = new GetMetadataResponse
    resp.setGetMetadataResult(mediaList)
    resp
  }

  @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
  @WebResult(name = "searchResponse", targetNamespace = "http://www.sonos.com/Services/1.1", partName = "parameters")
  @WebMethod(action = "http://www.sonos.com/Services/1.1#search")
  def search(@WebParam(partName = "parameters", name = "search", targetNamespace = "http://www.sonos.com/Services/1.1") search: Search): SearchResponse = {
    println("search")
    val resp = new SearchResponse
    resp
  }

  @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
  @WebResult(name = "getMediaMetadataResponse", targetNamespace = "http://www.sonos.com/Services/1.1", partName = "parameters")
  @WebMethod(action = "http://www.sonos.com/Services/1.1#getMediaMetadata")
  def getMediaMetadata(params: GetMediaMetadata): GetMediaMetadataResponse = {
    val metadata = Await.result(provider.getMediaMetadata(
      userToken,
      params.getId
    ), 5.seconds)

    val resp = new GetMediaMetadataResponse
    val meta = metadata.members.headOption.getOrElse(throw new IllegalStateException("No metadata"))
    resp.setGetMediaMetadataResult(meta)
    resp
  }

  @RequestWrapper(localName = "getMediaURI", targetNamespace = "http://www.sonos.com/Services/1.1", className = "com.sonos.smapi.soap.GetMediaURI")
  @WebMethod(action = "http://www.sonos.com/Services/1.1#getMediaURI")
  def getMediaURI(
    @WebParam(name = "id", targetNamespace = "http://www.sonos.com/Services/1.1")
      id: String,
    @WebParam(mode = WebParam.Mode.OUT, name = "getMediaURIResult", targetNamespace = "http://www.sonos.com/Services/1.1")
      getMediaUriResult: Holder[String],
    @WebParam(mode = WebParam.Mode.OUT, name = "httpHeaders", targetNamespace = "http://www.sonos.com/Services/1.1")
      httpHeaders: Holder[HttpHeaders]): Unit = {
    val media = Await.result(provider.getMediaURI(
      userToken,
      id
    ), 5.seconds)
    media.headers.foreach { case(k, v) =>
      val header = new HttpHeader
      header.setHeader(k)
      header.setValue(v)
      httpHeaders.value.getHttpHeader.add(header)
    }
    getMediaUriResult.value = media.url
  }

  @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
  @WebResult(name = "getExtendedMetadataResponse", targetNamespace = "http://www.sonos.com/Services/1.1", partName = "parameters")
  @WebMethod(action = "http://www.sonos.com/Services/1.1#getExtendedMetadata")
  def getExtendedMetadata(params: GetExtendedMetadata): GetExtendedMetadataResponse = {
    println("Extended metadata")
    val resp = new GetExtendedMetadataResponse
    resp
  }

  @SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
  @WebResult(name = "getExtendedMetadataTextResponse", targetNamespace = "http://www.sonos.com/Services/1.1", partName = "parameters")
  @WebMethod(action = "http://www.sonos.com/Services/1.1#getExtendedMetadataText")
  def getExtendedMetadataText(params: GetExtendedMetadataText): GetExtendedMetadataTextResponse = {
    println("Extended metadata text")
    val resp = new GetExtendedMetadataTextResponse
    resp
  }

  @WebResult(name = "getDeviceLinkCodeResult", targetNamespace = "http://www.sonos.com/Services/1.1")
  @RequestWrapper(localName = "getDeviceLinkCode", targetNamespace = "http://www.sonos.com/Services/1.1", className = "com.sonos.smapi.soap.GetDeviceLinkCode")
  @WebMethod(action = "http://www.sonos.com/Services/1.1#getDeviceLinkCode")
  @ResponseWrapper(localName = "getDeviceLinkCodeResponse", targetNamespace = "http://www.sonos.com/Services/1.1", className = "com.sonos.smapi.soap.GetDeviceLinkCodeResponse")
  def getDeviceLinkCode(@WebParam(name = "householdId", targetNamespace = "http://www.sonos.com/Services/1.1") householdId: String): DeviceLinkCodeResult = {
    val link = new DeviceLinkCodeResult
    val code = Await.result(provider.getDeviceLinkCode(householdId), 5.seconds)
    link.setRegUrl(code.url)
    link.setLinkCode(code.linkCode)
    link.setShowLinkCode(code.showLinkCode)
    link
  }

  @WebResult(name = "getDeviceAuthTokenResult", targetNamespace = "http://www.sonos.com/Services/1.1")
  @RequestWrapper(localName = "getDeviceAuthToken", targetNamespace = "http://www.sonos.com/Services/1.1", className = "com.sonos.smapi.soap.GetDeviceAuthToken")
  @WebMethod(action = "http://www.sonos.com/Services/1.1#getDeviceAuthToken")
  @ResponseWrapper(localName = "getDeviceAuthTokenResponse", targetNamespace = "http://www.sonos.com/Services/1.1", className = "com.sonos.smapi.soap.GetDeviceAuthTokenResponse")
  def getDeviceAuthToken(@WebParam(name = "householdId", targetNamespace = "http://www.sonos.com/Services/1.1") householdId: String,
    @WebParam(name = "linkCode", targetNamespace = "http://www.sonos.com/Services/1.1") linkCode: String): DeviceAuthTokenResult = {
    val token = Await.result(provider.getDeviceAuthToken(householdId, linkCode) map(_.getOrElse(Fault.sonosFault("Not authenticated yet", "NOT_LINKED_RETRY", 5))), 5.seconds)
    val authToken = new DeviceAuthTokenResult
    authToken.setAuthToken(token.token)
    authToken.setPrivateKey(token.privateKey)
    authToken
  }

  @WebResult(name = "getLastUpdateResult", targetNamespace = "http://www.sonos.com/Services/1.1")
  @RequestWrapper(localName = "getLastUpdate", targetNamespace = "http://www.sonos.com/Services/1.1", className = "com.sonos.smapi.soap.GetLastUpdate")
  @WebMethod(action = "http://www.sonos.com/Services/1.1#getLastUpdate")
  @ResponseWrapper(localName = "getLastUpdateResponse", targetNamespace = "http://www.sonos.com/Services/1.1", className = "com.sonos.smapi.soap.GetLastUpdateResponse")
  def getLastUpdate(): LastUpdate = {
    val update = new LastUpdate
    update.setCatalog(UUID.randomUUID.toString.slice(0, 31))
    update.setFavorites(UUID.randomUUID.toString.slice(0, 31))
    update.setPollInterval(30)
    update
  }

  private def userToken: String = CredentialsHelper.getCredentialsFromHeaders(context)
}

