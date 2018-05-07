package solutions

import org.junit.Assert.assertEquals
import org.junit.Test
import solutions.Problem014.{longestChain, nextCollatzNumber, numbersInCollatzSequence}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Awaitable, Future}

class Problem14Spec {

  private def await[T](awaitable: Awaitable[T]): T = Await.result(awaitable, Duration.Inf)

  @Test
  def methodNextCollatzNumberMustReturnTheNextCorrectly(): Unit = {
    assertEquals(0L, nextCollatzNumber(0))
  }

  @Test
  def methodNumbersInCollatzSequenceTestExamples(): Unit = {
    assertEquals(10L, await(numbersInCollatzSequence(13)()))
    assertEquals(256L, await(numbersInCollatzSequence(134379)()))
    assertEquals(525L, await(numbersInCollatzSequence(837799)()))
  }

  @Test
  def problem014Answer(): Unit = {
    val start: Future[Long] = longestChain()
    val length: Future[(Long, Long)] = start.flatMap(s => numbersInCollatzSequence(s)().map(res => (s, res)))

    await {
      length.map { len =>
        println(s"Problem14 answer: Longest chain of length ${len._2} from start number ${len._1}")
      }
    }
  }

  //  "nextCollatzNumber" must {
  //    "multiply an odd number by 3 and add 1" in {
  //      forAll(Generators.oddNumberGen){ oddNum =>
  //        nextCollatzNumber(oddNum) mustBe (oddNum * 3) + 1
  //      }
  //    }
  //    "halve an even number" in {
  //      forAll(Generators.evenNumberGen){ evenNum =>
  //        nextCollatzNumber(evenNum) mustBe (evenNum / 2)
  //      }
  //    }
}
