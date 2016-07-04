package solutions

import java.util.logging.Logger

import integer.IntMethods

object Problem012 extends App with IntMethods{
  println(hasKDivisors(k = 500))

  def hasKDivisors(i: Int = 2, k: Int): Int = {
    val tri = nthTriangle(i)
    if(numberOfDivisors(tri) > k) tri else hasKDivisors(i + 1, k)
  }

  def nthTriangle(n: Int): Int = {
    (1 to n).sum
  }

  def numberOfDivisors(n: Int): Int = {
    val pairs = getDivisorPairs[Int](n).unzip
    (pairs._1 ++ pairs._2)
      .distinct
      .size
  }
}
