package solutions

object Problem011Methods{
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
    require(X <= grid.length && X <= grid.apply(0).length)
    def getNextXInRow(startRow: Int, startCol: Int, X: Int) =
      for (mod <- 0 until X) yield
        maybeGetAt(startRow, startCol + mod)

    def getNextXInCol(startRow: Int, startCol: Int, X: Int) =
      for (mod <- 0 until X) yield
        maybeGetAt(startRow + mod, startCol)

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

  def maxProductOfX(X: Int)(implicit grid: Seq[Seq[Int]]): Int = {
    require(X <= grid.length && X <= grid.apply(0).length)
    def getNextXInRow(startRow: Int, startCol: Int, X: Int) =
      for (mod <- 0 until X) yield
        maybeGetAt(startRow, startCol + mod)

    def getNextXInCol(startRow: Int, startCol: Int, X: Int) =
      for (mod <- 0 until X) yield
        maybeGetAt(startRow + mod, startCol)

    def getNextXInDiagRight(startRow: Int, startCol: Int, X: Int) =
      for (mod <- 0 until X) yield
        maybeGetAt(startRow + mod, startCol - mod)

    def getNextXInDiagLeft(startRow: Int, startCol: Int, X: Int) =
      for (mod <- 0 until X) yield
        maybeGetAt(startRow + mod, startCol + mod)

    (for ( rowNumber <- grid.indices; colNumber <- grid.apply(0).indices ) yield {
      Seq(
        getNextXInRow(rowNumber, colNumber, X).flatten.product,
        getNextXInCol(rowNumber, colNumber, X).flatten.product,
        getNextXInDiagRight(rowNumber, colNumber, X).flatten.product,
        getNextXInDiagLeft(rowNumber, colNumber, X).flatten.product
      ).max
    }) max
  }

}

object Problem011 extends App{
  val grid: Seq[Seq[Int]] = Problem011Methods.parseGrid("Problem011Grid")
  println(Problem011Methods.maxProductOfX(4)(grid))
}
