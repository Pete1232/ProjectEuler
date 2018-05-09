package numeric

case class LongNumber(digits: Seq[Int], isNegative: Boolean) {
  // require the number is not padded to guarantee uniqueness
  // the getOrElse covers the Nil (i.e. Zero) case - the choice of 1 is arbitrary (it is non-zero)
  require(digits.headOption.getOrElse(1) != 0)
}

object LongNumber {

  implicit object Numeric extends LongNumberNumeric

}
