package integer

import org.junit.Assert.assertEquals
import org.junit.Test

class IntMethodsSpec extends IntMethods {

  val primeByte: Byte = 7
  val primeShort: Short = 17669
  val primeInt: Int = 101921
  val primeLong: Long = 101921L
  val compByte: Byte = 9
  val compShort: Short = 17671
  val compInt: Int = 101923
  val compLong: Long = 101923L

  @Test
  def methodIsPrimeShouldIdentifyAPrime(): Unit = {
    assertEquals(true, isPrime(primeByte))
    assertEquals(true, isPrime(primeShort))
    assertEquals(true, isPrime(primeInt))
    assertEquals(true, isPrime(primeLong))
  }

  @Test
  def methodIsPrimeShouldIdentifyANonPrime(): Unit = {
    assertEquals(false, isPrime(compByte))
    assertEquals(false, isPrime(compShort))
    assertEquals(false, isPrime(compInt))
    assertEquals(false, isPrime(compLong))
  }

  @Test
  def methodGetDivisorPairsShouldReturnAListOfDivisors(): Unit = {
    val listByte: List[(Byte, Byte)] = List[(Byte, Byte)]((1, 9), (3, 3))
    assertEquals(listByte, getDivisorPairs(compByte, 1.toByte))

    val listShort: List[(Short, Short)] = List[(Short, Short)]((1, 17671), (41, 431))
    assertEquals(listShort, getDivisorPairs(compShort, 1.toShort))

    val listInt: List[(Int, Int)] = List[(Int, Int)]((1, 101923), (227, 449))
    assertEquals(listInt, getDivisorPairs(compInt, 1))

    val listLong: List[(Long, Long)] = List[(Long, Long)]((1L, 101923L), (227L, 449L))
    assertEquals(listLong, getDivisorPairs(compLong, 1L))
  }

  @Test
  def methodDivideShouldReturnADivisionResultAsSome(): Unit = {
    assertEquals(Some(1), divide(2, 2))
    assertEquals(Some(2), divide(5, 10))
    assertEquals(Some(8), divide(2, 16))
    assertEquals(Some(5), divide(3, 15))
  }

  @Test
  def methodDivideShouldReturnNoneIfDivisionIsNotExact(): Unit = {
    assertEquals(None, divide(5, 11))
    assertEquals(None, divide(2, 17))
    assertEquals(None, divide(3, 16))
  }

  @Test
  def methodCalculatePrimeFactorsShouldReturnPrimeFactorsInAList(): Unit = {
    assertEquals(List(2, 2), calculatePrimeFactors(4))
    assertEquals(List(5), calculatePrimeFactors(5))
    assertEquals(List(2, 2, 3), calculatePrimeFactors(12))
    assertEquals(List(2, 2, 2, 2, 2, 2), calculatePrimeFactors(64))
  }

  @Test
  def methodLCMShouldReturnLowestMultipleOfTwoInt(): Unit = {
    assertEquals(2, lcm(2, 2))
    assertEquals(20, lcm(4, 5))
    assertEquals(65, lcm(5, 13))
    assertEquals(276, lcm(23, 12))
    assertEquals(64, lcm(16, 64))
  }

  @Test
  def methodLCMShouldReturnLowestMultipleOfAList(): Unit = {
    assertEquals(2, lcm(List(2, 2)))
    assertEquals(60, lcm(List(4, 5, 6)))
    assertEquals(64, lcm(List(16, 64)))
    assertEquals(2520, lcm(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)))
  }
}
