package me.blakesmith.sonatron.provider

import com.sonos.smapi.soap.{MediaMetadata, StreamMetadata, TrackMetadata}
import me.blakesmith.soundcloud.Track

class Metadata(val members: Array[MediaMetadata])

object Metadata {
  def fromTracks(tracks: List[Track]): Metadata = {
    new Metadata(
      tracks map { track =>
        val mm = new MediaMetadata
        mm.setMimeType("audio/mpeg")
        mm.setTitle(track.title)

        val tm = new TrackMetadata
        tm.setCanSkip(false) // This should probably be true, and support skipping
        tm.setArtist(track.user.username)
        tm.setAlbumArtist(track.user.username)
        tm.setAlbumArtURI(track.artworkUrl)

        mm.setTrackMetadata(tm)
        mm
      } toArray
    )
  }
}
