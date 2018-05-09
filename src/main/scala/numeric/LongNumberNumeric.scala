package numeric

trait Test

trait LongNumberNumeric extends Numeric[LongNumber] {

  override def plus(x: LongNumber, y: LongNumber): LongNumber = ???

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
        .reverse
    }

    LongNumber(longValue, isNegative)
  }

  override def toInt(x: LongNumber): Int = ???

  override def toLong(x: LongNumber): Long = ???

  override def toFloat(x: LongNumber): Float = ???

  override def toDouble(x: LongNumber): Double = ???

  override def compare(x: LongNumber, y: LongNumber): Int = ???
}
