package numeric

import cats.implicits._
import numeric.LongNumber._
import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Gen, Properties}

class LongNumberMonoidSpec extends Properties("LongNumberMonoidSpec") {

  val smallListGen: Gen[List[BigInt]] = Gen.resize(5, Gen.listOf(Arbitrary.arbBigInt.arbitrary))

  // quick demo to show the monoid works
  property("multiplyASequenceOfBigInt") = forAll(smallListGen) { xs: List[BigInt] =>
    val longNumbers: List[LongNumber] = xs.map(LongNumber.fromBigInt)
    longNumbers.foldMap(identity) == longNumbers.product
  }
}
