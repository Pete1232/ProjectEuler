package solutions

import utils.CSVParser

import scala.collection.mutable

object Problem011Methods extends CSVParser{
  def maxSumOfX(X: Int)(implicit grid: Seq[Seq[Int]]): Int = {
    maxOpX(X, (x: Int, y: Int) => x + y, 0)
  }

  def maxProductOfX(X: Int)(implicit grid: Seq[Seq[Int]]): Int = {
    maxOpX(X, (x: Int, y: Int) => x * y, 1)
  }

  private def maxOpX(X: Int, binOp: (Int, Int) => Int, unit: Int)(implicit grid: Seq[Seq[Int]]): Int = {
    // improve efficiency for large values by not checking outside the grid
    val x = math.min(X, math.max(grid.length, grid.apply(0).length))

    // calculate the maximum X in a line for any line starting at (row, col)
    def calculateMaxTotalAt(row: Int, col: Int) = {
      (for (mod <- 0 until x) yield
        Seq(
          maybeGetValueAt(row, col + mod),        // row
          maybeGetValueAt(row + mod, col),        // column
          maybeGetValueAt(row + mod, col - mod),  // right diagonal
          maybeGetValueAt(row + mod, col + mod)   // left diagonal
        )
      ) // returns a collection of (row, column, left diagonal, right diagonal)
      .reduceLeft((a: Seq[Option[Int]], b: Seq[Option[Int]]) => {
        a.zip(b)  // put the lines together a bit at a time
          .map(pair =>
            Some(binOp(pair._1.getOrElse(unit), pair._2.getOrElse(unit)))   // add up the values in the line
          )
      }).flatten.max  // take the maximum of the four lines
    }

    def maybeGetValueAt(x: Int, y: Int)(implicit grid: Seq[Seq[Int]]): Option[Int] =
      grid.lift(x)
        .flatMap{ _.lift(y) }

    // for each point in the grid...
    (for (rowNumber <- grid.indices; colNumber <- grid.head.indices) yield
      // ... get the maximum X in a line ...
      calculateMaxTotalAt(rowNumber, colNumber)
    ).max // ... and take the maximum from all the points
  }
}

class Problem011(source: String) extends CSVParser{
  parseIntGrid(source)
}

object Problem011 extends App{
  println(Problem011Methods.maxProductOfX(4)(new Problem011("Problem011Grid").grid))
}
