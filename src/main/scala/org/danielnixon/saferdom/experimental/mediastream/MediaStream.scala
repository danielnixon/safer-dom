/**
 * https://www.w3.org/TR/2015/WD-mediacapture-streams-20150212/
 */
package org.danielnixon.saferdom.experimental.mediastream

import scala.scalajs.js
import org.danielnixon.saferdom.raw.{DOMError, Event, EventTarget}
import scala.scalajs.js.|

/**
 * The MediaStream
 *
 * https://www.w3.org/TR/2015/WD-mediacapture-streams-20150212/
 *
 * MDN
 *
 */
@js.native
class MediaStream() extends EventTarget {

  /**
   * Is a Boolean value set to true if the ended event has been
   * fired on the object, meaning that the stream has been completely read,
   * or false if the end of the stream has not been reached.
   *
   * MDN
   */
  val ended: Boolean = js.native

  /**
   * Is a DOMString containing 36 characters denoting a universally
   * unique identifier (UUID) for the object.
   *
   * MDN
   */
  val id: String = js.native

  /**
   * Is an EventHandler containing the action to perform when an addtrack event
   * is fired when a new MediaStreamTrack object is added.
   *
   * MDN
   */
  var onaddtrack: js.Function1[Event, Any] = js.native

  /**
   * Is an EventHandler containing the action to perform when an removetrack
   * event is fired when a  MediaStreamTrack object is removed from it.
   *
   * MDN
   */
  var onremovetrack: js.Function1[Event, Any] = js.native

  /**
   * Is an EventHandler containing the action to perform when a end
   * event is fired.
   *
   * MDN
   */
  var onended: js.Function1[Event, Any] = js.native

  /**
   * Stores a copy of the MediaStreamTrack given as argument. If the track has
   * already been added to the MediaStream object, nothing happens; if the
   * track is in the finished state - that is, has already reached its end -
   * the exception INVALID_STATE_RAISE is raised.
   *
   * MDN
   */
  def addTrack(track: MediaStreamTrack): Unit = js.native

  /**
   * Returns a list of the MediaStreamTrack objects stored in the MediaStream
   * object that have their kind attribute set to "audio". The order is not
   * defined, and may not only vary from one browser to another, but also from
   * one call to another..
   *
   * MDN
   */
  def getAudioTracks(): js.Array[MediaStreamTrack] = js.native

  /**
   * Returns the track whose ID corresponds to the one given in parameters,
   * trackid. If no parameter is given, or if no track with that ID does exist,
   * it returns null. If several tracks have the same ID, it returns the first
   * one.
   *
   * MDN
   */
  def getTrackById(trackId: String): MediaStreamTrack = js.native

  /**
   * Returns a list of the MediaStreamTrack objects stored in the MediaStream
   * object that have their kind attribute set to "video". The order is not
   * defined, and may not only vary from one browser to another, but also from
   * one call to another.
   *
   * MDN
   */
  def getVideoTracks(): js.Array[MediaStreamTrack] = js.native

  /**
   * Removes the MediaStreamTrack given as argument. If the track is not part
   * of the MediaStream object, nothing happens; if the track is in the
   * finished state - that is, it has already reached its end - the exception
   * INVALID_STATE_RAISE is raised.
   *
   * MDN
   */
  def removeTrack(track: MediaStreamTrack): Unit = js.native

  /**
   * Clones the given MediaStream and all its tracks.
   * When the clone() method is invoked, the user agent must run the following
   * steps:
   *   1) Let streamClone be a newly constructed MediaStream object.
   *   2) Initialize streamClone's id attribute to a newly generated value.
   *   3) Let trackSetClone be a list that contains the result of running
   *   MediaStreamTrack.clone() on all the tracks in this stream.
   *
   * Let trackSetClone be streamClone's track set.
   *
   * MDN
   */
  override def clone(): MediaStream = js.native
}

/**
 * see [[https://www.w3.org/TR/2013/WD-mediacapture-streams-20130903/#widl-MediaStream-onended]] in W3C spec
 */
@js.native
trait MediaStreamTrackState extends js.Any

object MediaStreamTrackState {

  /** The track type is new and has not been initialized (connected to a source
   * of any kind). This state implies that the track's label will be the empty string.
   */
  val `new` = "new".asInstanceOf[MediaStreamTrackState]

  /** The track is active (the track's underlying media source is making a best-effort
   * attempt to provide data in real time).
   * The output of a track in the live state can be switched on and off with the
   * enabled attribute.
   */
  val live = "live".asInstanceOf[MediaStreamTrackState]

