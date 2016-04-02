import integer.IntMethods

object PrimeSum extends App {
  println(IntMethods.isPrime(args(0).toInt))
  //Need to make isPrime more efficient
  // println(primeAdder(2, args(0).toInt, 0))
  def primeAdder(i: Int, end: Int, currentTotal: Int): Int = {
    if(IntMethods.isPrime(i)){
      if(i>=end){
        currentTotal
      }
      else{
        primeAdder(i+1, end, currentTotal+i)
      }
    }
    else{
      primeAdder(i+1, end, currentTotal)
    }
  }
}