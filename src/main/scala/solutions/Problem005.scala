package solutions

import numeric.NumericMethods

object Problem005 extends App with NumericMethods {
  private val numbers = Range(0, 20, 1)
  println(lcm(numbers.toList))
}
