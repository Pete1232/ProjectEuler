package solutions

object Problem008 extends App {
	val bigNumber = "731671765313306249192251196744265747423553491949349698352031277450632623957831801698480186947" +
    "88518438586156078911294949545950173795833195285320880551112540698747158523863050715693290963295227443043557" +
    "66896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890" +
    "72962904915604407723907138105158593079608667017242712188399879790879227492190169972088809377665727333001053" +
    "36788122023542180975125454059475224352584907711670556013604839586446706324415722155397536978179778461740649" +
    "55149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524" +
    "34506585412275886668811642717147992444292823086346567481391912316282458617866458359124566529476545682848912" +
    "88314260769004224219022671055626321111109370544217506941658960408071984038509624554443629812309878799272442" +
    "84909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972" +
    "571636269561882670428252483600823257530420752963450"

  private val size = 13
  println(findGreatestProduct(bigNumber, size))

  def getNumberFromIndex(largeNumber: String, index: Int, size: Int): Array[Char] = {
    val shortenedNumber = largeNumber.drop(index)
    shortenedNumber.take(size).toCharArray
  }

  def calculateProduct(number: Array[Char]): Long = {
    val digitList = number.map(char => char.asDigit.toLong)
    digitList.product
  }

  def findGreatestProduct(longNumber: String, size: Int, highest: Long = 0, index: Int = 0): Long = {
    val thisNumber = getNumberFromIndex(longNumber, index, size)
    val thisProduct = calculateProduct(thisNumber)
    if(thisProduct > highest & index < longNumber.size-1) {
      findGreatestProduct(longNumber, size, thisProduct, index + 1)
    }
    else if(index < longNumber.size-1) {
      findGreatestProduct(longNumber, size, highest, index + 1)
    }
    else {
      highest
    }
  }
}