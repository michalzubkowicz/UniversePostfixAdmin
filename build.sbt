name := """UniversePostfixAdmin"""

version := "1.0"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  "org.mindrot" % "jbcrypt" % "0.3m",
  javaEbean,
  javaWs,
  "org.apache.commons" % "commons-email" % "1.3.2",
  "mysql" % "mysql-connector-java" % "5.1.31"
)
