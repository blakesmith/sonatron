package me.blakesmith.sonatron.db

trait Serializer[T] {
  def toBytes(item: T): Array[Byte]
  def fromBytes(bytes: Array[Byte]): T
}
