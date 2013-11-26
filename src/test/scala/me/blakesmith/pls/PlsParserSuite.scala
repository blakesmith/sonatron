package me.blakesmith.pls

import org.scalatest.FunSuite

class PlsParserSuite extends FunSuite {
  val correct: String =
"""
[playlist]
NumberOfEntries=8
File1=http://pub4.di.fm:80/di_latinhouse
Title1=Digitally Imported - Latin House
Length1=-1
File2=http://pub6.di.fm:80/di_latinhouse
Title2=Digitally Imported - Latin House
Length2=-1
File3=http://pub1.di.fm:80/di_latinhouse
Title3=Digitally Imported - Latin House
Length3=-1
File4=http://pub5.di.fm:80/di_latinhouse
Title4=Digitally Imported - Latin House
Length4=-1
File5=http://pub3.di.fm:80/di_latinhouse
Title5=Digitally Imported - Latin House
Length5=-1
File6=http://pub8.di.fm:80/di_latinhouse
Title6=Digitally Imported - Latin House
Length6=-1
File7=http://pub7.di.fm:80/di_latinhouse
Title7=Digitally Imported - Latin House
Length7=-1
File8=http://pub2.di.fm:80/di_latinhouse
Title8=Digitally Imported - Latin House
Length8=-1
Version=2
"""
  test("correct pls parsing") {
    val parsed = PlsParser(correct)
    assert(parsed.isRight)
    val pls = parsed.right.get

    assert(pls.numEntries === 8)
    assert(pls.numEntries === pls.entries.length)
    assert(pls.version === 2)
    assert(pls.entries(0).file.file == "http://pub4.di.fm:80/di_latinhouse")
    assert(pls.entries(0).title.map(_.title).getOrElse("No title") == "Digitally Imported - Latin House")
    assert(pls.entries(0).length.map(_.length).getOrElse(0) == -1)
    assert(pls.entries(7).file.file == "http://pub2.di.fm:80/di_latinhouse")
    assert(pls.entries(7).title.map(_.title).getOrElse("No title") == "Digitally Imported - Latin House")
    assert(pls.entries(7).length.map(_.length).getOrElse(0) == -1)

  }
}
