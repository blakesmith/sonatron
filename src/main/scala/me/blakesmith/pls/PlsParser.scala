package me.blakesmith.pls

import scala.util.parsing.combinator.{Parsers, JavaTokenParsers}

sealed trait PlsLine {
  val num: Int
}
case class PlsFile(val num: Int, val file: String) extends PlsLine
case class PlsTitle(val num: Int, val title: String) extends PlsLine
case class PlsLength(val num: Int, val length: Int) extends PlsLine

case class Pls(version: Int, numEntries: Int, lines: List[PlsLine])

object PlsParser extends JavaTokenParsers {
  def pls: Parser[Pls] = (header ~> numEntries ~ (plsLine*) ~ version) ^^ {
    case numEnt ~ lines ~ vers => Pls(vers, numEnt, lines)
  }

  def plsLine: Parser[PlsLine] = fileLine | titleLine | lengthLine
  def header: Parser[String] = "[playlist]"
  def numEntries: Parser[Int] = "NumberOfEntries=" ~> (wholeNumber ^^ (_.toInt))
  def version: Parser[Int] = "Version=" ~> (wholeNumber ^^ (_.toInt))
  
  def fileLine: Parser[PlsFile] = "File" ~> (wholeNumber ^^ (_.toInt)) ~ 
    ("=" ~> """.+""".r) ^^ {
      case num ~ file => PlsFile(num, file)
    }

  def titleLine: Parser[PlsTitle] = "Title" ~> (wholeNumber ^^ (_.toInt)) ~
    ("=" ~> """.+""".r) ^^ {
      case num ~ title => PlsTitle(num, title)
    }

  def lengthLine: Parser[PlsLength] = "Length" ~> (wholeNumber ^^ (_.toInt)) ~
    ("=" ~> (floatingPointNumber ^^ (_.toInt))) ^^ {
      case num ~ length => PlsLength(num, length)
    }
}
