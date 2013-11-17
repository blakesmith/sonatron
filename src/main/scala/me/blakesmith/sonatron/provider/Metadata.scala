package me.blakesmith.sonatron.provider

import java.util.UUID

import com.sonos.smapi.soap.{MediaMetadata, StreamMetadata, TrackMetadata}
import me.blakesmith.soundcloud.Track

class Metadata(val members: Array[MediaMetadata])

object Metadata {
  def fromTracks(tracks: List[Track]): Metadata = {
    new Metadata(
      tracks map { track =>
        val mm = new MediaMetadata
        mm.setId(UUID.randomUUID.toString.slice(0, 31))
        mm.setMimeType("audio/mpeg")
        mm.setTitle(track.title)

        val tm = new TrackMetadata
        tm.setCanSkip(false) // This should probably be true, and support skipping
        tm.setCanPlay(true)
        tm.setCanAddToFavorites(false)
        tm.setArtist("Test")//track.user.username)
        tm.setAlbumArtist("Test")//track.user.username)
        tm.setGenreId("Some genre id")
        tm.setGenre("Some genre")
        tm.setDuration(1234)
        tm.setAlbumArtURI(track.artworkUrl)

        mm.setTrackMetadata(tm)
        mm
      } toArray
    )
  }
}
