name := "kafka-consumer-producer"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.apache.kafka" %% "kafka" % "2.1.0",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.slf4j" % "slf4j-simple" % "1.7.5",
  "com.typesafe" % "config" % "1.3.2"
)