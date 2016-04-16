package integer

/**
  * Contains methods that are applicable to any integer, and likely to be reusable
  */
  object IntMethods {

  /**
    * Returns a list of all possible divisor pairs of a given integer
    *
    * @param n the given integer
    * @param i a number to iterate, starting at 1
    * @param divisorList the current list of found divisors to iterate, starting at Nil
    * @return the complete list of pairs
    */
    def getDivisorPairs[T](n: T, i: T = 1, divisorList: List[(T, T)] = Nil)(implicit num: Numeric[T]): List[(T, T)] ={
      def makeDivisorPair(d: Long, n: Long): Option[(T, T)] ={
        if(n % d == 0) {
          Some(d.asInstanceOf[T], (n / d).asInstanceOf[T])
        }
        else {
          None
        }
      }
      val pair = makeDivisorPair(num.toLong(i), num.toLong(n))

      pair match {
        case Some(pair) => {
          if(divisorList.contains(pair.swap)){
            divisorList
          }
          else{
            getDivisorPairs(n, num.plus(i, num.one), divisorList :+ pair.copy(pair._1, pair._2))
          }
        }
        case None => getDivisorPairs(n, num.plus(i, num.one), divisorList)
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