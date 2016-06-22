package solutions

import integer.IntMethods

object Problem007 extends App with IntMethods{
  private val stop = 1001
  println(nthPrime(target = stop))

  def nthPrime(n: Int = 1, number: Int = 2, target: Int): Int ={
    if(isPrime(number = number)){
      if(n == target) {
        number
      }
      else {
        nthPrime(n + 1, number + 1, target)
      }
    }
    else {
      nthPrime(n, number + 1, target)
    }
  }
}
