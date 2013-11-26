package me.blakesmith.pls

import scala.util.parsing.combinator.{Parsers, JavaTokenParsers}

sealed trait PlsLine {
  val num: Int
}
case class PlsFile(val num: Int, val file: String) extends PlsLine
case class PlsTitle(val num: Int, val title: String) extends PlsLine
case class PlsLength(val num: Int, val length: Int) extends PlsLine

case class PlsEntry(val num: Int, val file: PlsFile, val title: Option[PlsTitle], val length: Option[PlsLength])

case class Pls(val version: Int, val numEntries: Int, val entries: List[PlsEntry])

object PlsParser extends JavaTokenParsers {
  def pls: Parser[Pls] = (header ~> numEntries ~ (plsLine*) ~ version) ^^ {
    case numEnt ~ lines ~ vers => Pls(vers, numEnt, toEntries(lines))
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

  private def toEntries(lines: List[PlsLine]): List[PlsEntry] =
    lines.groupBy(_.num).toList.map { case(num, lines) =>
      PlsEntry(
        num,
        getFile(lines),
        getTitle(lines),
        getLength(lines)
      )
    }

  private def getFile(lines: List[PlsLine]): PlsFile =
    lines.foldLeft(PlsFile(0, "")) { case (acc, cur) =>
      cur match {
        case p: PlsFile => p
        case _ => acc
      }
    }

  private def getTitle(lines: List[PlsLine]): Option[PlsTitle] =
    lines.foldLeft(None.asInstanceOf[Option[PlsTitle]]) { case (acc, cur) =>
      cur match {
        case p: PlsTitle => Some(p)
        case _ => acc
      }
    }

  private def getLength(lines: List[PlsLine]): Option[PlsLength] =
    lines.foldLeft(None.asInstanceOf[Option[PlsLength]]) { case (acc, cur) =>
      cur match {
        case p: PlsLength => Some(p)
        case _ => acc
      }
    }
}
