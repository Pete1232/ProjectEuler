package solutions

import integer.IntMethods

object Problem3 extends App{
  val n = 600851475143L

  //noinspection ScalaStyle
  println(findLargestPrime(IntMethods.getDivisorPairsLong(n).tail))

  private def findLargestPrime(list: List[(Long, Long)], max: Long = 0): Long = {
    if (!list.isEmpty) {
      val currentInt = list.head._1
      if (IntMethods.isPrime(currentInt)) {
        findLargestPrime(list.tail, currentInt)
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
