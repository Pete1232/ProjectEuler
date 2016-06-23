package solutions

import base.UnitSpec

class ProblemSpec extends UnitSpec{

  "Calling Problem001.addToSumUntilEnd with 10" should "return 23" in {
    val end = 10
    Problem001.addToSumUntilEnd(end) shouldBe 23
  }
  "Calling Problem002.addToSumUntilEnd with 100" should "return 44" in {
    val end = 100
    Problem002.addToSumUntilEnd(end) shouldBe 44
  }
  "Calling Problem003.findLargestPrime" should "return the largest prime in a list of long tuples" in {
    val list = List((3L,7L), (5L, 26L), (11L, 20L))
    Problem003.findLargestPrime(list) shouldBe 11L
    val flippedList = List((7L,3L), (26L, 5L), (20L, 11L))
    Problem003.findLargestPrime(flippedList) shouldBe 11L
  }
  "Calling Problem004.isPalindrome with a palindrome" should "return true" in {
    val odd = "90909".toCharArray
    Problem004.isPalindrome(odd) shouldBe true
    val even = "9009".toCharArray
    Problem004.isPalindrome(even) shouldBe true
  }
  "Calling Problem004.isPalindrome with a non-palindrome" should "return false" in {
    val odd = "99900".toCharArray
    Problem004.isPalindrome(odd) shouldBe false
    val even = "9990".toCharArray
    Problem004.isPalindrome(even) shouldBe false
  }
  "Calling Problem004.largestPalindrome for 2 digits" should "return 9009" in {
    val lowerLimit = 10
    val start = 99
    Problem004.largestPalindrome(lowerLimit, start, start, start) shouldBe 9009
  }
  "Calling Problem006.squareSum with 10" should "return 385" in {
    val end = 10
    Problem006.squareSum(end = end) shouldBe 385
  }
  "Calling Problem006.sumSquare with 10" should "return 3025" in {
    val end = 10
    Problem006.sumSquare(end = end) shouldBe 3025
  }
  "Calling Problem007.nthPrime with 6" should "return 13" in {
    val n = 6
    Problem007.nthPrime(target = n) shouldBe 13
  }
  "Calling Problem008.findGreatestProduct with 4" should "return 5832" in {
    val bigNumber = "731671765313306249192251196744265747423553491949349698352031277450632623957831801698480186947" +
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
    Problem008.findGreatestProduct(bigNumber, size) shouldBe 5832
  }
  "Calling Problem010.primeAdder with 10" should "return 17" in {
    val end = 10
    Problem010.primeAdder(end = end) shouldBe 17
  }

  implicit val testGrid: Seq[Seq[Int]] = Seq(
    Seq(1, 2, 3, 4, 5, 6, 7, 8, 9),
    Seq(1, 2, 3, 4, 5, 6, 7, 8, 9),
    Seq(1, 2, 3, 4, 5, 6, 7, 8, 9),
    Seq(5, 2, 3, 4, 5, 6, 7, 8, 9),
    Seq(1, 2, 3, 4, 5, 6, 7, 8, 9),
    Seq(2, 3, 4, 5, 6, 7, 8, 9, 1),
    Seq(3, 4, 5, 1, 7, 1, 9, 1, 2),
    Seq(1, 2, 3, 4, 5, 6, 7, 8, 9),
    Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)
  )

  "Calling Problem11.parseGrid" should "parse the given csv into a sequence of sequences" in {
    Problem011.parseGrid("Problem011Grid").apply(0).apply(0) shouldBe 8
    Problem011.parseGrid("Problem011Grid").apply(5).apply(2) shouldBe 32
    Problem011.parseGrid("Problem011Grid").apply(19).apply(19) shouldBe 48
  }
  "Calling Problem11.getAt" should "return the element at the requested index if it exists" in {
    Problem011.getAt(0, 0) shouldBe Some(1)
    Problem011.getAt(2, 2) shouldBe Some(3)
    Problem011.getAt(1, 2) shouldBe Some(3)
    Problem011.getAt(19, 19)(Problem011.grid) shouldBe Some(48)
  }
  it should "return None if the index does not exist" in {
    Problem011.getAt(20, 20) shouldBe None
    Problem011.getAt(1, 20) shouldBe None
    Problem011.getAt(20, 1) shouldBe None
    Problem011.getAt(20, 1)(Problem011.grid) shouldBe None
  }
  "Calling Problem011.maxInColumn" should "return the greatest sum of 4 numbers in the column" in {
    Problem011.maxInColumn(0) shouldBe 11
    Problem011.maxInColumn(4) shouldBe 23
  }
  "Calling Problem011.maxInRow" should "return the greatest sum of 4 numbers in the row" in {
    Problem011.maxInRow(0) shouldBe 30
    Problem011.maxInRow(6) shouldBe 18
  }
}
