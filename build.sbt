name := "club-manager"

version := "1.0.0-SNAPSHOT"

libraryDependencies ++= Seq(
  // play
  javaJdbc,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  cache,
  // external
  "com.google.inject" % "guice" % "4.0-beta",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.5.Final",
  // web
  "org.webjars" % "bootstrap" % "3.2.0"
)

resolvers ++= Seq(
)

scalaVersion := "2.11.1"

lazy val root = (project in file(".")).enablePlugins(PlayJava)