  /** The track has ended (the track's underlying media source is no longer providing
   * data, and will never provide more data for this track). Once a track enters this
   * state, it never exits it.
   *
   * For example, a video track in a MediaStream ends if the user unplugs the USB web
   * camera that acts as the track's media source.
   */
  val ended = "ended".asInstanceOf[MediaStreamTrackState]
}

@js.native
trait MediaStreamTrack extends EventTarget {

  /**
   * Is a Boolean value with a value of true if the track is enabled, that is
   * allowed to render the media source stream; or false if it is disabled,
   * that is not rendering the media source stream but silence and blackness.
   * If the track has been disconnected, this value can be changed but has no
   * more effect.
   *
   * MDN
   */
  var enabled: Boolean = js.native

  /**
   * Returns a DOMString containing a unique identifier (GUID) for the
   * track; it is generated by the browser.
   *
   * MDN
   */
  val id: String = js.native

  /**
   * Returns a DOMString set to "audio" if the track is an audio track
   * and to "video", if it is a video track. It doesn't change if the track is
   * deassociated from its source.
   *
   * MDN
   */
  val kind: String = js.native

  /**
   * Returns a DOMString containing a user agent-assigned label that
   * identifies the track source, as in "internal microphone". The string may
   * be left empty and is empty as long as no source has been connected. When
   * the track is deassociated from its source, the label is not changed.
   *
   * MDN
   */
  val label: String = js.native

  /**
   * Returns a Boolean value with a value of true if the track is
   * muted, false otherwise.
   *
   * MDN
   */
  val muted: Boolean = js.native

  /**
   * Returns a Boolean value with a value of true if the track is
   * (such a video file source or a camera that settings can't be
   * modified),false otherwise.
   *
   * MDN
   */
  val readonly: Boolean = js.native

  /**
   * Returns an enumerated value giving the status of the track.It
   * takes one of the following values:
   *
   *    "live" which indicates that an input is connected and does its
   *    best-effort in providing real-time data. In that case, the output of
   *    data can be switched on or off using the MediaStreamTrack.enabled
   *    attribute.
   *
   *    "ended" which indicates that the input is not giving any more data
   *    and will never provide new data.
   *
   * MDN
   */
  val readyState: MediaStreamTrackState = js.native

  /**
   * Returns a boolean value with a value of true if the track is
   * sourced by a RTCPeerConnection, false otherwise.
   *
   * MDN
   */
  val remote: Boolean = js.native

  /**
   * Is a EventHandler containing the action to perform when an started event
   * is fired on the object, that is when a new MediaStreamTrack object is
   * added.
   *
   * MDN
   */
  var onstarted: js.Function1[Event, Any] = js.native

  /**
   * Is a EventHandler containing the action to perform when an mute event is
   * fired on the object, that is when the streaming is terminating.
   *
   * MDN
   */
  var onmute: js.Function1[Event, Any] = js.native

  /**
   * Is a EventHandler containing the action to perform when an unmute event
   * is fired on the object, that is when a  MediaStreamTrack object is removed
   * from it.
   *
   * MDN
   */
  var onunmute: js.Function1[Event, Any] = js.native

  /**
   * Is a EventHandler containing the action to perform when an overconstrained
   * event is fired on the object, that is when a  MediaStreamTrack object is
   * removed from it.
   *
   * MDN
   */
  var onoverconstrained: js.Function1[Event, Any] = js.native

  /**
   * Is a EventHandler containing the action to perform when an ended event is
   * fired on the object, that is when a  MediaStreamTrack object is removed
   * from it.
   *
   * MDN
   */
  var oneended: js.Function1[Event, Any] = js.native

  /**
   * getSourceInfos, static
   * Returns authorized information for all available sources.
   * No parameters.
   */
  def getSourceInfos(): js.Array[SourceInfo] = js.native

  def getConstraints(): MediaTrackConstraints = js.native

  def states(): AllVideoCapabilities | AllAudioCapabilities = js.native

  def getCapabilities(): js.Any = js.native

  override def clone(): MediaStreamTrack = js.native

  def applyConstraints(
      constraints: MediaTrackConstraints): js.Promise[Unit] = js.native

  def getSettings(): js.Any = js.native

  /**
   * Stops playing the source associated to the track, both the source and the
   * track are deassociated. The track state is set to ended.
   *
   * MDN
   */
  def stop(): Unit = js.native
}

@js.native
trait AllVideoCapabilities extends js.Object {
  // TODO:...
}

