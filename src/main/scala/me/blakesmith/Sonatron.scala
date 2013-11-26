package me.blakesmith.sonatron

import javax.xml.ws.Endpoint

import me.blakesmith.digitallyimported.DiProvider
import me.blakesmith.sonatron.service.SonatronServiceServer
import me.blakesmith.soundcloud.SoundCloudProvider

object App {
  def main(args: Array[String]): Unit = {
    val jetty = new JettyLauncher
    jetty.runInBackground

    val soundcloudProvider = new SoundCloudProvider("e10f65a53ebbf3a7156182d2987a8ec2", "3768ee10efdaf0170ab1f03217cf6210")
    val diProvider = new DiProvider

    Endpoint.publish("http://0.0.0.0:9090/", new SonatronServiceServer(soundcloudProvider))
    Endpoint.publish("http://0.0.0.0:9091/", new SonatronServiceServer(diProvider))
  }
}
