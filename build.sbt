name := """Argentum"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
//	"com.thoughtworks.xstream" % "xstream" % "1.4.9",
//	"org.codehaus.jettison" % "jettison" % "1.3.3",
	specs2 % Test,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
