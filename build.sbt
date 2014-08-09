Common.settings

name := "club-manager"

libraryDependencies ++= Seq(
  // play
  javaJdbc,
  javaJpa.exclude("org.hibernate.javax.persistence", "hibernate-jpa-2.0-api"),
  cache,
  // external
  "javax.inject" % "javax.inject" % "1",
  "com.google.inject" % "guice" % "4.0-beta",
  "org.hibernate" % "hibernate-entitymanager" % "4.3.5.Final",
  // web
  "org.webjars" % "bootstrap" % "3.2.0"
)

lazy val root = (project in file("."))
  .enablePlugins(PlayJava)
  .dependsOn(security).aggregate(security)

lazy val security = (project in file("modules/security"))
  .enablePlugins(PlayJava)