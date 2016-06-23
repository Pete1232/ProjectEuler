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


  def maxSumOfX(X: Int)(implicit grid: Seq[Seq[Int]]): Int = {
    def getNextXInRow(row: Int, startCol: Int, X: Int) =
      for (col <- startCol until startCol + X) yield
        maybeGetAt(row, col)

    def getNextXInCol(startRow: Int, col: Int, X: Int) =
      for (row <- startRow until startRow + X) yield
        maybeGetAt(row, col)

    def getNextXInDiagRight(startRow: Int, startCol: Int, X: Int) =
      for (mod <- 0 until X) yield
        maybeGetAt(startRow + mod, startCol - mod)

    def getNextXInDiagLeft(startRow: Int, startCol: Int, X: Int) =
      for (mod <- 0 until X) yield
        maybeGetAt(startRow + mod, startCol + mod)

    (for ( rowNumber <- grid.indices; colNumber <- grid.apply(0).indices ) yield {
        Seq(
          getNextXInRow(rowNumber, colNumber, X).flatten.sum,
          getNextXInCol(rowNumber, colNumber, X).flatten.sum,
          getNextXInDiagRight(rowNumber, colNumber, X).flatten.sum,
          getNextXInDiagLeft(rowNumber, colNumber, X).flatten.sum
        ).max
    }) max
  }
}
