package numeric

import numeric.LongNumber.Numeric._
import org.scalacheck.Prop.{forAll, propBoolean}
import org.scalacheck.{Gen, Properties}

class LongNumberNumericSpec extends Properties("Long number numeric") {
  property("zero value check") = propBoolean(LongNumber(Nil, isNegative = false) == zero)

  property("one value check") = propBoolean(LongNumber(Seq(1), isNegative = false) == one)

  property("negative one value check") = propBoolean(LongNumber(Seq(1), isNegative = true) == fromInt(-1))

  property("ten value check") = propBoolean(LongNumber(Seq(1, 0), isNegative = false) == fromInt(10))

  property("minus ten value check") = propBoolean(LongNumber(Seq(1, 0), isNegative = true) == fromInt(-10))

  property("max int value check") = propBoolean(LongNumber(Seq(2, 1, 4, 7, 4, 8, 3, 6, 4, 7), isNegative = false) == fromInt(Int.MaxValue))

  property("min int value check") = propBoolean(LongNumber(Seq(2, 1, 4, 7, 4, 8, 3, 6, 4, 8), isNegative = true) == fromInt(Int.MinValue))

  property("positive int addition") = forAll(Gen.posNum[Int], Gen.posNum[Int]) { (x: Int, y: Int) =>
    plus(fromInt(x), fromInt(y)) == fromInt(x + y)
  }

  property("negative int addition") = forAll(Gen.negNum[Int], Gen.negNum[Int]) { (x: Int, y: Int) =>
    plus(fromInt(x), fromInt(y)) == fromInt(x + y)
  }
}
