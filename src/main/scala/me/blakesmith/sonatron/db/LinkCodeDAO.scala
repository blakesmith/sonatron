package me.blakesmith.sonatron.db

import org.iq80.leveldb.{DB => LevelDB}

import com.soundcloud.api.Token

import scala.concurrent.{Future, ExecutionContext, future}
import scala.concurrent.ExecutionContext.Implicits.global


class LinkCodeDAO(db: LevelDB) {
  def saveAuthToken(code: String, token: Token): Future[Unit] =
    future { db.put(keyFor(code), tokenToBytes(token)) }

  def getAuthToken(code: String): Future[Option[Token]] =
    future { 
      db.get(keyFor(code)) match {
        case null => None
        case v => Some(bytesToToken(v))
      }
    }

  private def keyFor(code: String): Array[Byte] = "linkCode:%s".format(code).getBytes

  private def tokenToBytes(token: Token): Array[Byte] = "%s:%s:%s".format(token.access, token.refresh, token.scope).getBytes

  private def bytesToToken(bytes: Array[Byte]): Token = {
    val str = new String(bytes, "UTF-8")
    str.split(':').toList match {
      case access :: refresh :: scope :: Nil => new Token(access, refresh, scope)
      case l => throw new RuntimeException("Failed to deserialize token: %s".format(l))
    }
  }
    
}
