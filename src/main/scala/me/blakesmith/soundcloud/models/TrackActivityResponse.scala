package me.blakesmith.soundcloud

import com.fasterxml.jackson.annotation.{JsonProperty, JsonIgnoreProperties}

@JsonIgnoreProperties(ignoreUnknown = true)
case class TrackActivityResponse(
  @JsonProperty("next_href") nextHref: String,
  collection: List[Track]
)
