object Prime extends App{
  println(nthPrime(target = args(0).toInt))

  def nthPrime(n: Int = 1, number: Int = 2, target: Int): Int ={
    if(isPrime(number = number)){
      if(n == target)
        number
      else
        nthPrime(n+1, number+1, target)
    }
    else
      nthPrime(n, number+1, target)
  }

  def isPrime(number: Int) = {
    def checkPrime(divisor: Int = 2, number: Int): Boolean = {
      if(divisor == number)
        true
      else if(number%divisor != 0)
        checkPrime(divisor+1, number)
      else
        false
    }
    checkPrime(number = number)
  }
}
