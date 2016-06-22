package solutions

import integer.IntMethods

object Problem005 extends App with IntMethods{
  private val numbers = Range(0, 20, 1)
  println(lcm(numbers.toList))
}
