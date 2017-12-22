lazy val root = (project in file("."))
  .settings(
    name := "Hello",
    scalaVersion := "2.11.12"

  )

libraryDependencies += "com.google.cloud" % "google-cloud-bigquery" % "0.30.0-beta"
