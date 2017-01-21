package org.danielnixon.saferdom.experimental

import language.implicitConversions

import org.danielnixon.saferdom

/**
 * Implements the Gamepad API.
 *
 * [[https://www.w3.org/TR/2015/WD-gamepad-20151217/ W3C Working Draft]]
 */
package object gamepad {
  implicit def toGamepad(navigator: saferdom.raw.Navigator): GamepadNavigator =
    navigator.asInstanceOf[GamepadNavigator]

  final val `unknown` = "".asInstanceOf[GamepadMappingType]

  final val `standard` = "standard".asInstanceOf[GamepadMappingType]
}
