package me.blakesmith.youtube

import scala.concurrent.{Future, future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.collection.JavaConversions._
import scala.collection.mutable.Buffer

import com.google.api.client.http.{HttpRequest, HttpRequestInitializer}
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.youtube.YouTube
import com.google.api.services.youtube.model.{ResourceId, SearchListResponse, SearchResult, Thumbnail}


class YoutubeClient(key: String) {
  private val httpTransport = new NetHttpTransport
  private val jsonFactory = new JacksonFactory
  private val yt = new YouTube.Builder(httpTransport, jsonFactory, new HttpRequestInitializer {
    def initialize(req: HttpRequest) {}
  }).build

  def getVideo(id: String): Unit = ???
  def getAudioStream(id: String): Unit = ???

  def search(userId: String, searchId: String, term: String, index: Int, count: Int): Future[List[SearchResult]] =
    future {
      val search = yt.search.list("id,snippet")
      search.setKey(key)
      search.setQ(term)
      search.setType("video")
      search.setMaxResults(count)
      val items: Buffer[SearchResult] = search.execute.getItems
      items.toList
    }

}
