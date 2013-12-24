import play.Project._

name := "club-manager"

version := "1.0.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache
)

playJavaSettings
