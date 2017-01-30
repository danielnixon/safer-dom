all:
	sbt package doc scalafmtTest && sbt ++2.11.8 readme/run

dist:
	sbt +publishSigned

.PHONY: all dist
