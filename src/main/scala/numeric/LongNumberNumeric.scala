package numeric

trait Test

trait LongNumberNumeric extends Numeric[LongNumber] {

  override def plus(x: LongNumber, y: LongNumber): LongNumber = {

    if (x.isNegative == y.isNegative) {
      // addition
      val preparedSequence: Seq[(Int, Int)] = (0, 0) +: x.digits.reverse.zipAll(y.digits.reverse, 0, 0).reverse

      val result: Seq[Int] = {
        preparedSequence
          // add up leaving addition results as-is
          .scanRight(0) { (thisAddition, carriedOver) =>
          (carriedOver / 10) + thisAddition._1 + thisAddition._2
        }
          .dropWhile(_ == 0) // drop any extra digits at the start (will happen when x + y >= 10)
          .dropRight(1) // drop the 0 added by the scan
          .map(_ % 10) // keep only the last digit in each position
      }
      LongNumber(result, isNegative = if (result.isEmpty) false else x.isNegative) // +/+ or -/-
    } else if (y.isNegative) {
      // subtraction
      if (gteq(x, negate(y))) {
        // if the absolute value of x is higher than y continue as-is
        val preparedSequence: Seq[(Int, Int)] = {
          (0, 0) +: x.digits.reverse.zipAll(y.digits.reverse, 0, 0).reverse
        }
        val result: Seq[Int] = {
          preparedSequence
            // add up leaving addition results as-is
            .scanRight(0) { (thisAddition, carriedOver) =>
            val firstRes: Int = thisAddition._1 - thisAddition._2 - (carriedOver / 10)
            if (firstRes < 0) 10 + firstRes + 10 else firstRes // if subtraction ended negative need to carry 1
          }
            .map(_ % 10) // keep only the last digit in each position
            .dropWhile(_ == 0) // drop any extra digits at the start (will happen when x + y >= 10)
            .dropRight(1) // drop the 0 added by the scan
        }
        // TODO better way of dealing with the two-zeros problem
        val out = LongNumber(result.map(_.abs), isNegative = if (result.isEmpty) false else result.head < 0)
        out
      } else {
        negate(plus(negate(y), negate(x))) // otherwise do the subtraction the other way round and negate
      }
    } else {
      plus(y, x) // addition is commutative
    }
  }

  override def minus(x: LongNumber, y: LongNumber): LongNumber = plus(x, negate(y))

  override def times(x: LongNumber, y: LongNumber): LongNumber = ???

  override def negate(x: LongNumber): LongNumber = x.copy(isNegative = !x.isNegative)

  override def fromInt(x: Int): LongNumber = {

    val numberAsString: String = x.toString

    val (absValue, isNegative) = if (numberAsString.head == '-') (numberAsString.tail, true) else (numberAsString, false)

    val longValue: Seq[Int] = {
      absValue.toCharArray
        .map(_.asDigit)
        .dropWhile(_ == 0)
    }

    LongNumber(longValue, isNegative)
  }

  override def toInt(x: LongNumber): Int = ???

  override def toLong(x: LongNumber): Long = ???

  override def toFloat(x: LongNumber): Float = ???

  override def toDouble(x: LongNumber): Double = ???

  override def compare(x: LongNumber, y: LongNumber): Int = {
    (x.isNegative, y.isNegative) match {
      case (true, false) => // x < y
        -1
      case (false, true) => // x > y
        1
      case (true, true) => // x,y > 0
        if (x.digits == y.digits) { // x = y
          0
        } else if (x.digits.length > y.digits.length) { // x < y
          -1
        } else if (x.digits.length < y.digits.length) { // x > y
          1
        } else {
          x.digits.zip(y.digits) // know that these are the same size and not Nil
            .collectFirst {
            case digits if digits._1 != digits._2 =>
              digits._1.compareTo(digits._2)
          }.getOrElse(0) // should not happen
        }
      case (false, false) => // x,y > 0
        if (x.digits == y.digits) { // x = y
          0
        } else if (x.digits.length > y.digits.length) { // x > y
          1
        } else if (x.digits.length < y.digits.length) { // x < y
          -1
        } else {
          x.digits.zip(y.digits) // know that these are the same size and not Nil
            .collectFirst {
            case digits if digits._1 != digits._2 =>
              digits._1.compareTo(digits._2)
          }.getOrElse(0) // should not happen
        }
    }
  }
}
