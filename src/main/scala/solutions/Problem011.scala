package solutions

object Problem011 {
  val grid: Seq[Seq[Int]] = parseGrid("Problem011Grid")
  def parseGrid(gridName: String): Seq[Seq[Int]] = {
    val source = io.Source.fromInputStream(getClass.getResourceAsStream(s"/$gridName.csv"))
    val result = source.getLines().toSeq
      .map { _.split(",")
        .map { _.trim.toInt }.toSeq
      }
    result
  }

  def getAt(x: Int, y: Int)(implicit grid: Seq[Seq[Int]]) = {
    val row: Option[Seq[Int]] = grid.isDefinedAt(x) match {
      case true => Some(grid.apply(x))

      case _ => None
    }
    row.map {row =>
      row.isDefinedAt(y) match {
        case true => Some(row.apply(y))
        case _ => None
      }
    }.flatten
  }
}
