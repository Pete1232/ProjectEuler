package utils

import scala.collection.mutable.ArrayBuffer

trait CSVParser {
  var grid: ArrayBuffer[Seq[Int]] = new ArrayBuffer[Seq[Int]]()
  var list: ArrayBuffer[Seq[String]] = new ArrayBuffer[Seq[String]]()

  def parseIntGrid(gridName: String): Unit = {
    val source = io.Source.fromInputStream(getClass.getResourceAsStream(s"/$gridName.csv"))
    val result = source.getLines().toSeq
      .map { _.split(",")
        .map { _.trim.toInt }.toSeq
      }
    result.copyToBuffer(grid)
    source.close()
  }

  def parseStringList(listName: String): Unit = {
    val source = io.Source.fromInputStream(getClass.getResourceAsStream(s"/$listName.csv"))
    val result = source.getLines().toSeq
      .map { _.split(",")
        .map { _.trim }.toSeq
      }
    result.copyToBuffer(list)
    source.close()
  }
}
