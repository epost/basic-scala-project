import sbt._
import sbt.Keys._
import Tests._


object MyBuild extends Build {

  lazy val myProject = Project(
    id = "basic-scala-project",
    base = file("."),
    settings =
      Project.defaultSettings ++
      Seq(
        name := "basic-scala-project",
        description := "Basic Scala Project",
        organization := "nl.shinsetsu",
        organizationName := "Shinsetsu",
        libraryDependencies ++= Seq(
          // functional programmings libraries
          "org.scalaz"           %% "scalaz-core"       % "7.0.5" withSources,
          "org.scalaz"           %% "scalaz-effect"     % "7.0.5" withSources,
    
          // database and logging libraries
          "com.typesafe.slick"   %% "slick"             % "2.0.1-RC1" withSources,
          "org.xerial"           %  "sqlite-jdbc"       % "3.7.2",
          "org.slf4j"            %  "slf4j-log4j12"     % "1.6.1",
    
          // testing libraries
          "junit"                %  "junit"             % "4.5" % "test->default",
          "org.specs2"           %% "specs2"            % "1.13" % "test"
        ),
        scalaVersion := "2.10.3",
        scalacOptions ++= List("-deprecation", "-unchecked", "-Xlint"),
        resolvers += Resolver.sonatypeRepo("snapshots")
      )
  )
}