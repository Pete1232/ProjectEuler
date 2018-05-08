package solutions

import numeric.NumericMethods

object Problem012 extends App with NumericMethods {
  println(hasKDivisors(k = 500))

  def hasKDivisors(i: Int = 2, k: Int): Int = {
    val tri: Int = nthTriangle(i)
    if (numberOfDivisors(tri) > k) tri else hasKDivisors(i + 1, k)
  }

  def nthTriangle(n: Int): Int = {
    (1 to n).sum
  }

  def numberOfDivisors(n: Int): Int = {
    val pairs: (List[Int], List[Int]) = getDivisorPairs[Int](n, 1).unzip
    (pairs._1 ++ pairs._2)
      .distinct
      .size
  }
}
