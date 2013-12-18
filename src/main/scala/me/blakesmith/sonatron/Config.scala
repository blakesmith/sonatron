package me.blakesmith.sonatron

import org.iq80.leveldb.Options
import org.iq80.leveldb.impl.Iq80DBFactory

import java.io.File

import me.blakesmith.soundcloud.{Client => SoundCloudClient}
import me.blakesmith.sonatron.db.LinkCodeDAO

import me.blakesmith.digitallyimported.DiProvider
import me.blakesmith.soundcloud.SoundCloudProvider
import me.blakesmith.youtube.YoutubeProvider


object Config {
  private val levelFile = "/var/lib/sonatron/sonatron.ldb"
  private val levelOptions = new Options
  private val levelDb = Iq80DBFactory.factory.open(new File(levelFile), levelOptions)

  private val soundcloudKey = "e10f65a53ebbf3a7156182d2987a8ec2"
  private val soundcloudSecret = "3768ee10efdaf0170ab1f03217cf6210"
  private val youtubeKey = "AIzaSyCu5WTbXeIMCmgE4aWjN_XiUrkERzHDFog"

  val linkDao = new LinkCodeDAO(levelDb)
  val soundCloud = new SoundCloudClient(soundcloudKey, soundcloudSecret)

  val soundcloudProvider = new SoundCloudProvider(soundcloudKey, soundcloudSecret, linkDao)
  val diProvider = new DiProvider
  val youtubeProvider = new YoutubeProvider(youtubeKey)
}
