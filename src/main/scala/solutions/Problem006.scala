package solutions

object Problem006 extends App{
  val stop = 100
  println(squareSum(end = stop) - sumSquare(end = stop))

  private def sumSquare(current: Int = 1, end: Int, total: Int = 0): Int = {
    if(current <= end) {
      sumSquare(current + 1, end, total + current * current)
    }
    else{
      total
    }
  }

  private def squareSum(current: Int = 1, end: Int, total: Int = 0): Int = {
    if (current <= end) {
      squareSum(current + 1, end, total + current)
    }
    else{
      total * total
    }
  }

}
