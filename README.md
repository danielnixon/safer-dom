safer-dom
=========

[![Build Status](https://travis-ci.org/danielnixon/safer-dom.svg?branch=master)](https://travis-ci.org/danielnixon/safer-dom)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/org.danielnixon/safer-dom_sjs0.6_2.12/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.danielnixon/safer-dom_sjs0.6_2.12)

A fork of [scala-js-dom](https://github.com/scala-js/scala-js-dom) that replaces nullable return types `T` (which the DOM API likes to do _everywhere_) with `Option[T]`.