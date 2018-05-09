package numeric

import numeric.LongNumber.Numeric._
import org.scalacheck.Prop.propBoolean
import org.scalacheck.Properties

class LongNumberNumericSpec extends Properties("Long number numeric") {
  property("zero value check") = propBoolean(LongNumber(Nil, isNegative = false) == zero)

  property("one value check") = propBoolean(LongNumber(Seq(1), isNegative = false) == one)

  property("negative one value check") = propBoolean(LongNumber(Seq(1), isNegative = true) == fromInt(-1))

  property("ten value check") = propBoolean(LongNumber(Seq(0, 1), isNegative = false) == fromInt(10))

  property("minus ten value check") = propBoolean(LongNumber(Seq(0, 1), isNegative = true) == fromInt(-10))

  property("max int value check") = propBoolean(LongNumber(Seq(7, 4, 6, 3, 8, 4, 7, 4, 1, 2), isNegative = false) == fromInt(Int.MaxValue))

  property("min int value check") = propBoolean(LongNumber(Seq(8, 4, 6, 3, 8, 4, 7, 4, 1, 2), isNegative = true) == fromInt(Int.MinValue))
}
