import org.scalatest._
import integer.IntMethods
import org.scalatest.concurrent.ScalaFutures

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

class IntMethodsSpec extends FlatSpec with Matchers{
  "Calling isPrime on an Int" should "return true if that integer is prime" in {
    IntMethods.isPrime(5) shouldBe true
    IntMethods.isPrime(97) shouldBe true
    IntMethods.isPrime(1999993) shouldBe true
  }

  it should "return false if that integer is not prime" in {
    IntMethods.isPrime(4) shouldBe false
    IntMethods.isPrime(85) shouldBe false
    IntMethods.isPrime(1999997) shouldBe false
  }

  it should "return a result in a reasonable time for any number that is small enough" in {
    val startTime = System.currentTimeMillis()
    val result: Future[Boolean] = Future {
      // small enough number
      IntMethods.isPrime(1999993)
    }
    // reasonable time (based on 60 seconds for problem 10)
    Await.result(result, 30 microsecond)
    ScalaFutures.whenReady(result) {s =>
      s shouldBe true
    }
  }
}