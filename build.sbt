name := "sonatron"

version := "0.1"

scalaVersion := "2.10.3"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Local Maven" at Path.userHome.asFile.toURI.toURL + ".m2/repository"

libraryDependencies ++= Seq(
  "org.hamcrest" % "hamcrest-library" % "1.3.RC2",
  "org.hamcrest" % "hamcrest-core" % "1.3.RC2",
  "org.apache.httpcomponents" % "httpmime" % "4.0.3",
  "org.apache.httpcomponents" % "httpclient" % "4.0.3",
  "org.json" % "json" % "20090211",
  "com.soundcloud" % "java-api-wrapper" % "1.3.2-SNAPSHOT",
  "org.hibernate" % "ejb3-persistence" % "3.3.2.Beta1",
  "org.eclipse.jetty" % "jetty-webapp" % "8.1.8.v20121106" % "compile",
  "org.iq80.leveldb" % "leveldb" % "0.6",
  "org.scalatra" %% "scalatra" % "2.2.0"
)
