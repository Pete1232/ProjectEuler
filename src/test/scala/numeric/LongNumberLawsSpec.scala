package numeric

import cats._
import cats.kernel.laws.discipline.MonoidTests
import cats.tests.CatsSuite
import numeric.LongNumber._
import org.scalacheck.Arbitrary

class LongNumberLawsSpec extends CatsSuite {

  implicit val arbitraryLongNumber: Arbitrary[LongNumber] = Arbitrary(Arbitrary.arbBigInt.arbitrary.map(LongNumber.fromBigInt))

  implicit def eqTree: Eq[LongNumber] = Eq.instance(_ == _)

  checkAll("LongNumber.MonoidLaws", MonoidTests[LongNumber].monoid)
}
