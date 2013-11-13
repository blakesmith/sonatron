import org.scalatra.LifeCycle
import javax.servlet.ServletContext

import me.blakesmith.soundcloud.{Client => SoundCloud}
import me.blakesmith.sonatron.services.SonatronWebService

class ScalatraBootstrap extends LifeCycle {
  val soundCloud = new SoundCloud("e10f65a53ebbf3a7156182d2987a8ec2", "3768ee10efdaf0170ab1f03217cf6210")

  override def init(context: ServletContext) {
    context mount (new SonatronWebService(soundCloud), "/*")
  }
}
