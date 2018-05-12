package solutions

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

object Problem014 extends App {
  def nextCollatzNumber(num: Long): Long =
    if (num % 2 == 0) num / 2 else num * 3 + 1

  @tailrec
  def numbersInCollatzSequence(startNum: Long)(num: Long = startNum, count: Long = 1): Future[Long] = {
    if (num == 1) {
      Future(count)
    } else {
      numbersInCollatzSequence(startNum)(
        nextCollatzNumber(num),
        count + 1
      )
    }
  }

  def longestChain(num: Long = 1, longestChainStart: Long = 1, longestChainLength: Long = 1, end: Long = 1000000): Future[Long] = {
    if (num <= end) {
      if (!doNotCheck(num, end)) {
        val lengthOfThisChain: Future[Long] = numbersInCollatzSequence(num)()
        val lengthOFLongestChain: Future[Long] = Future(longestChainLength)

        lengthOfThisChain.flatMap { current =>
          lengthOFLongestChain.flatMap { longest =>
            if (current > longest) {
              longestChain(num + 1, num, current)
            } else {
              longestChain(num + 1, longestChainStart, longestChainLength)
            }
          }
        }
      } else {
        longestChain(num + 1, longestChainStart, longestChainLength)
      }
    } else {
      Future(longestChainStart)
    }
  }

  def doNotCheck(num: Long, max: Long): Boolean = {
    val rule1: Boolean = num % 2 == 0 && (2 * num) < max
    val rule2: Boolean = (num - 1) % 3 == 0 && ((num - 1) / 3) % 2 == 1
    rule1 || rule2
  }

  val start: Future[Long] = longestChain()
  val length: Future[(Long, Long)] = start.flatMap(s => numbersInCollatzSequence(s)().map(res => (s, res)))

  println(Await.result(
    length.map { len =>
      println(s"Problem14 answer: Longest chain of length ${len._2} from start number ${len._1}")
    },
    Duration.Inf))
}
