name := "club-manager"

version := "1.0.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  cache,
  "org.hibernate" % "hibernate-entitymanager" % "4.3.5.Final"
)

scalaVersion := "2.11.1"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
