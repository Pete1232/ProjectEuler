package solutions

import integer.IntMethods

object Problem003 extends App{
  private val n = 600851475143L

  println(findLargestPrime(IntMethods.getDivisorPairs(n).tail))

  def findLargestPrime(list: List[(Long, Long)], max: Long = 0): Long = {
    if (!list.isEmpty) {
      val firstEntry = list.head._1
      val secondEntry = list.head._2

      if (IntMethods.isPrime(firstEntry)) {
        findLargestPrime(list.tail, firstEntry)
      }
      else if (IntMethods.isPrime(secondEntry)) {
        findLargestPrime(list.tail, secondEntry)
      }
      else {
        findLargestPrime(list.tail, max)
      }
    }
    else{
      max
    }
  }
}
