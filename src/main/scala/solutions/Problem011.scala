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
}
