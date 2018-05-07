package solutions

import integer.IntMethods

object Problem010 extends App with IntMethods {

  def primeAdder(j: Long = 2, end: Long, currentTotal: Long = 2): Long = {
    val i: Long = 2 * j - 1
    if (isPrime(i)) {
      if (i >= end) {
        currentTotal
      }
      else {
        primeAdder(j + 1, end, currentTotal + i)
      }
    }
    else {
      primeAdder(j + 1, end, currentTotal)
    }
  }
}
