package solutions

import utils.CSVParser

object Problem013 extends App with CSVParser {
  parseStringList("Problem013")

  def sumLastDigit(numbers: Seq[String]): Int = {
    numbers
      .reduce { (a: String, b: String) =>
        (a.last.asDigit + b.last.asDigit).toString
      }
      .toInt
  }
}
