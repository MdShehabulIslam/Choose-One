name := "scala-project"

version := "1.0"

scalaVersion := "2.13.8"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.2.9",
  "com.typesafe.akka" %% "akka-stream" % "2.6.19",
  "org.postgresql" % "postgresql" % "42.3.3",
  "com.typesafe.slick" %% "slick" % "3.4.0",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.4.0"
)
