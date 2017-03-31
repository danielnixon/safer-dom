all:
	sbt package scalafmtTest

dist:
	sbt +publishSigned

.PHONY: all dist
