name := """play-java"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava,PlayEbean)

scalaVersion := "2.11.11"

libraryDependencies += javaJdbc
libraryDependencies += cache
libraryDependencies += javaWs
libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.41"
libraryDependencies += "io.reactivex.rxjava2" % "rxjava" % "2.1.10"

routesGenerator := InjectedRoutesGenerator

playEbeanModels in Compile := Seq("models.*")