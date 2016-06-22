package solutions

object Problem011 {
  def parseGrid: Seq[Seq[Int]] = {
    val source = io.Source.fromInputStream(getClass.getResourceAsStream("/Problem011Grid.csv"))
    val sourceLines = source.getLines().toSeq
    source.close()

    sourceLines.map {line =>
      line.split(",").map(_.trim.toInt).toSeq
    }
  }
}
