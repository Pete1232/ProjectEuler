package solutions

import base.Generators
import org.scalacheck.Prop.forAll
import org.scalacheck.{Gen, Properties}
import solutions.Problem014.nextCollatzNumber

class CollatzProperties extends Properties("Collatz numbers") {

  property("zero") = forAll(Gen.const(0)) { zero: Int =>
    0L == nextCollatzNumber(zero)
  }

  property("odd") = forAll(Generators.oddNumberGen) { oddNum: Int =>
    nextCollatzNumber(oddNum) == (oddNum * 3) + 1
  }

  property("even") = forAll(Generators.evenNumberGen) { evenNum: Int =>
    nextCollatzNumber(evenNum) == (evenNum / 2)
  }
}
