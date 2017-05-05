name := """stripe-reporting-java"""
organization := "com.demo"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.11"

libraryDependencies += filters

libraryDependencies ++=  Seq(
  "com.stripe" % "stripe-java" % "4.7.0"
)

