object Main extends App{
  val stop = args(0).toInt
  println(squareSum(end = stop) - sumSquare(end = stop))

  def sumSquare(current: Int = 1, end: Int, total: Int = 0): Int = {
    if(current <= end)
      sumSquare(current+1, end, total + current * current)
    else{
      total
    }
  }

  def squareSum(current: Int = 1, end: Int, total: Int = 0): Int = {
    if (current <= end)
      squareSum(current+1, end, total + current)
    else{
      total * total
    }
  }

}
