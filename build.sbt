import play.Project._

name := "club-manager"

version := "1.0.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  cache,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.0.Final"
)

playJavaSettings
