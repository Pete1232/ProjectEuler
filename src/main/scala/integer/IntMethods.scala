package integer

/**
  * Contains methods that are applicable to any integer, and likely to be reusable
  */
object IntMethods {
  /**
    * Returns a list of all possible divisor pairs of a given integer
    * @param n the given integer
    * @param i a number to iterate, starting at 1
    * @param divisorList the current list of found divisors to iterate, starting at Nil
    * @return the complete list of pairs
    */
  def getDivisorPairs(n: Int, i: Int = 1, divisorList: List[(Int, Int)] = Nil): List[(Int, Int)] ={
    def makeDivisorPair(d: Int, n: Int): Option[(Int, Int)] ={
      if(n % d == 0)
        Some(d, n/d)
      else
        None
    }
    val pair = makeDivisorPair(i, n)

    pair match {
      case Some(pair) => {
        if(divisorList.contains(pair.swap)){
          divisorList
        }
        else{
          getDivisorPairs(n, i + 1, divisorList :+ pair)
        }
      }
      case None => getDivisorPairs(n, i + 1, divisorList)
    }
  }

  /**
    * Returns true if a given integer is prime
    * @param number the given integer
    * @return true is number was prime and false otherwise
    */
  def isPrime(number: Long) = {
    def checkPrime(divisor: Long = 2, number: Long): Boolean = {
      if(divisor == number)
        true
      else if(number%divisor != 0)
        checkPrime(divisor+1, number)
      else
        false
    }
    checkPrime(number = number)
  }
}