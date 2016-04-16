package solutions

object Problem002 extends App{

  private val end = 4000000
  println(addToSumUntilEnd(end))

  def addToSumUntilEnd(end: Int, i: Int = 1, j: Int = 2, sum: Int = 0): Int = {
    if(j<end) {
      if (j % 2 == 0) {
        addToSumUntilEnd(end, j, i + j, sum + j)
      }
      else{
        addToSumUntilEnd(end, j, i + j, sum)
      }
    }
    else{
      sum
    }
  }
}
