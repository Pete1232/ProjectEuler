package solutions

import org.junit.Assert.assertEquals
import org.junit.Test

class ProblemSpec {

  @Test
  def problem001Test(): Unit = {
    val end = 10
    assertEquals(23, Problem001.addToSumUntilEnd(end))
  }

  @Test
  def problem002Test(): Unit = {
    val end = 100
    assertEquals(44, Problem002.addToSumUntilEnd(end))
  }

  @Test
  def problem003Test(): Unit = {
    val list = List((3L, 7L), (5L, 26L), (11L, 20L))
    assertEquals(11L, Problem003.findLargestPrime(list))
    val flippedList = List((7L, 3L), (26L, 5L), (20L, 11L))
    assertEquals(11L, Problem003.findLargestPrime(flippedList))
  }

  @Test
  def problem041Test(): Unit = {
    val odd1: Array[Char] = "90909".toCharArray
    assertEquals(true, Problem004.isPalindrome(odd1))
    val even1: Array[Char] = "9009".toCharArray
    assertEquals(true, Problem004.isPalindrome(even1))

    val odd2: Array[Char] = "99900".toCharArray
    assertEquals(false, Problem004.isPalindrome(odd2))
    val even2: Array[Char] = "9990".toCharArray
    assertEquals(false, Problem004.isPalindrome(even2))
    val lowerLimit = 10
    val start = 99
    assertEquals(9009, Problem004.largestPalindrome(lowerLimit, start, start, start))
  }

  @Test
  def problem006Test(): Unit = {
    val end1 = 10
    assertEquals(385, Problem006.squareSum(end = end1))
    val end2 = 10
    assertEquals(3025, Problem006.sumSquare(end = end2))
  }

  @Test
  def problem007Test(): Unit = {
    val n = 6
    assertEquals(13, Problem007.nthPrime(target = n))
  }

  @Test
  def problem008Test(): Unit = {
    val bigNumber: String = "731671765313306249192251196744265747423553491949349698352031277450632623957831801698480186947" +
      "88518438586156078911294949545950173795833195285320880551112540698747158523863050715693290963295227443043557" +
      "66896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890" +
      "72962904915604407723907138105158593079608667017242712188399879790879227492190169972088809377665727333001053" +
      "36788122023542180975125454059475224352584907711670556013604839586446706324415722155397536978179778461740649" +
      "55149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524" +
      "34506585412275886668811642717147992444292823086346567481391912316282458617866458359124566529476545682848912" +
      "88314260769004224219022671055626321111109370544217506941658960408071984038509624554443629812309878799272442" +
      "84909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972" +
      "571636269561882670428252483600823257530420752963450"
    val size = 4
    assertEquals(5832L, Problem008.findGreatestProduct(bigNumber, size))
  }

  @Test
  def problem010Test(): Unit = {
    assertEquals(17L, Problem010.primeAdder(end = 10))
  }

  val testGrid1 = Seq(
    Seq(4, 5, 6),
    Seq(1, 1, 1),
    Seq(1, 1, 1)
  )

  @Test
  def problem011TestRow(): Unit = {
    assertEquals(6, Problem011Methods.maxSumOfX(1)(testGrid1))
    assertEquals(11, Problem011Methods.maxSumOfX(2)(testGrid1))
    assertEquals(15, Problem011Methods.maxSumOfX(3)(testGrid1))
  }

  val testGrid2 = Seq(
    Seq(4, 1, 1),
    Seq(5, 1, 1),
    Seq(6, 1, 1)
  )

  def problem011TestCol(): Unit = {
    assertEquals(6, Problem011Methods.maxSumOfX(1)(testGrid2))
    assertEquals(11, Problem011Methods.maxSumOfX(2)(testGrid2))
    assertEquals(15, Problem011Methods.maxSumOfX(3)(testGrid2))
  }

  val testGrid3 = Seq(
    Seq(1, 1, 6),
    Seq(1, 5, 1),
    Seq(4, 1, 1)
  )

  def problem011TestRDiagonal(): Unit = {
    assertEquals(6, Problem011Methods.maxSumOfX(1)(testGrid3))
    assertEquals(11, Problem011Methods.maxSumOfX(2)(testGrid3))
    assertEquals(15, Problem011Methods.maxSumOfX(3)(testGrid3))
  }

  val testGrid4 = Seq(
    Seq(4, 1, 1),
    Seq(1, 5, 1),
    Seq(1, 1, 6)
  )

  def problem011TestLDiagonal(): Unit = {
    assertEquals(6, Problem011Methods.maxSumOfX(1)(testGrid4))
    assertEquals(11, Problem011Methods.maxSumOfX(2)(testGrid4))
    assertEquals(15, Problem011Methods.maxSumOfX(3)(testGrid4))
  }

  val finalTest = Seq(
    Seq(4, 1, 6, 1),
    Seq(1, 5, 1, 1),
    Seq(1, 1, 6, 6),
    Seq(9, 1, 1, 1)
  )

  def problem011TestAll(): Unit = {
    assertEquals(9, Problem011Methods.maxSumOfX(1)(finalTest))
    assertEquals(12, Problem011Methods.maxSumOfX(2)(finalTest))
    assertEquals(15, Problem011Methods.maxSumOfX(3)(finalTest))
    assertEquals(16, Problem011Methods.maxSumOfX(3)(finalTest))
  }

  def problem011TestGreaterThanGridSize(): Unit = {
    assertEquals(16, Problem011Methods.maxSumOfX(5)(finalTest))
    assertEquals(16, Problem011Methods.maxSumOfX(11)(finalTest))
  }

  def problem011TestProduct(): Unit = {
    assertEquals(9, Problem011Methods.maxProductOfX(1)(finalTest))
    assertEquals(36, Problem011Methods.maxProductOfX(2)(finalTest))
    assertEquals(120, Problem011Methods.maxProductOfX(3)(finalTest))
  }

  def problem012TestNthTriangle(): Unit = {
    assertEquals(28, Problem012.nthTriangle(7))
  }

  def problem012TestDivisors(): Unit = {
    assertEquals(6, Problem012.numberOfDivisors(28))
  }

  def problem012TestHasKDivisors(): Unit = {
    assertEquals(28, Problem012.hasKDivisors(k = 5))
  }

  def problem013Test(): Unit = {
    assertEquals(10, Problem013.sumLastDigit(Seq("1234", "4321", "2341", "3214")))
  }
}
