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

  def maybeGetAt(x: Int, y: Int)(implicit grid: Seq[Seq[Int]]): Option[Int] =
    grid.lift(x)
      .flatMap{ _.lift(y) }


  def maxSumInColumn(column: Int, sumSize: Int)(implicit grid: Seq[Seq[Int]]): Int = {
    require(sumSize < grid.length)
    def getNextX(startRow: Int, X: Int): Seq[Option[Int]] =
      for (row <- startRow + X until startRow by -1) yield
        maybeGetAt(row, column)

    (for ( rowNumber <- grid.indices ) yield
      getNextX(rowNumber, sumSize)
        .flatten.sum
    ).max
  }

  def maxInRow(row: Int)(implicit grid: Seq[Seq[Int]]): Int = {
    def sumNext4(startCol: Int): Int = {
      grid.apply(row).apply(startCol)
        . + (grid.apply(row).apply(startCol + 1))
        . + (grid.apply(row).apply(startCol + 2))
        . + (grid.apply(row).apply(startCol + 3))
    }
    (for (colNumber <- Range(0, grid.apply(row).length - 3)) yield sumNext4(colNumber)).max
  }

  def maxInDiagRight(row: Int)(implicit grid: Seq[Seq[Int]]): Int = {
    def sumNext4(startCol: Int): Int = {
      grid.apply(row).apply(startCol)
        . + (grid.apply(row - 1).apply(startCol + 1))
        . + (grid.apply(row - 2).apply(startCol + 2))
        . + (grid.apply(row - 3).apply(startCol + 3))
    }
    (for (colNumber <- Range(0, grid.apply(row).length - 3)) yield sumNext4(colNumber)).max
  }

  def maxInDiagLeft(row: Int)(implicit grid: Seq[Seq[Int]]): Int = {
    def sumNext4(startCol: Int): Int = {
      grid.apply(row).apply(startCol)
        . + (grid.apply(row - 1).apply(startCol - 1))
        . + (grid.apply(row - 2).apply(startCol - 2))
        . + (grid.apply(row - 3).apply(startCol - 3))
    }
    (for (colNumber <- Range(3, grid.apply(row).length).reverse) yield sumNext4(colNumber)).max
  }
}
