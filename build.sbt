import scalatex.ScalatexReadme

lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin)

name := "Safer DOM"

crossScalaVersions in ThisBuild := Seq("2.11.8", "2.10.6", "2.12.1")
scalaVersion in ThisBuild := crossScalaVersions.value.head

val commonSettings = Seq(
  version := "0.2",
  organization := "org.danielnixon",
  scalacOptions ++= Seq("-deprecation", "-feature", "-Xfatal-warnings")
)

normalizedName := "safer-dom"

commonSettings

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

pomExtra := (
    <developers>
      <developer>
        <id>danielnixon</id>
        <name>Daniel Nixon</name>
        <url>https://danielnixon.org/</url>
      </developer>
    </developers>
)

pomIncludeRepository := { _ => false }

lazy val readme = ScalatexReadme(
  folder = "readme",
  url = "https://github.com/danielnixon/safer-dom/tree/master",
  source = "Index",
  targetFolder = "target/site",
  autoResources = Seq("example-opt.js")
).settings(
  scalaVersion := "2.11.8",
  (resources in Compile) += (fullOptJS in (example, Compile)).value.data
)

lazy val example = project.
  enablePlugins(ScalaJSPlugin).
  settings(commonSettings: _*).
  dependsOn(root)
