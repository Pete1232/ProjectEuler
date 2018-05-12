package numeric

case class LongNumber(digits: Seq[Int], isNegative: Boolean) {
  // require the number is not padded to guarantee uniqueness
  // the getOrElse covers the Nil (i.e. Zero) case - the choice of 1 is arbitrary (it is non-zero)
  require(
    digits.headOption.getOrElse(1) != 0,
    s"""
       |    Digits $digits started with a 0 digit. This is not allowed to guarantee uniqueness.
       |    Note the number 0 should be represented by a Nil digits value.
     """.stripMargin
  )

  def toBigInt: BigInt = {
    val numberAsString: String = {
      val abs: String = digits.mkString("")
      if (digits.isEmpty) "0" else if (isNegative) s"-$abs" else abs
    }
    BigInt(numberAsString, radix = 10)
  }
}

object LongNumber {

  implicit object Numeric extends LongNumberNumeric

  def fromBigInt(x: BigInt): LongNumber = {
    val digits: Array[Int] = x.toString().toCharArray.map(_.asDigit)
    if (x.signum > 0) {
      LongNumber(digits, isNegative = false)
    } else if (x.signum < 0) {
      LongNumber(digits.tail, isNegative = true) // first digit is -1 for negative BigInt
    } else { // x == 0
      LongNumber(Nil, isNegative = false)
    }
  }
}
