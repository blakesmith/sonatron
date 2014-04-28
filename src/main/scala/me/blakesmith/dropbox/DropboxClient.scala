package me.blakesmith.dropbox

import java.util.Locale

import scala.concurrent.{Future, future}
import scala.concurrent.ExecutionContext.Implicits.global

import com.dropbox.core.{DbxAppInfo, DbxRequestConfig, DbxWebAuthNoRedirect}

class DropboxClient(key: String, secret: String) {
  private val appInfo = new DbxAppInfo(key, secret)
  private val config = new DbxRequestConfig("Sonatron", Locale.getDefault.toString)
  private val webAuth = new DbxWebAuthNoRedirect(config, appInfo)

  def authorizationUrl: Future[String] = future { webAuth.start }
}
