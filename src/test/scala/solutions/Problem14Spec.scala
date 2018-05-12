package solutions

import org.junit.Assert.assertEquals
import org.junit.Test
import solutions.Problem014.numbersInCollatzSequence

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Awaitable}

class Problem14Spec {

  private def await[T](awaitable: Awaitable[T]): T = Await.result(awaitable, Duration.Inf)

  @Test
  def methodNumbersInCollatzSequenceTestExamples(): Unit = {
    assertEquals(10L, await(numbersInCollatzSequence(13)()))
    assertEquals(256L, await(numbersInCollatzSequence(134379)()))
    assertEquals(525L, await(numbersInCollatzSequence(837799)()))
  }
}
