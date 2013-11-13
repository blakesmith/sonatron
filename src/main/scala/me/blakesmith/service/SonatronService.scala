package me.blakesmith.sonatron.service

import javax.jws.{WebMethod, WebService}

import com.sonos.smapi.soap.{GetExtendedMetadata, GetExtendedMetadataResponse}
import com.sonos.smapi.soap.{GetExtendedMetadataText, GetExtendedMetadataTextResponse}
import com.sonos.smapi.soap.{GetMediaMetadata, GetMediaMetadataResponse}
import com.sonos.smapi.soap.{GetMediaURI, GetMediaURIResponse}
import com.sonos.smapi.soap.{GetMetadata, GetMetadataResponse}
import com.sonos.smapi.soap.{GetSessionId, GetSessionIdResponse}
import com.sonos.smapi.soap.LastUpdate
import com.sonos.smapi.soap.{Search, SearchResponse}


trait SonatronService {
  @WebMethod
  def getSessionId(sid: GetSessionId): GetSessionIdResponse
  
  @WebMethod
  def getMetadata(meta: GetMetadata): GetMetadataResponse

  @WebMethod
  def search(search: Search): SearchResponse

  @WebMethod
  def getMediaMetadata(params: GetMediaMetadata): GetMediaMetadataResponse

  @WebMethod
  def getMediaURI(params: GetMediaURI): GetMediaURIResponse

  @WebMethod
  def getLastUpdate: LastUpdate

  @WebMethod
  def getExtendedMetadata(params: GetExtendedMetadata): GetExtendedMetadataResponse

  @WebMethod
  def getExtendedMetadataText(params: GetExtendedMetadataText): GetExtendedMetadataTextResponse
}


@WebService
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
}

