val dottyVersion = "0.8.0-RC1"

lazy val settings = Seq(
  organization := "io.github.pete1232",
  version := "999-SNAPSHOT",
  scalaVersion := dottyVersion,
  libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
)

lazy val projecteuler = (project in file("."))
  .settings(settings: _*)
  .settings(
    scalacOptions ++= {
      if (isDotty.value) Seq("-language:Scala2", "-rewrite") else Nil
    }
  )
