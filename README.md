safer-dom
=========

[![Build Status](https://travis-ci.org/danielnixon/safer-dom.svg?branch=master)](https://travis-ci.org/danielnixon/safer-dom)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.danielnixon/safer-dom_sjs0.6_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.danielnixon/safer-dom_sjs0.6_2.12)

A fork of [scala-js-dom](https://github.com/scala-js/scala-js-dom) that replaces nullable return types `T` (which the web APIs like to do _everywhere_) with `Option[T]`.

Usage
-----

1. Add the dependency to your build:

  `libraryDependencies += "org.danielnixon" %%% "safer-dom" % "0.2"`

  If you're using `scala-js-dom`, remove that dependency.

2. Use the types in the `org.danielnixon.saferdom` package.

  If you already import `org.scalajs.dom`, replace those imports with `org.danielnixon.saferdom`.

  `safer-dom` uses implicits to wrap the facade types, so you'll often also need to import `org.danielnixon.saferdom.implicits._`.
  
3. Enjoy a slightly more type safe, slightly less sucky experience when working with the DOM.

  For example, this -- which would have exploded with a `TypeError` at runtime -- will no longer compile:
  
  `window.document.querySelector("nope").innerHTML = "foo"`
  
  Instead, you need to deal with the Option:
  
  `window.document.querySelector("nope").foreach(_.innerHTML = "foo")`
