package solutions

import integer.IntMethods

object Problem005 extends App{
  private val numbers = Range(0, 20, 1)
  println(IntMethods.lcm(numbers.toList))
}
