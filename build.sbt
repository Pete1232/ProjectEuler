val dottyVersion = "0.8.0-RC1"

val settings = Seq(
  organization := "io.github.pete1232",
  version := "999-SNAPSHOT",
  scalaVersion := dottyVersion
)

val projecteuler = (project in file("."))
  .settings(settings: _*)
  .settings(
    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test",
    libraryDependencies += ("org.scalacheck" %% "scalacheck" % "1.14.0" % "test").withDottyCompat(scalaVersion.value)
  )
