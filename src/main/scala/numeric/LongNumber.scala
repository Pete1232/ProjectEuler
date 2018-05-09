package numeric

case class LongNumber(digits: Seq[Int], isNegative: Boolean)

object LongNumber {
  implicit object Numeric extends LongNumberNumeric
}
