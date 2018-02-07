name := "scala-tdd"

version := "1.0"

scalaVersion := "2.12.4"

resolvers += "Artima Maven Repository" at "http://repo.artima.com/releases"

libraryDependencies += "info.cukes" % "cucumber-junit" % "1.2.5"

libraryDependencies += "info.cukes" % "cucumber-java8" % "1.2.5"

libraryDependencies += "com.google.code.gson" % "gson" % "2.8.0"

libraryDependencies += "org.scala-lang.modules" % "scala-java8-compat_2.12" % "0.8.0"

libraryDependencies += "com.chuusai" % "shapeless_2.12" % "2.3.2"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-core" % "2.9.1"

libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.9.1"

libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.12" % "2.9.1"

libraryDependencies += "com.typesafe.akka" % "akka-actor_2.12" % "2.5.6"

//test

libraryDependencies += "junit" % "junit" % "4.8.2" % "test"

libraryDependencies += "org.mockito" % "mockito-all" % "1.10.19"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

libraryDependencies += "org.powermock" % "powermock-module-junit4" % "1.6.5"

libraryDependencies += "org.powermock" % "powermock-api-mockito" % "1.6.5"

libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.4.1" % "test"
