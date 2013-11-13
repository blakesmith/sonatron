import org.scalatra.LifeCycle
import javax.servlet.ServletContext

import me.blakesmith.sonatron.services.SonatronWebService


class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {
    context mount (new SonatronWebService, "/*")
  }
}
