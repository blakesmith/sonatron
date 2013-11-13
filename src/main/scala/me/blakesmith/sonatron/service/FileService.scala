package me.blakesmith.sonatron.service

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.{DefaultServlet, ServletContextHandler}
import org.eclipse.jetty.webapp.WebAppContext
import org.eclipse.jetty.server.handler.{ContextHandler, ResourceHandler}

class FileService(dir: String="src/main/static", route: String="/static", port: Int=8081) extends Runnable {
  val server = new Server(port)

  def runInBackground(): Thread = {
    val thread = new Thread(this);
    thread.start
    thread
  }

  def run(): Unit = {
    val handler = new ResourceHandler
    val context = new ContextHandler(route)

    handler.setDirectoriesListed(false)
    handler.setResourceBase(dir)

    context.setHandler(handler)

    server.setHandler(context)
    server.start
    server.join
  }
}
