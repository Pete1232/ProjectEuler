lazy val commonSettings = Seq(
  organization := "pete1232",
  version := "0.1.9",
  scalaVersion := "2.11.7",
  libraryDependencies ++= Seq(
    "org.scalactic" %% "scalactic" % "2.2.6",
    "org.scalatest" %% "scalatest" % "2.2.6" % "test",
    "org.scala-lang.modules" %% "scala-xml" % "1.0.4"
  )
)

lazy val projecteuler = (project in file(".")).
  settings(commonSettings: _*)
lazy val pe6 = (project in file("./solutions/1-20/6")).
  settings(commonSettings: _*)
lazy val pe7 = (project in file("./solutions/1-20/7")).
  settings(commonSettings: _*).
  dependsOn(projecteuler)
lazy val pe8 = (project in file("./solutions/1-20/8")).
  settings(commonSettings: _*)
lazy val pe9 = (project in file("./solutions/1-20/9")).
  settings(commonSettings: _*).
  dependsOn(projecteuler)
lazy val pe10 = (project in file("./solutions/1-20/10")).
  settings(commonSettings: _*).
  dependsOn(projecteuler)
