val appDependencies = Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.0.6"
)

val testDependencies = Seq(
  "org.scalactic" %% "scalactic" % "3.0.1" % "test",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
)

lazy val settings = Seq(
  organization := "pete1232",
  version := "0.1.9",
  scalaVersion := "2.11.7",
  libraryDependencies ++= appDependencies ++ testDependencies,
  scalacOptions ++= Seq("-feature", "-language:postfixOps")
)

lazy val projecteuler = (project in file(".")).
  settings(settings: _*)
