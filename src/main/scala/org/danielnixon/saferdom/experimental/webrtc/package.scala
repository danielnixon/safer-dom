package org.danielnixon.saferdom.experimental

import org.danielnixon.saferdom.DOMError
import org.danielnixon.saferdom.experimental.mediastream._
import scala.scalajs.js
import scala.language.implicitConversions

package object webrtc {
  implicit def toWebRTC(n: org.danielnixon.saferdom.Navigator): NavigatorMediaStream =
    n.asInstanceOf[NavigatorMediaStream]

  @js.native
  trait NavigatorMediaStream extends js.Object {

    def getUserMedia(constraints: MediaStreamConstraints,
        success: js.Function1[MediaStream, Any],
        error: js.Function1[DOMError, Any]): Unit = js.native
  }
}
