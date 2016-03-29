import integer.IntMethods

object PythagTriple extends App {
  getTriple(2)

  // Can this be done more efficiently with a bit of algebra?
  def getTriple(n: Int): Unit = {
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
    //IntMethods.getDivisorPairs

    // Step 4 & 5
    def checkPairs(pairs: List[(Int, Int)]): Unit ={
      def whenPairExists(pair: (Int, Int)): Unit = {
        val s = pair._1
        val t = pair._2
        if (isTarget(s, t)) {
          val x = r + s
          val y = r + t
          val z = r + s + t
          println("Found it!: Triple ("+x+", "+y+", "+z+") with product "+(x*y*z))
        }
        else
          checkPairs(pairs.tail)
      }
      def isTarget(s: Int, t: Int): Boolean ={
        val x = r + s
        val y = r + t
        val z = r + s + t
        3*r + 2*s + 2*t==1000
      }
      pairs.headOption match {
        case Some(pair) => whenPairExists(pair)
        case None => getTriple(n+1)
      }
    }
    checkPairs(IntMethods.getDivisorPairs(st))
  }
}