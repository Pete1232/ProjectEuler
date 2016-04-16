import base.UnitSpec
import integer.IntMethods

class IntMethodsSpec extends UnitSpec{

  val primeByte: Byte = 7
  val primeShort: Short = 17669
  val primeInt: Int = 101921
  val primeLong: Long = 2147484991L
  val compByte: Byte = 9
  val compShort: Short = 17671
  val compInt: Int = 101923
  val compLong: Long = 2147484993L

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
    val listLong = List[(Long, Long)]((1L, 2147484993L), (3L, 715828331L))
    IntMethods.getDivisorPairs(compLong) shouldBe listLong
  }
}
