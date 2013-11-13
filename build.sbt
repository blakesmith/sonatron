name := "sonatron"

version := "0.1"

scalaVersion := "2.10.3"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "com.soundcloud" % "java-api-wrapper" % "1.3.1",
  "org.hibernate" % "ejb3-persistence" % "3.3.2.Beta1",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.8.v20121106" % "compile",
  "org.scalatra" %% "scalatra" % "2.2.0"
)
