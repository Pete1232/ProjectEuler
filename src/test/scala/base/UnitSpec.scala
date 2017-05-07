package base

import org.scalatest._
import org.scalatest.prop.GeneratorDrivenPropertyChecks

trait UnitSpec extends FlatSpec with Matchers

trait UnitTest extends AsyncWordSpec with MustMatchers with GeneratorDrivenPropertyChecks
