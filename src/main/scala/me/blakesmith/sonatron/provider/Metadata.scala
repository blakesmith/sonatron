package me.blakesmith.sonatron.provider

// TODO: This class relationship should be inverted, it should not know about all these different provider types.

import com.sonos.smapi.soap.{AbstractMedia, MediaMetadata, MediaCollection, StreamMetadata, TrackMetadata, ItemType}
import me.blakesmith.soundcloud.Track
import me.blakesmith.util.IsoDurationParser
import me.blakesmith.digitallyimported.models.Channel
import com.google.api.services.youtube.model.{SearchResult, Video}

class Metadata(val metadata: Array[MediaMetadata],
  val mediaCollection: Array[MediaCollection]=Array())

object Metadata {
  def empty = new Metadata(Array())

  def fromTracks(tracks: List[Track]): Metadata = {
    new Metadata(
      tracks map { track =>
        val mm = new MediaMetadata
        mm.setItemType(ItemType.TRACK)
        mm.setId(track.id.toString)
        mm.setMimeType("audio/mp3")
        mm.setTitle(track.title)

        val tm = new TrackMetadata
        tm.setCanSkip(true) // This should probably be true, and support skipping
        tm.setCanPlay(true)
        tm.setCanAddToFavorites(false)
        tm.setArtist(track.user.username)
        tm.setAlbumArtist(track.user.username)
        tm.setGenreId("NA")
        tm.setGenre(track.genre)
        tm.setDuration(track.duration / 1000)
        tm.setAlbumArtURI(track.artworkUrl)

        mm.setTrackMetadata(tm)
        mm
      } toArray
    )
  }

  def fromSearchResult(results: List[SearchResult]): Metadata = {
    new Metadata(
      results map { result =>
        val mm = new MediaMetadata
        mm.setItemType(ItemType.TRACK)
        val snippet = result.getSnippet
        mm.setId(result.getId.getVideoId)
        mm.setMimeType("audio/mpeg")
        mm.setTitle(snippet.getTitle)

        val tm = new TrackMetadata
        tm.setCanSkip(true) // This should probably be true, and support skipping
        tm.setCanPlay(true)
        tm.setCanAddToFavorites(false)
        tm.setArtist(snippet.getChannelTitle)
        tm.setDuration(1000)
        tm.setAlbumArtURI(snippet.getThumbnails.getDefault.getUrl)
        mm.setTrackMetadata(tm)

        mm
      } toArray
    )
  }

  def fromVideo(video: Video): Metadata = {
    val mm = new MediaMetadata
    mm.setItemType(ItemType.TRACK)
    val snippet = video.getSnippet
    mm.setId(video.getId)
    mm.setMimeType("audio/mpeg")
    mm.setTitle(snippet.getTitle)

    val tm = new TrackMetadata
    tm.setCanSkip(true) // This should probably be true, and support skipping
    tm.setCanPlay(true)
    tm.setCanAddToFavorites(false)
    tm.setArtist(snippet.getChannelTitle)
    IsoDurationParser(video.getContentDetails.getDuration) match {
      case Left(msg) =>
        println(msg)
        tm.setDuration(2000)
      case Right(seconds) => tm.setDuration(seconds)
    }
    tm.setAlbumArtURI(snippet.getThumbnails.getDefault.getUrl)
    mm.setTrackMetadata(tm)

    new Metadata(Array(mm))
  }

  def placeHolder(): Metadata = {
    val mm = new MediaMetadata
    mm.setItemType(ItemType.CONTAINER)
    mm.setId("searchOnly")
    mm.setTitle("Search Only")
    new Metadata(Array(mm))
  }

  def searchByKeywordAndUrl(): Metadata = {
    val keyword = new MediaCollection
    keyword.setItemType(ItemType.SEARCH)
    keyword.setId("keyword")
    keyword.setTitle("Keyword")

    val url = new MediaCollection
    url.setItemType(ItemType.SEARCH)
    url.setId("url")
    url.setTitle("URL")
    new Metadata(Array(), Array(keyword, url))
  }

  def fromChannels(chans: List[Channel]): Metadata = {
    new Metadata (
      chans.sortBy(_.name) map { chan =>
        val mm = new MediaMetadata
        mm.setItemType(ItemType.STREAM)
        mm.setId(chan.key)
        mm.setMimeType("audio/mp3")
        mm.setTitle(chan.name)

        val sm = new StreamMetadata
        sm.setBitrate(96)
//        sm.setLogo

        mm.setStreamMetadata(sm)
        mm
      } toArray
    )
  }
}
