package me.blakesmith.sonatron.db

import org.iq80.leveldb.{DB => LevelDB}

import scala.concurrent.{Future, ExecutionContext, future}
import scala.concurrent.ExecutionContext.Implicits.global


class LinkCodeDAO[T](db: LevelDB, serializer: Serializer[T]) {
  def saveAuthToken(code: String, token: T): Future[Unit] =
    future { db.put(keyFor(code), serializer.toBytes(token)) }

  def getAuthToken(code: String): Future[Option[T]] =
    future { 
      db.get(keyFor(code)) match {
        case null => None
        case v => Some(serializer.fromBytes(v))
      }
    }

  private def keyFor(code: String): Array[Byte] = "linkCode:%s".format(code).getBytes
}
