package solutions

object Problem004 extends App{

  val lowerLimit = 100
  val start = 999
  println(largestPalindrome(lowerLimit, start, start, start))

  def largestPalindrome(lowerLimit: Int, start: Int, i: Int , j: Int, list: List[Int] = List()) : Int = {

    def asArray(i: Int, j: Int): Array[Char] = {
      (i * j + "").toCharArray
    }
    
    if(i == lowerLimit){
      if(j == lowerLimit){
        list.max
      }
      else{
        if(isPalindrome(asArray(i, j))){
          largestPalindrome(lowerLimit, start, start, j - 1, list :+ i * j)
        }
        else{
          largestPalindrome(lowerLimit, start, start, j - 1, list)
        }
      }
    }
    else{
      if(isPalindrome(asArray(i, j))){
        largestPalindrome(lowerLimit, start, i - 1, j, list :+ i * j)
      }
      else{
        largestPalindrome(lowerLimit, start, i - 1, j, list)
      }
    }
  }

  def isPalindrome(numberArray: Array[Char]): Boolean = {
    if(numberArray.size <= 1){
      true
    }
    else if(numberArray.head == numberArray.last){
      isPalindrome(numberArray.drop(1).dropRight(1))
    }
    else{
      false
    }
  }
}
