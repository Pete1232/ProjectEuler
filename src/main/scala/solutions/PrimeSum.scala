package solutions

import integer.IntMethods

object PrimeSum extends App {
  println(primeAdder(2, args(0).toInt, 0))
  def primeAdder(j: Long, end: Long, currentTotal: Long): Long = {
    val i = 2*j-1
    if(IntMethods.isPrime(i)){
      if(i>=end){
        currentTotal
      }
      else{
        primeAdder(i+1, end, currentTotal+i)
      }
    }
    else{
      primeAdder(i+1, end, currentTotal)
    }
  }
}