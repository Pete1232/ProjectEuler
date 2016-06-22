package solutions

import integer.IntMethods

object Problem010 extends App with IntMethods{
  private val end = 2000000
  println(primeAdder(end = end))
  def primeAdder(j: Long = 2, end: Long, currentTotal: Long = 2): Long = {
    val i = 2*j-1
    if(isPrime(i)){
      if(i>=end){
        currentTotal
      }
      else{
        primeAdder(j + 1, end, currentTotal + i)
      }
    }
    else{
      primeAdder(j + 1, end, currentTotal)
    }
  }
}