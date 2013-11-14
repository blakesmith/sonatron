package me.blakesmith.soundcloud

import com.fasterxml.jackson.annotation.{JsonProperty, JsonIgnoreProperties}

@JsonIgnoreProperties(ignoreUnknown = true)
case class App(
  id: Int,
  uri: String,
  @JsonProperty("permalink_url") permalinkUrl: String,
  @JsonProperty("external_url") externalUrl: String,
  name: String,
  creator: String
)
