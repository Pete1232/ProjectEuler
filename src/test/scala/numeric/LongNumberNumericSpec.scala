package numeric

import numeric.LongNumber.Numeric._
import numeric.LongNumber.fromBigInt
import org.scalacheck.Prop.{all, forAll, propBoolean, throws}
import org.scalacheck.{Gen, Prop, Properties}

class LongNumberNumericSpec extends Properties("LongNumberNumericSpec") {
  property("zeroCheck") = propBoolean(LongNumber(Nil, isNegative = false) == zero)

  property("oneCheck") = propBoolean(LongNumber(Seq(1), isNegative = false) == one)

  property("negativeOneCheck") = propBoolean(LongNumber(Seq(1), isNegative = true) == fromInt(-1))

  property("tenCheck") = propBoolean(LongNumber(Seq(1, 0), isNegative = false) == fromInt(10))

  property("minusTenCheck") = propBoolean(LongNumber(Seq(1, 0), isNegative = true) == fromInt(-10))

  property("maxIntCheck") = propBoolean(LongNumber(Seq(2, 1, 4, 7, 4, 8, 3, 6, 4, 7), isNegative = false) == fromInt(Int.MaxValue))

  property("minIntCheck") = propBoolean(LongNumber(Seq(2, 1, 4, 7, 4, 8, 3, 6, 4, 8), isNegative = true) == fromInt(Int.MinValue))

  property("fromBigIntAndToBigInt") = forAll { x: BigInt =>
    fromBigInt(x).toBigInt == x
  }

  val safeIntForAddition: Gen[Int] = Gen.chooseNum(Int.MinValue / 2, Int.MaxValue / 2)

  property("intPlusInt") = forAll(safeIntForAddition, safeIntForAddition) { (x: Int, y: Int) =>
    plus(fromInt(x), fromInt(y)) == fromInt(x + y)
  }

  property("intMinusInt") = forAll(safeIntForAddition, safeIntForAddition) { (x: Int, y: Int) =>
    minus(fromInt(x), fromInt(y)) == fromInt(x - y)
  }

  property("bigIntPlusBigInt") = forAll { (x: BigInt, y: BigInt) =>
    plus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x + y)
  }

  property("bigIntMinusBigInt") = forAll { (x: BigInt, y: BigInt) =>
    minus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x - y)
  }

  property("longNumbersExpressionsMustBeUnique") = throws(classOf[IllegalArgumentException]) {
    LongNumber(Seq(0, 1), isNegative = false)
  }

  val associativeAddition: Prop = forAll { (x: BigInt, y: BigInt, z: BigInt) =>
    plus(plus(fromBigInt(x), fromBigInt(y)), fromBigInt(z)) == plus(fromBigInt(x), plus(fromBigInt(y), fromBigInt(z)))
  }

  val commutativeAddition: Prop = forAll { (x: BigInt, y: BigInt) =>
    plus(fromBigInt(x), fromBigInt(y)) == plus(fromBigInt(y), fromBigInt(x))
  }

  val additiveIdentity: Prop = forAll { y: BigInt =>
    plus(fromBigInt(y), zero) == fromBigInt(y)
  }

  val additiveInverses: Prop = forAll { x: BigInt =>
    plus(fromBigInt(x), negate(fromBigInt(x))) == zero
  }

  property("longNumbersMustFormAnAbelianGroupUnderAddition") =
    all(associativeAddition, commutativeAddition, additiveIdentity, additiveInverses)
}