@js.native
trait AllAudioCapabilities extends js.Object {
  // TODO:...
}

@js.native
trait MediaTrackConstraintSet extends js.Object {
  var width: Double = js.native
  var height: Double = js.native
  var aspectRatio: Double = js.native
  var frameRate: Double = js.native
  var facingMode: String = js.native
  var volume: Double = js.native
  var sampleRate: Double = js.native
  var sampleSize: Double = js.native
  var echoCancellation: Boolean = js.native
  var deviceId: String = js.native
  var groupId: String = js.native
}

object MediaTrackConstraintSet {
  @inline
  def apply(
      width: js.UndefOr[Double] = js.undefined,
      height: js.UndefOr[Double] = js.undefined,
      aspectRatio: js.UndefOr[Double] = js.undefined,
      frameRate: js.UndefOr[Double] = js.undefined,
      facingMode: js.UndefOr[String] = js.undefined,
      volume: js.UndefOr[Double] = js.undefined,
      sampleRate: js.UndefOr[Double] = js.undefined,
      sampleSize: js.UndefOr[Double] = js.undefined,
      echoCancellation: js.UndefOr[Boolean] = js.undefined,
      deviceId: js.UndefOr[String] = js.undefined,
      groupId: js.UndefOr[String] = js.undefined
  ): MediaTrackConstraintSet = {
    val result = js.Dynamic.literal()
    width.foreach(result.width = _)
    height.foreach(result.height = _)
    aspectRatio.foreach(result.aspectRatio = _)
    frameRate.foreach(result.frameRate = _)
    facingMode.foreach(result.facingMode = _)
    volume.foreach(result.volume = _)
    sampleRate.foreach(result.sampleRate = _)
    sampleSize.foreach(result.sampleSize = _)
    echoCancellation.foreach(result.echoCancellation = _)
    deviceId.foreach(result.deviceId = _)
    groupId.foreach(result.groupId = _)
    result.asInstanceOf[MediaTrackConstraintSet]
  }
}

@js.native
trait MediaTrackConstraints extends MediaTrackConstraintSet {
  var advanced: js.Array[MediaTrackConstraintSet] = js.native
}

object MediaTrackConstraints {
  @inline
  def apply(
      advanced: js.UndefOr[js.Array[MediaTrackConstraintSet]] = js.undefined
  ): MediaTrackConstraints = {
    val result = js.Dynamic.literal()
    advanced.foreach(result.advanced = _)
    result.asInstanceOf[MediaTrackConstraints]
  }
}

@js.native
trait SourceInfo extends js.Object {
  var sourceId: String = js.native
  var kind: String = js.native
  var label: String = js.native
}

object SourceInfo {
  @inline
  def apply(
      sourceId: js.UndefOr[Boolean] = js.undefined,
      kind: js.UndefOr[String] = js.undefined,
      label: js.UndefOr[String] = js.undefined
  ): SourceInfo = {
    val result = js.Dynamic.literal()
    sourceId.foreach(result.sourceId = _)
    kind.foreach(result.kind = _)
    label.foreach(result.label = _)
    result.asInstanceOf[SourceInfo]
  }
}

object MediaStreamTrack {

  @inline
  def apply(
      enabled: js.UndefOr[Boolean] = js.undefined,
      id: js.UndefOr[String] = js.undefined,
      kind: js.UndefOr[String] = js.undefined,
      label: js.UndefOr[String] = js.undefined,
      muted: js.UndefOr[Boolean] = js.undefined,
      readonly: js.UndefOr[Boolean] = js.undefined,
      readyState: js.UndefOr[String] = js.undefined,
      remote: js.UndefOr[Boolean] = js.undefined,
      onstarted: js.UndefOr[js.Function0[Any]] = js.undefined,
      onmute: js.UndefOr[js.Function0[Any]] = js.undefined,
      onunmute: js.UndefOr[js.Function0[Any]] = js.undefined,
      onoverconstrained: js.UndefOr[js.Function0[Any]] = js.undefined,
      oneended: js.UndefOr[js.Function0[Any]] = js.undefined
  ): MediaStreamTrack = {
    val result = js.Dynamic.literal()
    enabled.foreach(result.enabled = _)
    id.foreach(result.id = _)
    kind.foreach(result.kind = _)
    label.foreach(result.label = _)
    muted.foreach(result.muted = _)
    readonly.foreach(result.readonly = _)
    readyState.foreach(result.readyState = _)
    remote.foreach(result.remote = _)
    onstarted.foreach(result.onstarted = _)
    onmute.foreach(result.onmute = _)
    onunmute.foreach(result.onunmute = _)
    onoverconstrained.foreach(result.onoverconstrained = _)
    oneended.foreach(result.oneended = _)
    result.asInstanceOf[MediaStreamTrack]
  }
}

