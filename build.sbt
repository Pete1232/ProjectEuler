val typelevel = "org.typelevel"

val catsVersion = "1.1.0"

val compileDependencies = Seq(
  typelevel %% "cats-core" % catsVersion,
  typelevel %% "cats-laws" % catsVersion
)

val testDependencies = Seq(
  "com.novocode" % "junit-interface" % "0.11",
  "org.scalacheck" %% "scalacheck" % "1.14.0",
  typelevel %% "cats-free" % catsVersion,
  typelevel %% "cats-testkit" % catsVersion
).map(_ % Test)

val settings = Seq(
  organization := "io.github.pete1232",
  version := "999-SNAPSHOT",
  scalaVersion := "2.12.6"
)

val projecteuler = (project in file("."))
  .settings(settings: _*)
  .settings(libraryDependencies ++= compileDependencies ++ testDependencies)
