package solutions

import numeric.NumericMethods

object Problem003 extends App with NumericMethods {
  private val n = 600851475143L

  println(findLargestPrime(getDivisorPairs(n, 1L).tail))

  def findLargestPrime(list: List[(Long, Long)], max: Long = 0): Long = {
    if (list.nonEmpty) {
      val firstEntry: Long = list.head._1
      val secondEntry: Long = list.head._2

      if (isPrime(firstEntry)) {
        findLargestPrime(list.tail, firstEntry)
      }
      else if (isPrime(secondEntry)) {
        findLargestPrime(list.tail, secondEntry)
      }
      else {
        findLargestPrime(list.tail, max)
      }
    }
    else {
      max
    }
  }
}
