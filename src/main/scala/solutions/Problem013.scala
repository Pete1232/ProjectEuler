package solutions

import numeric.LongNumber
import utils.CSVParser

object Problem013 extends App with CSVParser {
  parseStringList("Problem013")

  val res = list
    .map(line => LongNumber(line.head.toCharArray.map(_.asDigit), isNegative = false))
    .sum

  println(res.digits.take(10).mkString)
}
