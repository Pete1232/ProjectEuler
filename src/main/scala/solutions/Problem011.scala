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

  def getAt(x: Int, y: Int)(implicit grid: Seq[Seq[Int]]): Option[Int] = {
    grid
      .lift(x)
      .flatMap{
        row => row.lift(y)
      }
  }

  def maxInColumn(column: Int)(implicit grid: Seq[Seq[Int]]): Int = {
    def sumNext4(startRow: Int): Int = {
      grid.apply(startRow).apply(column)
        . + (grid.apply(startRow + 1).apply(column))
        . + (grid.apply(startRow + 2).apply(column))
        . + (grid.apply(startRow + 3).apply(column))
    }
    (for (rowNumber <- Range(0, grid.length - 3)) yield sumNext4(rowNumber)).max
  }
}
