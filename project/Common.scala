import sbt.Keys._
import sbt._

object Common {
  val settings: Seq[Setting[_]] = Seq(
    organization := "com.bwu",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := "2.11.1"
  )
}