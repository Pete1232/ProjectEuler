val root = (project in file("."))
  .settings(
    organization := "io.github.pete1232",
    version := "999-SNAPSHOT",
    scalaVersion := "2.12.8",
    libraryDependencies ++= {
      val catsVersion = "1.6.0"
      Seq(
        "org.typelevel" %% "cats-core" % catsVersion,
        "org.typelevel" %% "cats-laws" % catsVersion,
        "com.novocode" % "junit-interface" % "0.11",
        "org.scalacheck" %% "scalacheck" % "1.14.0" % Test,
        "org.typelevel" %% "cats-free" % catsVersion % Test,
        "org.typelevel" %% "cats-testkit" % catsVersion % Test
      )
    }
  )
