package solutions

import numeric.NumericMethods

object Problem009 extends App with NumericMethods {
  calculateTriple(2)

  def calculateTriple(n: Int): Unit = {
    // Step 1: Set an even value for r
    // Step 2: Calculate r^2/2. Then st = r^2/2
    // Step 3: Find all PAIRS of factors of r^2/2 <-------probably the hard part
    // Step 4: Calculate x,y,z
    // Step 5: See if x+y+z = 1000. The result will be relatively small so this should be efficient enough

    //Step 1
    val r: Long = 2 * n

    //Step 2
    val st: Long = r * r / 2

    //Step 3
    //IntMethods.getDivisorPairs

    // Step 4 & 5
    def checkPairs(pairs: List[(Long, Long)]): Unit = {
      def whenPairExists(pair: (Long, Long)): Unit = {
        val s: Long = pair._1
        val t: Long = pair._2
        if (isTarget(s, t)) {
          val x: Long = r + s
          val y: Long = r + t
          val z: Long = r + s + t
          println("Found it!: Triple (" + x + ", " + y + ", " + z + ") with product " + (x * y * z))
        }
        else {
          checkPairs(pairs.tail)
        }
      }

      def isTarget(s: Long, t: Long): Boolean = {
        3 * r + 2 * s + 2 * t == 1000
      }

      pairs.headOption match {
        case Some(pair) => whenPairExists(pair)
        case None => calculateTriple(n + 1)
      }
    }

    val pairs: List[(Long, Long)] = getDivisorPairs(st, 1L)
    checkPairs(pairs)
  }
}
