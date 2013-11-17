package me.blakesmith.sonatron.provider

import com.sonos.smapi.soap.{MediaMetadata, StreamMetadata, TrackMetadata, ItemType}
import me.blakesmith.soundcloud.Track

class Metadata(val members: Array[MediaMetadata])

object Metadata {
  def fromTracks(tracks: List[Track]): Metadata = {
    new Metadata(
      tracks map { track =>
        val mm = new MediaMetadata
        mm.setItemType(ItemType.TRACK)
        mm.setId(track.id.toString)
        mm.setMimeType("audio/mpeg")
        mm.setTitle(track.title)

        val tm = new TrackMetadata
        tm.setCanSkip(false) // This should probably be true, and support skipping
        tm.setCanPlay(true)
        tm.setCanAddToFavorites(false)
        tm.setArtist(track.user.username)
        tm.setAlbumArtist(track.user.username)
        tm.setGenreId("NA")
        tm.setGenre(track.genre)
        tm.setDuration(track.duration)
        tm.setAlbumArtURI(track.artworkUrl)

        mm.setTrackMetadata(tm)
        mm
      } toArray
    )
  }
}
