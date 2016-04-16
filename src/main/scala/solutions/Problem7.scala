package solutions

import integer.IntMethods

object Problem7 extends App{
  println(nthPrime(target = args(0).toInt))

  def nthPrime(n: Int = 1, number: Int = 2, target: Int): Int ={
    if(IntMethods.isPrime(number = number)){
      if(n == target)
        number
      else
        nthPrime(n+1, number+1, target)
    }
    else
      nthPrime(n, number+1, target)
  }
}
