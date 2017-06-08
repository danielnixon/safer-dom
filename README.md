safer-dom
=========

[![Build Status](https://travis-ci.org/danielnixon/safer-dom.svg?branch=master)](https://travis-ci.org/danielnixon/safer-dom)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.danielnixon/safer-dom_sjs0.6_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.danielnixon/safer-dom_sjs0.6_2.12)

A [scala-js-dom](https://github.com/scala-js/scala-js-dom) library that replaces nullable return types `T` (which the web APIs like to do _everywhere_) with `Option[T]`.

Usage
-----

1. Add the dependency to your build:

  `libraryDependencies += "org.danielnixon" %%% "safer-dom" % "0.4.0"`

2. Import `org.danielnixon.saferdom.implicits._`.
  
3. Replace calls to nullable methods (e.g. `document.querySelector()`) with their safer alternatives (e.g. `document.querySelectorOpt()`).

  For example, this (which would have exploded with a `TypeError` at runtime):
  
  `window.document.querySelector("nope").innerHTML = "foo"`
  
  can be now be written as:
  
  `window.document.querySelectorOpt("nope").foreach(_.innerHTML = "foo")`
