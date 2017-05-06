package solutions

import scala.annotation.tailrec

object Problem014 {
  def nextCollatzNumber(num: Long): Long =
    if (num % 2 == 0) num / 2 else num * 3 + 1

  @tailrec
  def numbersInCollatzSequence(startNum: Long)(num: Long = startNum, count: Long = 1): Long = {
    if (num == 1) {
      count
    } else {
      numbersInCollatzSequence(startNum)(
        nextCollatzNumber(num),
        count + 1
      )
    }
  }

  @tailrec
  def longestChain(num: Long = 1, longestChainStart: Long = 1, end: Long = 1000000): Long = {
    if (num <= end) {
      if(!doNotCheck(num, end)){
        val lengthOfThisChain = numbersInCollatzSequence(num)()
        val lengthOFLongestChain = numbersInCollatzSequence(longestChainStart)()
        if (lengthOfThisChain > lengthOFLongestChain) {
          longestChain(num + 1, num)
        } else {
          longestChain(num + 1, longestChainStart)
        }
      } else {
        longestChain(num + 1, longestChainStart)
      }
    } else {
      longestChainStart
    }
  }

  def doNotCheck(num: Long, max: Long): Boolean = {
    val rule1 = num % 2 == 0 && (2 * num) < max
    val rule2 = (num - 1) % 3 == 0 && ((num - 1)/3) % 2 == 1
    rule1 || rule2
  }
}
