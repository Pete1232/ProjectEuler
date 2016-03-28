lazy val commonSettings = Seq(
  organization := "Pete1232",
  version := "0.1.9",
  scalaVersion := "2.11.7",
  libraryDependencies ++= Seq(
    "org.scalactic" %% "scalactic" % "2.2.6",
    "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  )
)

lazy val pe6 = (project in file("6_SumSquareDiff")).
  settings(commonSettings: _*)
lazy val pe7 = (project in file("7_NthPrime")).
  settings(commonSettings: _*)
lazy val pe8 = (project in file("8_ProductSeries")).
  settings(commonSettings: _*)
lazy val pe9 = (project in file("9_PythagTriple")).
  settings(commonSettings: _*)