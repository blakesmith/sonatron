name := "sonatron"

version := "0.1"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.hibernate" % "ejb3-persistence" % "3.3.2.Beta1",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.14.v20131031" % "compile"
)
