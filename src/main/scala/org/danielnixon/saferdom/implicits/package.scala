package org.danielnixon.saferdom

import org.danielnixon.saferdom.impl.css._
import org.danielnixon.saferdom.impl.html._
import org.danielnixon.saferdom.impl.lib._
import org.scalajs.dom.raw._

import scala.language.implicitConversions

package object implicits {
  // lib
  implicit def saferParentNode(value: ParentNode): SaferParentNode = new SaferParentNode(value)
  implicit def saferXPathResult(value: XPathResult): SaferXPathResult = new SaferXPathResult(value)
  implicit def saferTreeWalker(value: TreeWalker): SaferTreeWalker = new SaferTreeWalker(value)
  implicit def saferNonDocumentTypeChildNode(value: NonDocumentTypeChildNode): SaferNonDocumentTypeChildNode = new SaferNonDocumentTypeChildNode(value)
  implicit def saferElement(value: Element): SaferElement = new SaferElement(value)
  implicit def saferNode(value: Node): SaferNode = new SaferNode(value)
  implicit def saferMouseEvent(value: MouseEvent): SaferMouseEvent = new SaferMouseEvent(value)
  implicit def saferSelection(value: Selection): SaferSelection = new SaferSelection(value)
  implicit def saferNodeIterator(value: NodeIterator): SaferNodeIterator = new SaferNodeIterator(value)
  implicit def saferWindow(value: Window): SaferWindow = new SaferWindow(value)
  implicit def saferDocument(value: Document): SaferDocument = new SaferDocument(value)
  implicit def saferNodeSelector(value: NodeSelector): SaferNodeSelector = new SaferNodeSelector(value)
  implicit def saferXMLHttpRequest(value: XMLHttpRequest): SaferXMLHttpRequest = new SaferXMLHttpRequest(value)
  implicit def saferCoordinates(value: Coordinates): SaferCoordinates = new SaferCoordinates(value)
  implicit def saferClipboardEvent(value: ClipboardEvent): SaferClipboardEvent = new SaferClipboardEvent(value)
  implicit def saferFocusEvent(value: FocusEvent): SaferFocusEvent = new SaferFocusEvent(value)
  implicit def saferStorage(value: Storage): SaferStorage = new SaferStorage(value)
  implicit def saferMutationRecord(value: MutationRecord): SaferMutationRecord = new SaferMutationRecord(value)
  implicit def saferDragEvent(value: DragEvent): SaferDragEvent = new SaferDragEvent(value)
  implicit def saferNavigatorLanguage(value: NavigatorLanguage): SaferNavigatorLanguage = new SaferNavigatorLanguage(value)
  implicit def saferUIEvent(value: UIEvent): SaferUIEvent = new SaferUIEvent(value)
  implicit def saferStyleSheetList(value: StyleSheetList): SaferStyleSheetList = new SaferStyleSheetList(value)
  implicit def saferNamedNodeMap(value: NamedNodeMap): SaferNamedNodeMap = new SaferNamedNodeMap(value)
  implicit def saferMediaList(value: MediaList): SaferMediaList = new SaferMediaList(value)
  implicit def saferStyleSheet(value: StyleSheet): SaferStyleSheet = new SaferStyleSheet(value)
  implicit def saferDOMList[T](value: DOMList[T]): SaferDOMList[T] = new SaferDOMList(value)
  implicit def saferStorageEvent(value: StorageEvent): SaferStorageEvent = new SaferStorageEvent(value)
  implicit def saferAttr(value: Attr): SaferAttr = new SaferAttr(value)
  implicit def saferLinkStyle(value: LinkStyle): SaferLinkStyle = new SaferLinkStyle(value)
  implicit def saferAudioTrackList(value: AudioTrackList): SaferAudioTrackList = new SaferAudioTrackList(value)
  implicit def saferTextTrackCueList(value: TextTrackCueList): SaferTextTrackCueList = new SaferTextTrackCueList(value)
  implicit def saferFileReader(value: FileReader): SaferFileReader = new SaferFileReader(value)

  // html
  implicit def saferHTMLDocument(value: HTMLDocument): SaferHTMLDocument = new SaferHTMLDocument(value)
  implicit def saferHTMLTableElement(value: HTMLTableElement): SaferHTMLTableElement = new SaferHTMLTableElement(value)
  implicit def saferHTMLSelectElement(value: HTMLSelectElement): SaferHTMLSelectElement = new SaferHTMLSelectElement(value)
  implicit def saferHTMLOptionElement(value: HTMLOptionElement): SaferHTMLOptionElement = new SaferHTMLOptionElement(value)
  implicit def saferHTMLCollection(value: HTMLCollection): SaferHTMLCollection = new SaferHTMLCollection(value)
  implicit def saferHTMLButtonElement(value: HTMLButtonElement): SaferHTMLButtonElement = new SaferHTMLButtonElement(value)
  implicit def saferHTMLLabelElement(value: HTMLLabelElement): SaferHTMLLabelElement = new SaferHTMLLabelElement(value)
  implicit def saferHTMLLegendElement(value: HTMLLegendElement): SaferHTMLLegendElement = new SaferHTMLLegendElement(value)
  implicit def saferHTMLIFrameElement(value: HTMLIFrameElement): SaferHTMLIFrameElement = new SaferHTMLIFrameElement(value)
  implicit def saferHTMLInputElement(value: HTMLInputElement): SaferHTMLInputElement = new SaferHTMLInputElement(value)
  implicit def saferHTMLTextAreaElement(value: HTMLTextAreaElement): SaferHTMLTextAreaElement = new SaferHTMLTextAreaElement(value)
  implicit def saferHTMLMediaElement(value: HTMLMediaElement): SaferHTMLMediaElement = new SaferHTMLMediaElement(value)
  implicit def saferHTMLFieldSetElement(value: HTMLFieldSetElement): SaferHTMLFieldSetElement = new SaferHTMLFieldSetElement(value)
  implicit def saferHTMLElement(value: HTMLElement): SaferHTMLElement = new SaferHTMLElement(value)
  implicit def saferHTMLObjectElement(value: HTMLObjectElement): SaferHTMLObjectElement = new SaferHTMLObjectElement(value)

  // css
  implicit def saferCSSStyleDeclaration(value: CSSStyleDeclaration): SaferCSSStyleDeclaration = new SaferCSSStyleDeclaration(value)
  implicit def saferCSSStyleSheet(value: CSSStyleSheet): SaferCSSStyleSheet = new SaferCSSStyleSheet(value)
  implicit def saferCSSRule(value: CSSRule): SaferCSSRule = new SaferCSSRule(value)
  implicit def saferCSSKeyframesRule(value: CSSKeyframesRule): SaferCSSKeyframesRule = new SaferCSSKeyframesRule(value)
}
