import base.UnitSpec
import integer.IntMethods

class IntMethodsSpec extends UnitSpec{

  val primeByte: Byte = 7
  val primeShort: Short = 17669
  val primeInt: Int = 101921
  val primeLong: Long = 101921L
  val compByte: Byte = 9
  val compShort: Short = 17671
  val compInt: Int = 101923
  val compLong: Long = 101923L

  "Calling isPrime on a number" should "return true if the number is a prime integer of type byte" in {
    IntMethods.isPrime(primeByte) shouldBe true
  }
  it should "return true if the number is a prime integer of type short" in {
    IntMethods.isPrime(primeShort) shouldBe true
  }
  it should "return true if the number is a prime integer of type int" in {
    IntMethods.isPrime(primeInt) shouldBe true
  }
  it should "return true if the number is a prime integer of type long" in {
    IntMethods.isPrime(primeLong) shouldBe true
  }
  it should "return false if that number is not prime and of type byte" in {
    IntMethods.isPrime(compByte) shouldBe false
  }
  it should "return false if that number is not prime and of type short" in {
    IntMethods.isPrime(compShort) shouldBe false
  }
  it should "return false if that number is not prime and of type int" in {
    IntMethods.isPrime(compInt) shouldBe false
  }
  it should "return false if that number is not prime and of type long" in {
    IntMethods.isPrime(compLong) shouldBe false
  }

  "Calling getDivisorPairs on a number" should "return a list of all a numbers divisor pairs if it is of type byte" in {
    val listByte = List[(Byte, Byte)]((1, 9), (3, 3))
    IntMethods.getDivisorPairs(compByte) should contain theSameElementsAs listByte
  }
  it should "return a list of all a numbers divisor pairs if it is of type short" in {
    val listShort = List[(Short, Short)]((1, 17671), (41, 431))
    IntMethods.getDivisorPairs(compShort) should contain theSameElementsAs listShort
  }
  it should "return a list of all a numbers divisor pairs if it is of type int" in {
    val listInt = List[(Int, Int)]((1, 101923), (227, 449))
    IntMethods.getDivisorPairs(compInt) shouldBe listInt
  }
  it should "return a list of all a numbers divisor pairs if it is of type long" in {
    val listLong = List[(Long, Long)]((1L, 101923L), (227L, 449L))
    IntMethods.getDivisorPairs(compLong) shouldBe listLong
  }

  "Calling divide" should "return the number divided by the divisor as Some value" in {
    IntMethods.divide(2, 2) shouldBe Some(1)
    IntMethods.divide(5, 10) shouldBe Some(2)
    IntMethods.divide(2, 16) shouldBe Some(8)
    IntMethods.divide(3, 15) shouldBe Some(5)
  }
  it should "return the None if the number was not divisible by the divisor" in {
    IntMethods.divide(5, 11) shouldBe None
    IntMethods.divide(2, 17) shouldBe None
    IntMethods.divide(3, 16) shouldBe None
  }

  "Calling calculatePrimeFactors on a number" should "return its prime factorisation" in {
    IntMethods.calculatePrimeFactors(4) should contain theSameElementsAs List(2, 2)
    IntMethods.calculatePrimeFactors(5) should contain theSameElementsAs List(5)
    IntMethods.calculatePrimeFactors(12) should contain theSameElementsAs List(2, 2, 3)
    IntMethods.calculatePrimeFactors(64) should contain theSameElementsAs List(2, 2, 2, 2, 2, 2)
  }

  "Calling lcm on two numbers" should "return their lowest common multiple" in {
    IntMethods.lcm(2, 2) shouldBe 2
    IntMethods.lcm(4, 5) shouldBe 20
    IntMethods.lcm(5, 13) shouldBe 65
    IntMethods.lcm(23, 12) shouldBe 276
    IntMethods.lcm(16, 64) shouldBe 64
  }
  "Calling lcm on a list of numbers" should "return their lowest commn multiple" in {
    IntMethods.lcm(List(2, 2)) shouldBe 2
    IntMethods.lcm(List(4, 5, 6)) shouldBe 60
    IntMethods.lcm(List(16, 64)) shouldBe 64
    IntMethods.lcm(List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)) shouldBe 2520
  }
}
