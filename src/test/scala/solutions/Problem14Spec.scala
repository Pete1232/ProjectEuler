package solutions

import base.{Generators, UnitTest}
import Problem014._

class Problem14Spec extends UnitTest {

  "nextCollatzNumber" must {
    "multiply an odd number by 3 and add 1" in {
      forAll(Generators.oddNumberGen){ oddNum =>
        nextCollatzNumber(oddNum) mustBe (oddNum * 3) + 1
      }
    }
    "halve an even number" in {
      forAll(Generators.evenNumberGen){ evenNum =>
        nextCollatzNumber(evenNum) mustBe (evenNum / 2)
      }
    }
    "leave 0 unchanged" in {
      nextCollatzNumber(0) mustBe 0
    }
  }
  "numbersInCollatzSequence" must {
    "return 10 for the starting number 13" in {
      numbersInCollatzSequence(13)() mustBe 10
    }
    "work for 134379" in {
      numbersInCollatzSequence(134379)() mustBe 256
    }
    "work for 837799" in {
      numbersInCollatzSequence(837799)() mustBe 525
    }
  }
  "longest chain" must {
    "give the answer" in {
      val start = longestChain()
      val length = numbersInCollatzSequence(start)()
      println(s"Problem14 answer: Longest chain of length $length from start number $start")
    }
  }
}
