package integer

import scala.annotation.tailrec

/**
  * Contains methods that are applicable to any integer, and likely to be reusable
  */
  trait IntMethods {

  /**
    * Returns a list of all possible divisor pairs of a given integer
    *
    * @param n the given integer
    * @param i a number to iterate, starting at 1
    * @param divisorList the current list of found divisors to iterate, starting at Nil
    * @return the complete list of pairs
    */
    @tailrec
    final def getDivisorPairs[T](n: T, i: T = 1, divisorList: List[(T, T)] = Nil)(implicit num: Numeric[T]): List[(T, T)] ={
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
    @tailrec
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

  /**
    * A generic division method to make up for the lack of support in the Scala Numeric class
    *
    * @param divisor the number to divide by.
    * @param number the number to divide
    * @return Some(number/divisor) if number was divisible by divisor, and None otherwise
    */
  def divide[T](divisor: T, number: T)(implicit n: Numeric[T]): Option[T] = {
    @tailrec
    def divideLoop(d: T, x: T, i: T = n.one): Option[T] = {
      if(n.gt(n.times(d, i), x)){
        None
      }
      else if(n.times(i, d) == x){
        Some(i)
      }
      else{
        divideLoop(d, x, n.plus(i, n.one))
      }
    }
    divideLoop(divisor, number)
  }

  /**
    * Returns a list containing all prime factors of a number
    *
    * @param x the number to factorise
    * @return a list of all prime factors of x
    */
  def calculatePrimeFactors[T](x: T)(implicit n: Numeric[T]): List[T] = {
    @tailrec
    def callbackLoop(divisor: T, number: T, list: List[T] = List()): List[T] = {
      if (n.gt(divisor, number)) {
        list
      }
      else {
        val divisionResult = divide(divisor, number)
        divisionResult match {
          case Some(_) => callbackLoop(divisor, divisionResult.get, list :+ divisor)
          case None => callbackLoop(n.plus(divisor, n.one), number, list)
        }
      }
    }
    callbackLoop(n.plus(n.one, n.one), x)
  }

  /**
    * Builds on the calculatePrimeFactors method to find the lcm of two numbers
    *
    * @param x the first number
    * @param y the second number
    * @return the lcm of x and y
    */
  def lcm[T](x: T, y: T)(implicit n: Numeric[T]): T = {
    val factorsOfX = calculatePrimeFactors(x)
    val factorsOfY = calculatePrimeFactors(y)
    val mergedFactors = factorsOfX ++ factorsOfY.diff(factorsOfX)
    mergedFactors.product
  }

  /**
    * Calculates the lcm of an arbitrarily sized list of numbers
    *
    * @param list the list of numbers
    * @return the lcm of all numbers in list
    */
  def lcm[T](list: List[T])(implicit n: Numeric[T]): T = {
    @tailrec
    def callbackLoop(list: List[T]): T = {
      if(list.size == 1){
        list.head
      }
      else {
        val x = list.head
        val y = list.last
        callbackLoop(list.drop(1).dropRight(1).::(lcm(x, y)))
      }
    }
    callbackLoop(list)
  }
}