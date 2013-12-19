package me.blakesmith.sonatron.provider

// TODO: This class relationship should be inverted, it should not know about all these different provider types.

import com.sonos.smapi.soap.{MediaMetadata, StreamMetadata, TrackMetadata, ItemType}
import me.blakesmith.soundcloud.Track
import me.blakesmith.digitallyimported.models.Channel
import com.google.api.services.youtube.model.SearchResult

class Metadata(val members: Array[MediaMetadata])

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

  def fromVideos(results: List[SearchResult]): Metadata = {
    new Metadata(
      results map { result =>
        val mm = new MediaMetadata
        mm.setItemType(ItemType.TRACK)
        val snippet = result.getSnippet
        mm.setId(result.getId.getVideoId)
        mm.setMimeType("audio/mp3")
        mm.setTitle(snippet.getTitle)

        val tm = new TrackMetadata
        tm.setCanSkip(true) // This should probably be true, and support skipping
        tm.setCanPlay(true)
        tm.setCanAddToFavorites(false)
        tm.setArtist(snippet.getChannelTitle)
//        tm.setAlbumArtist(track.user.username)
//        tm.setGenreId("NA")
//        tm.setGenre(track.genre)
        tm.setDuration(1000)
        tm.setAlbumArtURI(snippet.getThumbnails.getDefault.getUrl)

        mm.setTrackMetadata(tm)
        mm
      } toArray
    )
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
