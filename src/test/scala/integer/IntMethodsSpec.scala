import org.scalatest._
import integer.IntMethods
import org.scalatest.concurrent.ScalaFutures

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class IntMethodsSpec extends FlatSpec with Matchers{
  "Calling isPrime on a byte" should "return true if it is a prime number" in {
    val primeByte: Byte = 7
    IntMethods.isPrime(primeByte) shouldBe true
  }
  it should "return false if that number is not prime" in {
    val compByte: Byte = 9
    IntMethods.isPrime(compByte) shouldBe false
  }
  "Calling isPrime on a short" should "return true if it is a prime number" in {
    val primeShort: Short = 17669
    IntMethods.isPrime(primeShort) shouldBe true
  }
  it should "return false if that number is not prime" in {
    val compShort: Short = 17671
    IntMethods.isPrime(compShort) shouldBe false
  }
  "Calling isPrime on an int" should "return true if it is a prime number" in {
    val primeInt: Int = 101921
    IntMethods.isPrime(primeInt) shouldBe true
  }
  it should "return false if that number is not prime" in {
    val compInt: Int = 101923
    IntMethods.isPrime(compInt) shouldBe false
  }
  "Calling isPrime on a long" should "return true if it is a prime number" in {
    val primeLong: Long = 2147484991L
    IntMethods.isPrime(primeLong) shouldBe true
  }
  it should "return false if that number is not prime" in {
    val compLong: Long = 2147484993L
    IntMethods.isPrime(compLong) shouldBe false
  }
}