//package base
//
//import org.scalacheck.Gen
//
//object Generators {
//  val oddNumberGen: Gen[Int] =
//    for {
//      num <- Gen.posNum[Int]
//    } yield num * 2 + 1
//
//  val evenNumberGen: Gen[Int] =
//    for {
//      num <- Gen.posNum[Int]
//    } yield num * 2
//}
