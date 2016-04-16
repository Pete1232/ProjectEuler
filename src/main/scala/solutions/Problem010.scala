package solutions

import integer.IntMethods

object Problem010 extends App {
  println(primeAdder(2, 10))
  def primeAdder(j: Long, end: Long, currentTotal: Long = 2): Long = {
    val i = 2*j-1
    if(IntMethods.isPrime(i)){
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