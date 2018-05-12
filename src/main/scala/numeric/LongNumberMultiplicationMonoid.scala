package numeric

import cats.Monoid

object LongNumberMultiplicationMonoid extends Monoid[LongNumber] with LongNumberNumeric {
  override def empty: LongNumber = one

  override def combine(x: LongNumber, y: LongNumber): LongNumber = x * y
}
