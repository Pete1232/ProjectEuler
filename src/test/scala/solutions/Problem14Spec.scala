package solutions

import base.{Generators, UnitTest}
import Problem014._

import scala.concurrent.ExecutionContext.Implicits.global

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
      numbersInCollatzSequence(13)().map(_ mustBe 10)
    }
    "work for 134379" in {
      numbersInCollatzSequence(134379)().map(_  mustBe 256)
    }
    "work for 837799" in {
      numbersInCollatzSequence(837799)().map(_  mustBe 525)
    }
  }
  "longest chain" must {
    "give the answer" in {
      val start = longestChain()
      val length = start.flatMap(s => numbersInCollatzSequence(s)().map(res => (s, res)))

      length.map { len =>
        println(s"Problem14 answer: Longest chain of length ${len._2} from start number ${len._1}")
      }.map(_ mustBe ((): Unit))
    }
  }
}
