package me.blakesmith.util

import scala.util.parsing.combinator.{Parsers, JavaTokenParsers}

object IsoDurationParser extends JavaTokenParsers {
  def apply(input: String): Either[String, Int] = parseAll(isoDuration, input) match {
    case Success(result, _) => Right(result)
    case NoSuccess(msg, _) => Left(msg)
  }

  def isoDuration: Parser[Int] = (periodTime ~> minutes ~ minuteDelim ~ seconds ~ secondDelim) ^^ {
    case min ~ _ ~ sec ~ _ => (min * 60) + sec
  }

  def periodTime: Parser[String] = "PT"
  def minutes: Parser[Int] = wholeNumber ^^ (_.toInt)
  def minuteDelim: Parser[String] = "M"
  def seconds: Parser[Int] = wholeNumber ^^ (_.toInt)
  def secondDelim: Parser[String] = "S"
}
