package me.blakesmith.soundcloud

import com.fasterxml.jackson.annotation.{JsonProperty, JsonIgnoreProperties}

@JsonIgnoreProperties(ignoreUnknown = true)
case class MiniUser(
  id: Int, permalink: String,
  username: String,
  uri: String,
  @JsonProperty("permalink_url") permalinkUrl: String,
  @JsonProperty("avatar_url") avatarUrl: String
)
