package solutions

import numeric.LongNumber.dataMonoidForLongNumber._

object Problem016 extends App {

  val two = plus(one, one)
  var res = two

  for {
    _ <- 2 to 1000
  } yield {
    res = res * two
  }
  println(res.digits.sum)
}
