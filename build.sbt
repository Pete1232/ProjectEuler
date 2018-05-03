val appDependencies = Seq(
)

val testDependencies = Seq(
  "org.scalactic" %% "scalactic" % "3.0.5" % "test",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.scalacheck" %% "scalacheck" % "1.14.0" % "test"
)

lazy val settings = Seq(
  organization := "io.github.pete1232",
  version := "999-SNAPSHOT",
  scalaVersion := "2.12.6",
  libraryDependencies ++= appDependencies ++ testDependencies,
  scalacOptions ++= Seq("-feature", "-language:postfixOps")
)

lazy val projecteuler = (project in file(".")).
  settings(settings: _*)
