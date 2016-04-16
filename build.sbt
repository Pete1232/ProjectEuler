lazy val settings = Seq(
  organization := "pete1232",
  version := "0.1.9",
  scalaVersion := "2.11.7",
  libraryDependencies ++= Seq(
    "org.scalactic" %% "scalactic" % "2.2.6",
    "org.scalatest" %% "scalatest" % "2.2.6" % "test",
    "org.scala-lang.modules" %% "scala-xml" % "1.0.4"
  ),
  scalacOptions ++= Seq("-feature", "-language:postfixOps")
)

lazy val projecteuler = (project in file(".")).
  settings(settings: _*)
