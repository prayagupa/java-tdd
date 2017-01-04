name := "scala-tdd"

version := "1.0"

scalaVersion := "2.11.8"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

libraryDependencies += "junit" % "junit" % "4.8.2" % "test"

libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

libraryDependencies += "org.powermock" % "powermock-module-junit4" % "1.6.5"

libraryDependencies += "org.powermock" % "powermock-api-mockito" % "1.6.5"

libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.3.0" % "test"
