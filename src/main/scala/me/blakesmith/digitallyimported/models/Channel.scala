package me.blakesmith.digitallyimported.models

import com.fasterxml.jackson.annotation.{JsonProperty, JsonIgnoreProperties}

@JsonIgnoreProperties(ignoreUnknown = true)
case class Channel(
  id: Int,
  description: String,
  key: String,
  name: String,
  playlist: String
)
