package me.blakesmith.soundcloud

import com.soundcloud.api.Token
import me.blakesmith.sonatron.db.Serializer

object TokenSerializer extends Serializer[Token] {
  def toBytes(token: Token): Array[Byte] = "%s:%s:%s".format(token.access, token.refresh, token.scope).getBytes

  def fromBytes(bytes: Array[Byte]): Token = {
    val str = new String(bytes, "UTF-8")
    str.split(':').toList match {
      case access :: refresh :: scope :: Nil => new Token(access, refresh, scope)
      case l => throw new RuntimeException("Failed to deserialize token: %s".format(l))
    }
  }
}
