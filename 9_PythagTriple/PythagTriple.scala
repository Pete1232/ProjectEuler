object PythagTriple extends App {
  getTriple(args(0).toInt)
  // Too difficult to calculate factor pairs from this
  // Should still use smallest divisor, but divide and pair up as it works through instead of at the end
  // Probably be useful for other problems so left here for now
  def getPrimeFactors(n: Int, resultList: List[Int]): List[Int] ={

    def isDivisibleBy(n: Int, divisor: Int): Boolean ={
      if(n % divisor == 0){
        true
      }
      else {
        false
      }
    }

    def findSmallestDivisorOfN(iterator: Int = 2): Int ={
      if(isDivisibleBy(n, iterator)){
        iterator
      }
      else{
        findSmallestDivisorOfN(iterator+1)
      }
    }

    val smallestDivisor = findSmallestDivisorOfN()

    if(smallestDivisor == n){
      resultList
    }
    else{
      getPrimeFactors(n/smallestDivisor, resultList:+smallestDivisor)
    }
  }

  // Can this be done more efficiently with a bit of algebra?
  def getTriple(n: Int) = {
    // Step 1: Set an even value for r
    // Step 2: Calculate r^2/2. Then st = r^2/2
    // Step 3: Find all PAIRS of factors of r^2/2 <-------probably the hard part
    // Step 4: Calculate x,y,z
    // Step 5: See if x+y+z = 1000. The result will be relatively small so this should be efficient enough

    //Step 1
    val r = 2*n

    //Step 2
    val st = r*r/2

    //Step 3
    def getDivisorPairs(n: Int, i: Int = 2, divisorList: List[(Int, Int)] = List((1,n))): List[(Int, Int)] ={
      def makeDivisorPair(d: Int, n: Int): Option[(Int, Int)] ={
        if(n % d == 0)
          Some(d, n/d)
        else
          None
      }
      val pair = makeDivisorPair(i, n)

      pair match {
        case Some(pair) => {
          if(divisorList.contains(pair.swap)){
            divisorList
          }
          else{
            getDivisorPairs(n, i + 1, divisorList :+ pair)
          }
        }
        case None => getDivisorPairs(n, i + 1, divisorList)
      }
    }
    println(getDivisorPairs(n))
  }
}