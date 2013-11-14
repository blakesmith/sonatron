package me.blakesmith.sonatron

import org.iq80.leveldb.Options
import org.iq80.leveldb.impl.Iq80DBFactory

import java.io.File

import me.blakesmith.soundcloud.{Client => SoundCloud}
import me.blakesmith.sonatron.db.LinkCodeDAO


object Config {
  val soundCloud = new SoundCloud("e10f65a53ebbf3a7156182d2987a8ec2", "3768ee10efdaf0170ab1f03217cf6210")
  private val levelFile = "/var/lib/sonatron/sonatron.ldb"
  private val levelOptions = new Options
  private val levelDb = Iq80DBFactory.factory.open(new File(levelFile), levelOptions)

  val linkDao = new LinkCodeDAO(levelDb)
}
