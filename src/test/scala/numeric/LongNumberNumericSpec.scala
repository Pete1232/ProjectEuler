package numeric

import numeric.LongNumber.Numeric._
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

  val numSafe: Gen[Int] = Gen.chooseNum(Int.MinValue / 2, Int.MaxValue / 2)

  val posNumSafe: Gen[Int] = Gen.chooseNum(0, Int.MaxValue / 2)

  val negNumSafe: Gen[Int] = Gen.chooseNum(Int.MinValue / 2, 0)

  property("positiveIntPlusPositiveInt") = forAll(posNumSafe, posNumSafe) { (x: Int, y: Int) =>
    plus(fromInt(x), fromInt(y)) == fromInt(x + y)
  }

  property("positiveIntPlusNegativeInt") = forAll(posNumSafe, negNumSafe) { (x: Int, y: Int) =>
    plus(fromInt(x), fromInt(y)) == fromInt(x + y)
  }

  property("negativeIntPlusPositiveInt") = forAll(negNumSafe, posNumSafe) { (x: Int, y: Int) =>
    plus(fromInt(x), fromInt(y)) == fromInt(x + y)
  }

  property("negativeIntPlusNegativeInt") = forAll(negNumSafe, negNumSafe) { (x: Int, y: Int) =>
    plus(fromInt(x), fromInt(y)) == fromInt(x + y)
  }

  property("intPlusInt") = forAll(numSafe, numSafe) { (x: Int, y: Int) =>
    plus(fromInt(x), fromInt(y)) == fromInt(x + y)
  }

  property("positiveIntMinusPositiveInt") = forAll(posNumSafe, posNumSafe) { (x: Int, y: Int) =>
    minus(fromInt(x), fromInt(y)) == fromInt(x - y)
  }

  property("positiveIntMinusNegativeInt") = forAll(posNumSafe, negNumSafe) { (x: Int, y: Int) =>
    minus(fromInt(x), fromInt(y)) == fromInt(x - y)
  }

  property("negativeIntMinusPositiveInt") = forAll(negNumSafe, posNumSafe) { (x: Int, y: Int) =>
    minus(fromInt(x), fromInt(y)) == fromInt(x - y)
  }

  property("negativeIntMinusNegativeInt") = forAll(negNumSafe, negNumSafe) { (x: Int, y: Int) =>
    minus(fromInt(x), fromInt(y)) == fromInt(x - y)
  }

  property("intMinusInt") = forAll(numSafe, numSafe) { (x: Int, y: Int) =>
    minus(fromInt(x), fromInt(y)) == fromInt(x - y)
  }

  property("longNumbersExpressionsMustBeUnique") = throws(classOf[IllegalArgumentException]) {
    LongNumber(Seq(0, 1), isNegative = false)
  }

  val associativeAddition: Prop = forAll(numSafe, numSafe, numSafe) { (x: Int, y: Int, z: Int) =>
    plus(plus(fromInt(x), fromInt(y)), fromInt(z)) == plus(fromInt(x), plus(fromInt(y), fromInt(z)))
  }

  val commutativeAddition: Prop = forAll(numSafe, numSafe) { (x: Int, y: Int) =>
    plus(fromInt(x), fromInt(y)) == plus(fromInt(y), fromInt(x))
  }

  val additiveIdentity: Prop = forAll(numSafe) { y: Int =>
    plus(fromInt(y), zero) == fromInt(y)
  }

  val additiveInverses: Prop = forAll(numSafe) { x: Int =>
    plus(fromInt(x), negate(fromInt(x))) == zero
  }

  property("longNumbersMustFormAnAbelianGroupUnderAddition") =
    all(associativeAddition, commutativeAddition, additiveIdentity, additiveInverses)
}
