package solutions

object Problem001 extends App{
  private val end = 1000
  println(addToSumUntilEnd(end))

  def addToSumUntilEnd(end: Int, n: Int = 1, sum: Int = 0): Int = {
    if (n < end) {
      if (n % 3 == 0 || n % 5 == 0) {
        addToSumUntilEnd(end, n + 1, sum + n)
      }
      else {
        addToSumUntilEnd(end, n + 1, sum)
      }
    }
    else {
      sum
    }
  }
}
