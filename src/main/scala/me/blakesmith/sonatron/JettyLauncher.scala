package me.blakesmith.sonatron

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler}
import org.eclipse.jetty.webapp.WebAppContext

import org.scalatra.servlet.ScalatraListener

class JettyLauncher(dir: String="src/main/resources", port: Int=9191) extends Runnable {
  val server = new Server(port)

  def runInBackground(): Thread = {
    val thread = new Thread(this);
    thread.start
    thread
  }

  def run(): Unit = {
    val context = new WebAppContext()
    context setContextPath "/"
    context.setResourceBase(dir)
    context.addEventListener(new ScalatraListener)
    context.addServlet(classOf[DefaultServlet], "/")
    server.setHandler(context)
    server.start
    server.join
  }
}
