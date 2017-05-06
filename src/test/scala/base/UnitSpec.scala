package base

import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{FlatSpec, Matchers, MustMatchers, WordSpec}

trait UnitSpec extends FlatSpec with Matchers

trait UnitTest extends WordSpec with MustMatchers with GeneratorDrivenPropertyChecks