@js.native
trait MediaStreamConstraints extends js.Object {
  var video: Boolean | MediaTrackConstraints = js.native
  var audio: Boolean | MediaTrackConstraints = js.native
  var peerIdentity: String = js.native
}

object MediaStreamConstraints {
  @inline
  def apply(
      video: js.UndefOr[Boolean | MediaTrackConstraints] = js.undefined,
      audio: js.UndefOr[Boolean | MediaTrackConstraints] = js.undefined,
      peerIdentity: js.UndefOr[String] = js.undefined
  ): MediaStreamConstraints = {
    val result = js.Dynamic.literal()
    video.foreach(v => result.video = v.asInstanceOf[js.Any])
    audio.foreach(a => result.audio = a.asInstanceOf[js.Any])
    peerIdentity.foreach(result.peerIdentity = _)
    result.asInstanceOf[MediaStreamConstraints]
  }
}

@js.native
trait MediaStreamTrackEventInit extends js.Object {
  var track: MediaStreamTrack = js.native
}

object MediaStreamTrackEventInit {
  @inline
  def apply(
      track: js.UndefOr[MediaStreamTrack] = js.undefined
  ): MediaStreamTrackEventInit = {
    val result = js.Dynamic.literal()
    track.foreach(result.track = _)
    result.asInstanceOf[MediaStreamTrackEventInit]
  }
}

@js.native
class MediaStreamTrackEvent(`type`: String,
    eventInitDict: MediaStreamTrackEventInit)
    extends Event {
  val track: MediaStreamTrack = js.native
}

/**
 * see [[https://www.w3.org/TR/2015/WD-mediacapture-streams-20150212/#idl-def-MediaDeviceKind]] in W3C spec
 */
@js.native
trait MediaDeviceKind extends js.Any

object MediaDeviceKind {

  /** Represents an audio input device; for example a microphone.
   */
  val audioinput = "audioinput".asInstanceOf[MediaDeviceKind]

  /** Represents an audio output device; for example a pair of headphones.
   */
  val audiooutput = "audiooutput".asInstanceOf[MediaDeviceKind]

  /** Represents a video input device; for example a webcam.
   */
  val videoinput = "videoinput".asInstanceOf[MediaDeviceKind]
}

@js.native
trait MediaDevicesInfo extends js.Object {

  /**
   * Returns a DOMString that is an identifier for the represented device
   * that is persisted across sessions. It is un-guessable by other
   * applications and unique to the origin of the calling application. It is
   * reset when the user clears cookies (for Private Browsing, a different
   * identifier is used that is not persisted across sessions).
   *
   * MDN
   */
  val deviceId: String = js.native

  /**
   * Returns a DOMString that is a group identifier. Two devices have the same
   * group identifier if they belong to the same physical device; for example
   * a monitor with both a built-in camera and microphone.
   *
   * MDN
   */
  val groupId: String = js.native

  /**
   * enum MediaDevicesInfoKind
   * Returns an enumerated value that is either "videoinput", "audioinput"
   * or "audiooutput".
   *
   * MDN
   */
  val kind: MediaDeviceKind = js.native

  /**
   * Returns a DOMString that is a label describing this device (for example
   * "External USB Webcam"). Only available during active MediaStream use or
   * when persistent permissions have been granted.
   *
   * MDN
   */
  val label: String = js.native
}

object MediaDevicesInfo {
  @inline
  def apply(
      deviceId: js.UndefOr[String] = js.undefined,
      groupId: js.UndefOr[String] = js.undefined,
      kind: js.UndefOr[String] = js.undefined,
      label: js.UndefOr[String] = js.undefined
  ): MediaDevicesInfo = {
    val result = js.Dynamic.literal()
    deviceId.foreach(result.deviceId = _)
    groupId.foreach(result.groupId = _)
    kind.foreach(result.kind = _)
    label.foreach(result.label = _)
    result.asInstanceOf[MediaDevicesInfo]
  }
}

@js.native
trait NavigatorMediaStream extends js.Object {

  def getUserMedia(constraints: MediaStreamConstraints,
      success: js.Function1[MediaStream, Any],
      error: js.Function1[DOMError, Any]): Unit = js.native
}
