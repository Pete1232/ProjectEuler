package integer

/**
  * Contains methods that are applicable to any integer, and likely to be reusable
  */
object IntMethods {
  def getDivisorPairsLong(n: Long, i: Long = 1, divisorList: List[(Long, Long)] = Nil): List[(Long, Long)] ={
    def makeDivisorPair(d: Long, n: Long): Option[(Long, Long)] ={
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
          getDivisorPairsLong(n, i + 1, divisorList :+ pair)
        }
      }
      case None => getDivisorPairsLong(n, i + 1, divisorList)
    }
  }

  /**
    * Returns a list of all possible divisor pairs of a given integer
    *
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
    * Method to determine if the given integer was prime.
    *
    * @param number the given integer. Can be of type byte, short, int or long.
    * @return true if the number was prime and false otherwise
    */
  def isPrime[T](number: T)(implicit n: Numeric[T]): Boolean = {
    def checkPrime(divisor: Long = 2, number: Long): Boolean = {
      if(divisor == number) {
        true
      }
      else if(number%divisor != 0) {
        checkPrime(divisor + 1, number)
      }
      else {
        false
      }
    }
    checkPrime(number = n.toLong(number))
  }
}