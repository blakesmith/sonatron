package me.blakesmith.soundcloud

import com.fasterxml.jackson.annotation.{JsonProperty, JsonIgnoreProperties}

@JsonIgnoreProperties(ignoreUnknown = true)
case class ActivityTrack(
  @JsonProperty("type") collType: String,
  @JsonProperty("created_at") createdAt: String,
  origin: Track
)

@JsonIgnoreProperties(ignoreUnknown = true)
case class TrackActivityResponse(
  @JsonProperty("next_href") nextHref: String,
  collection: List[ActivityTrack]
)
