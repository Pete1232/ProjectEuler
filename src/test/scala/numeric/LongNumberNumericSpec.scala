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

  val numSafeForAddition: Gen[Int] = Gen.chooseNum(Int.MinValue / 2, Int.MaxValue / 2)

  val posNumSafeForAddition: Gen[Int] = Gen.chooseNum(0, Int.MaxValue / 2)

  val negNumSafeForAddition: Gen[Int] = Gen.chooseNum(Int.MinValue / 2, 0)

  property("positiveIntPlusPositiveInt") = forAll(posNumSafeForAddition, posNumSafeForAddition) { (x: Int, y: Int) =>
    plus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x + y)
  }

  property("positiveIntPlusNegativeInt") = forAll(posNumSafeForAddition, negNumSafeForAddition) { (x: Int, y: Int) =>
    plus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x + y)
  }

  property("negativeIntPlusPositiveInt") = forAll(negNumSafeForAddition, posNumSafeForAddition) { (x: Int, y: Int) =>
    plus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x + y)
  }

  property("negativeIntPlusNegativeInt") = forAll(negNumSafeForAddition, negNumSafeForAddition) { (x: Int, y: Int) =>
    plus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x + y)
  }

  property("intPlusInt") = forAll(numSafeForAddition, numSafeForAddition) { (x: Int, y: Int) =>
    plus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x + y)
  }

  property("positiveIntMinusPositiveInt") = forAll(posNumSafeForAddition, posNumSafeForAddition) { (x: Int, y: Int) =>
    minus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x - y)
  }

  property("positiveIntMinusNegativeInt") = forAll(posNumSafeForAddition, negNumSafeForAddition) { (x: Int, y: Int) =>
    minus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x - y)
  }

  property("negativeIntMinusPositiveInt") = forAll(negNumSafeForAddition, posNumSafeForAddition) { (x: Int, y: Int) =>
    minus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x - y)
  }

  property("negativeIntMinusNegativeInt") = forAll(negNumSafeForAddition, negNumSafeForAddition) { (x: Int, y: Int) =>
    minus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x - y)
  }

  property("intMinusInt") = forAll(numSafeForAddition, numSafeForAddition) { (x: Int, y: Int) =>
    minus(fromBigInt(x), fromBigInt(y)) == fromBigInt(x - y)
  }

  //  property("positiveBigIntTimesPositiveInt") = forAll(Arbitrary.arbBigInt.arbitrary, Arbitrary.arbBigInt.arbitrary) { (x: BigInt, y: BigInt) =>
  //    times(fromBigInt(x), fromBigInt(y)) == fromBigInt(x * y)
  //  }

  property("longNumbersExpressionsMustBeUnique") = throws(classOf[IllegalArgumentException]) {
    LongNumber(Seq(0, 1), isNegative = false)
  }

  val associativeAddition: Prop = forAll(numSafeForAddition, numSafeForAddition, numSafeForAddition) { (x: Int, y: Int, z: Int) =>
    plus(plus(fromBigInt(x), fromBigInt(y)), fromBigInt(z)) == plus(fromBigInt(x), plus(fromBigInt(y), fromBigInt(z)))
  }

  val commutativeAddition: Prop = forAll(numSafeForAddition, numSafeForAddition) { (x: Int, y: Int) =>
    plus(fromBigInt(x), fromBigInt(y)) == plus(fromBigInt(y), fromBigInt(x))
  }

  val additiveIdentity: Prop = forAll(numSafeForAddition) { y: Int =>
    plus(fromBigInt(y), zero) == fromBigInt(y)
  }

  val additiveInverses: Prop = forAll(numSafeForAddition) { x: Int =>
    plus(fromBigInt(x), negate(fromBigInt(x))) == zero
  }

  property("longNumbersMustFormAnAbelianGroupUnderAddition") =
    all(associativeAddition, commutativeAddition, additiveIdentity, additiveInverses)
}
