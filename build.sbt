lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "Safer DOM"

crossScalaVersions in ThisBuild := Seq("2.11.11", "2.10.6", "2.12.2", "2.13.0-M1")
scalaVersion in ThisBuild := crossScalaVersions.value.head

val commonSettings = Seq(
  version := "0.5.0",
  organization := "org.danielnixon",
  scalacOptions ++= Seq("-deprecation", "-feature", "-Xfatal-warnings")
)

normalizedName := "safer-dom"

commonSettings

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.2"

homepage := Some(url("https://github.com/danielnixon/safer-dom"))

licenses += ("MIT", url("http://opensource.org/licenses/mit-license.php"))

scmInfo := Some(ScmInfo(
    url("https://github.com/danielnixon/safer-dom"),
    "scm:git:git@github.com:danielnixon/safer-dom.git",
    Some("scm:git:git@github.com:danielnixon/safer-dom.git")))

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

pomExtra := {
    <developers>
      <developer>
        <id>danielnixon</id>
        <name>Daniel Nixon</name>
        <url>https://danielnixon.org/</url>
      </developer>
    </developers>
}

pomIncludeRepository := { _ => false }
