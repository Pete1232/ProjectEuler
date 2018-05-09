package numeric

trait Test

trait LongNumberNumeric extends Numeric[LongNumber] {

  override def plus(x: LongNumber, y: LongNumber): LongNumber = {

    val preparedSequence: Seq[(Int, Int)] = (0, 0) +: x.digits.reverse.zipAll(y.digits.reverse, 0, 0).reverse

    val result: Seq[Int] = {
      preparedSequence
        // add up leaving addition results as-is
        .scanRight(0) { (thisAddition, carriedOver) =>
        (carriedOver / 10) + thisAddition._1 + thisAddition._2
      }
        // drop any extra digits at the start (will happen when x + y >= 10)
        .dropWhile(_ == 0)
        // drop the 0 added by the scan
        .dropRight(1)
        // keep only the last digit in each position
        .map(_ % 10)
    }
    LongNumber(result, isNegative = x.isNegative && y.isNegative)
  }

  override def minus(x: LongNumber, y: LongNumber): LongNumber = ???

  override def times(x: LongNumber, y: LongNumber): LongNumber = ???

  override def negate(x: LongNumber): LongNumber = ???

  override def fromInt(x: Int): LongNumber = {

    val numberAsString: String = x.toString

    val (absValue, isNegative) = if (numberAsString.head == '-') (numberAsString.tail, true) else (numberAsString, false)

    val longValue: Seq[Int] = {
      absValue.toCharArray
        .map(_.asDigit)
        .dropWhile(_ == 0)
    }

    LongNumber(longValue, isNegative)
  }

  override def toInt(x: LongNumber): Int = ???

  override def toLong(x: LongNumber): Long = ???

  override def toFloat(x: LongNumber): Float = ???

  override def toDouble(x: LongNumber): Double = ???

  override def compare(x: LongNumber, y: LongNumber): Int = ???
}
