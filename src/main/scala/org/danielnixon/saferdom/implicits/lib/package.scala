package org.danielnixon.saferdom.implicits

import org.scalajs.dom.raw._

import scala.scalajs.js

package object lib {

  /**
    * @see https://dom.spec.whatwg.org/#interface-parentnode
    */
  implicit class SaferParentNode(val value: ParentNode) extends AnyVal {
    /**
      * Returns the Element that is the first child of the object, or null if there is none.
      *
      * MDN
      */
    def firstElementChildOpt: Option[Element] = Option(value.firstElementChild)

    /**
      * Returns the Element that is the last child of the object, or null if there is none.
      *
      * MDN
      */
    def lastElementChildOpt: Option[Element] = Option(value.lastElementChild)
  }

  /**
    * @see https://www.w3.org/TR/DOM-Level-3-XPath/xpath.html#XPathResult
    * @see https://wiki.whatwg.org/wiki/DOM_XPath
    */
  implicit class SaferXPathResult(val value: XPathResult) extends AnyVal {
    def singleNodeValueOpt: Option[Node] = Option(value.singleNodeValue)

    def iterateNextOpt(): Option[Node] = Option(value.iterateNext())

    def snapshotItemOpt(index: Int): Option[Node] = Option(value.snapshotItem(index))
  }

  /**
    * @see https://dom.spec.whatwg.org/#treewalker
    */
  implicit class SaferTreeWalker(val value: TreeWalker) extends AnyVal {
    /**
      * The TreeWalker.filter read-only property returns a NodeFilter that is the
      * filtering object associated with the TreeWalker.
      *
      * MDN
      */
    def filterOpt: Option[NodeFilter] = Option(value.filter)

    /**
      * The TreeWalker.previousSibling() method moves the current Node to its previous
      * sibling, if any, and returns the found sibling. If there is no such node, return null
      * and the current node is not changed.
      *
      * MDN
      */
    def previousSiblingOpt(): Option[Node] = Option(value.previousSibling())

    /**
      * The TreeWalker.lastChild() method moves the current Node to the last visible
      * child of the current node, and returns the found child. It also moves the current
      * node to this child. If no such child exists, returns null and the current node is not
      * changed.
      *
      * MDN
      */
    def lastChildOpt(): Option[Node] = Option(value.lastChild())

    /**
      * The TreeWalker.nextSibling() method moves the current Node to its next sibling,
      * if any, and returns the found sibling. If there is no such node, return null and the
      * current node is not changed.
      *
      * MDN
      */
    def nextSiblingOpt(): Option[Node] = Option(value.nextSibling())

    /**
      * The TreeWalker.nextNode() method moves the current Node to the next visible node
      * in the document order, and returns the found node. It also moves the current node to
      * this one. If no such node exists, returns null and the current node is not changed.
      *
      * MDN
      */
    def nextNodeOpt(): Option[Node] = Option(value.nextNode())

    /**
      * The TreeWalker.parentNode() method moves the current Node to the first visible
      * ancestor node in the document order, and returns the found node. It also moves the
      * current node to this one. If no such node exists, or if it is before that the root node
      * defined at the object construction, returns null and the current node is not
      * changed.
      *
      * MDN
      */
    def parentNodeOpt(): Option[Node] = Option(value.parentNode())

    /**
      * The TreeWalker.firstChild() method moves the current Node to the first visible
      * child of the current node, and returns the found child. It also moves the current
      * node to this child. If no such child exists, returns null and the current node is not
      * changed.
      *
      * MDN
      */
    def firstChildOpt(): Option[Node] = Option(value.firstChild())

    /**
      * The TreeWalker.previousNode() method moves the current Node to the previous
      * visible node in the document order, and returns the found node. It also moves the
      * current node to this one. If no such node exists,or if it is before that the root node
      * defined at the object construction, returns null and the current node is not
      * changed.
      *
      * MDN
      */
    def previousNodeOpt(): Option[Node] = Option(value.previousNode())
  }

  /**
    * @see https://dom.spec.whatwg.org/#nondocumenttypechildnode
    */
  implicit class SaferNonDocumentTypeChildNode(val value: NonDocumentTypeChildNode) extends AnyVal {
    /**
      * The previousElementSibling read-only property returns the Element immediately prior
      * to the specified one in its parent's children list, or null if the specified element
      * is the first one in the list.
      *
      * MDN
      */
    def previousElementSiblingOpt: Option[Element] = Option(value.previousElementSibling)

    /**
      * The nextElementSibling read-only property returns the element immediately following
      * the specified one in its parent's children list, or null if the specified element is
      * the last one in the list.
      *
      * MDN
      */
    def nextElementSiblingOpt: Option[Element] = Option(value.nextElementSibling)
  }

  /**
    * @see https://dom.spec.whatwg.org/#interface-element
    */
  implicit class SaferElement(val value: Element) extends AnyVal {

    /**
      * The namespace URI of the element, or null if it is no namespace.
      *
      * MDN
      */
    def namespaceURIOpt: Option[String] = Option(value.namespaceURI)

    /**
      * A DOMString representing the namespace prefix of the element, or null if no
      * prefix is specified.
      *
      * MDN
      */
    def prefixOpt: Option[String] = Option(value.prefix)

    /**
      * getAttribute() returns the value of the named attribute on the specified element.
      * If the named attribute does not exist, the value returned will either be null or ""
      * (the empty string); see Notes for details.
      *
      * MDN
      */
    def getAttributeOpt(name: String): Option[String] = Option(value.getAttribute(name))

    /**
      * getAttributeNS returns the string value of the attribute with the specified
      * namespace and name. If the named attribute does not exist, the value returned will
      * either be null or "" (the empty string); see Notes for details.
      *
      * MDN
      */
    def getAttributeNSOpt(namespaceURI: String, localName: String): Option[String] =
      Option(value.getAttributeNS(namespaceURI, localName))

    /**
      * Returns the Attr node for the attribute with the given namespace and name.
      *
      * MDN
      */
    def getAttributeNodeNSOpt(namespaceURI: String, localName: String): Option[Attr] =
      Option(value.getAttributeNodeNS(namespaceURI, localName))

    /**
      * setAttributeNodeNS adds a new namespaced attribute node to an element.
      *
      * MDN
      */
    def setAttributeNodeNSOpt(newAttr: Attr): Option[Attr] = Option(value.setAttributeNodeNS(newAttr))

    /**
      * Returns the specified attribute of the specified element, as an Attr node.
      *
      * MDN
      */
    def getAttributeNodeOpt(name: String): Option[Attr] = Option(value.getAttributeNode(name))

    /**
      * setAttributeNode() adds a new Attr node to the specified element.
      *
      * MDN
      */
    def setAttributeNodeOpt(newAttr: Attr): Option[Attr] = Option(value.setAttributeNode(newAttr))
  }

  /**
    * @see https://dom.spec.whatwg.org/#interface-node
    */
  implicit class SaferNode(val value: Node) extends AnyVal {

    /**
      * Returns the node immediately preceding the specified one in its parent's
      * childNodes list, null if the specified node is the first in that list.
      *
      * MDN
      */
    def previousSiblingOpt: Option[Node] = Option(value.previousSibling)

    /**
      * Returns a Node that is the parent of this node. If there is no such node, like if this
      * node is the top of the tree or if doesn't participate in a tree, this property returns
      * null.
      *
      * MDN
      */
    def parentNodeOpt: Option[Node] = Option(value.parentNode)

    /**
      * Returns the node immediately following the specified one in its parent's
      * childNodes list, or null if the specified node is the last node in that list.
      *
      * MDN
      */
    def nextSiblingOpt: Option[Node] = Option(value.nextSibling)

    /**
      * Is a DOMString representing the value of an object. For most Node type, this returns
      * null and any set operation is ignored. For nodes of type TEXT_NODE (Text objects),
      * COMMENT_NODE (Comment objects), and PROCESSING_INSTRUCTION_NODE
      * (ProcessingInstruction objects), the value corresponds to the text data
      * contained in the object.
      *
      * MDN
      */
    def nodeValueOpt: Option[String] = Option(value.nodeValue)

    /**
      * Returns a Node representing the last direct child node of the node, or null if the
      * node has no child.
      *
      * MDN
      */
    def lastChildOpt: Option[Node] = Option(value.lastChild)

    /**
      * Returns the Document that this node belongs to. If no document is associated with
      * it, returns null.
      *
      * MDN
      */
    def ownerDocumentOpt: Option[Document] = Option(value.ownerDocument)

    /**
      * Returns the node's first child in the tree, or null if the node is childless. If the
      * node is a Document, it returns the first node in the list of its direct children.
      *
      * MDN
      */
    def firstChildOpt: Option[Node] = Option(value.firstChild)

    /**
      * Returns the prefix for a given namespaceURI if present, and null if not. When
      * multiple prefixes are possible, the result is implementation-dependent.
      *
      * MDN
      */
    def lookupPrefixOpt(namespaceURI: String): Option[String] = Option(value.lookupPrefix(namespaceURI))

    /**
      * Takes a prefix and returns the namespaceURI associated with it on the given node if
      * found (and null if not). Supplying null for the prefix will return the default
      * namespace.
      *
      * MDN
      */
    def lookupNamespaceURIOpt(prefix: String): Option[String] = Option(value.lookupNamespaceURI(prefix))
  }

  /**
    * @see https://w3c.github.io/uievents/#interface-mouseevent
    */
  implicit class SaferMouseEvent(val value: MouseEvent) extends AnyVal {
    /**
      * The relatedTarget property is the secondary target for the event, if there is one.
      *
      * MDN
      */
    def relatedTargetOpt: Option[EventTarget] = Option(value.relatedTarget)
  }

  /**
    * @see https://w3c.github.io/selection-api/#selection-interface
    */
  implicit class SaferSelection(val value: Selection) extends AnyVal {
    /**
      * Returns the node in which the selection begins.
      *
      * MDN
      */
    def anchorNodeOpt: Option[Node] = Option(value.anchorNode)

    /**
      * Returns the node in which the selection ends.
      *
      * MDN
      */
    def focusNodeOpt: Option[Node] = Option(value.focusNode)
  }

  /**
    * @see https://dom.spec.whatwg.org/#nodeiterator
    */
  implicit class SaferNodeIterator(val value: NodeIterator) extends AnyVal {
    /**
      * The NodeIterator.filter read-only method returns a NodeFilter object, that is an
      * object implement an acceptNode(node) method, used to screen nodes.
      *
      * MDN
      */
    def filterOpt: Option[NodeFilter] = Option(value.filter)

    /**
      * The NodeIterator.nextNode() method returns the next node in the set represented
      * by the NodeIterator and advances the position of the iterator within the set.  The
      * first call to nextNode() returns the first node in the set.
      *
      * MDN
      */
    def nextNodeOpt(): Option[Node] = Option(value.nextNode())

    /**
      * The NodeIterator.previousNode() method returns the previous node in the set
      * represented by the NodeIterator and moves the position of the iterator backwards
      * within the set.
      *
      * MDN
      */
    def previousNodeOpt(): Option[Node] = Option(value.previousNode())
  }

  /**
    * @see https://html.spec.whatwg.org/#the-window-object
    */
  implicit class SaferWindow(val value: Window) extends AnyVal {
    /**
      * Returns the element (such as &lt;iframe&gt; or &lt;object&gt;) in which the window is embedded,
      * or null if the window is top-level.
      *
      * MDN
      */
    def frameElementOpt: Option[Element] = Option(value.frameElement)
  }

  /**
    * @see https://dom.spec.whatwg.org/#interface-document
    */
  implicit class SaferDocument(val value: Document) extends AnyVal {
    /**
      * Returns the Document Type Declaration (DTD) associated with current document.
      * The returned object implements the DocumentType interface. Use
      * DOMImplementation.createDocumentType() to create a DocumentType.
      *
      * MDN
      */
    def doctypeOpt: Option[DocumentType] = Option(value.doctype)

    /**
      * Returns the Element that is the root element of the document (for example, the
      * &lt;html&gt; element for HTML documents).
      *
      * MDN
      */
    def documentElementOpt: Option[Element] = Option(value.documentElement)

    /**
      * Returns an object reference to the identified element.
      *
      * MDN
      */
    def getElementByIdOpt(elementId: String): Option[Element] = Option(value.getElementById(elementId))
  }

  /**
    * @see https://www.w3.org/TR/selectors-api/#interface-definitions
    */
  implicit class SaferNodeSelector(val value: NodeSelector) extends AnyVal {

    /**
      * Returns the first element within the document (using depth-first pre-order
      * traversal of the document's nodes) that matches the specified group of
      * selectors.
      *
      * MDN
      */
    def querySelectorOpt(selectors: String): Option[Element] = Option(value.querySelector(selectors))
  }

  /**
    * @see https://xhr.spec.whatwg.org/#interface-xmlhttprequest
    */
  implicit class SaferXMLHttpRequest(val value: XMLHttpRequest) extends AnyVal {
    /**
      * The response to the request as a DOM Document object, or null if the request was
      * unsuccessful, has not yet been sent, or cannot be parsed as XML or HTML. The response
      * is parsed as if it were a text/xml stream. When the responseType is set to "document"
      * and the request has been made asynchronously, the response is parsed as a text/html
      * stream. Note: If the server doesn't apply the text/xml Content-Type header, you
      * can use overrideMimeType()to force XMLHttpRequest to parse it as XML anyway.
      *
      * MDN
      */
    def responseXMLOpt: Option[Document] = Option(value.responseXML)

    /**
      * Returns the string containing the text of the specified header, or null if
      * either the response has not yet been received or the header doesn't exist
      * in the response.
      *
      * MDN
      */
    def getResponseHeaderOpt(header: String): Option[String] = Option(value.getResponseHeader(header))

    /**
      * The response entity body according to responseType, as an ArrayBuffer, Blob,
      * Document, JavaScript object (for "json"), or string. This is null if the request is
      * not complete or was not successful.
      *
      * MDN
      */
    def responseOpt: Option[scalajs.js.Any] = Option(value.response)
  }

  /**
    * @see https://dev.w3.org/geo/api/spec-source.html#coordinates
    */
  implicit class SaferCoordinates(val value: Coordinates) extends AnyVal {

    /**
      * The Coordinates.altitudeAccuracy read-only property is a strictly positive
      * double representing the accuracy, with a 95% confidence level, of the altitude
      * expressed in meters. This value is null if the implementation doesn't support
      * measuring altitude.
      *
      * MDN
      */
    def altitudeAccuracyOpt: Option[Double] = Option(value.altitudeAccuracy)

    /**
      * The Coordinates.speed read-only property is a double representing the velocity
      * of the device in meters per second. This value is null if the implementation is not
      * able to measure it.
      *
      * MDN
      */
    def speedOpt: Option[Double] = Option(value.speed)

    /**
      * The Coordinates.heading read-only property is a double representing the
      * direction in which the device is traveling. This value, specified in degrees,
      * indicates how far off from heading due north the device is. 0 degrees represents
      * true true north, and the direction is determined clockwise (which means that east
      * is 90 degrees and west is 270 degrees). If Coordinates.speed is 0, heading is NaN. If
      * the device is not able to provide heading information, this value is null.
      *
      * MDN
      */
    def headingOpt: Option[Double] = Option(value.heading)

    /**
      * The Coordinates.altitude read-only property is a double representing the
      * altitude of the position in meters, relative to sea level. This value is null if the
      * implementation cannot provide this data.
      *
      * MDN
      */
    def altitudeOpt: Option[Double] = Option(value.altitude)
  }

  /**
    * @see https://w3c.github.io/clipboard-apis/#clipboard-event-interfaces
    */
  implicit class SaferClipboardEvent(val value: ClipboardEvent) extends AnyVal {
    /**
      * Is a DataTransfer object containing the data affected by the user-initialed cut, copy,
      * or paste operation, along with its MIME type.
      *
      * MDN
      */
    def clipboardDataOpt: Option[DataTransfer] = Option(value.clipboardData)
  }

  /**
    * @see https://w3c.github.io/uievents/#interface-focusevent
    */
  implicit class SaferFocusEvent(val value: FocusEvent) extends AnyVal {
    /**
      * The FocusEvent.relatedTarget read-only property represents a secondary target
      * for this event, which will depend of the event itself. As in some cases (like when
      * tabbing in or out a page), this property may be set to null for security reasons.
      *
      * MDN
      */
    def relatedTargetOpt: Option[EventTarget] = Option(value.relatedTarget)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/webstorage.html#the-storage-interface
    */
  implicit class SaferStorage(val value: Storage) extends AnyVal {
    def getItemOpt(key: String): Option[String] = Option(value.getItem(key))

    def keyOpt(index: Int): Option[String] = Option(value.key(index))
  }

  /**
    * @see https://dom.spec.whatwg.org/#mutationrecord
    * @see https://www.w3.org/TR/dom/#mutationrecord
    */
  implicit class SaferMutationRecord(val value: MutationRecord) extends AnyVal {
    /**
      * Return the previous sibling of the added or removed nodes, or null.
      *
      * MDN
      */
    def previousSiblingOpt: Option[Node] = Option(value.previousSibling)

    /**
      * Return the next sibling of the added or removed nodes, or null.
      *
      * MDN
      */
    def nextSiblingOpt: Option[Node] = Option(value.nextSibling)

    /**
      * Returns the local name of the changed attribute, or null.
      *
      * MDN
      */
    def attributeNameOpt: Option[String] = Option(value.attributeName)

    /**
      * Returns the namespace of the changed attribute, or null.
      *
      * MDN
      */
    def attributeNamespaceOpt: Option[String] = Option(value.attributeNamespace)

    /**
      * The return value depends on the type. For attributes, it is the value of
      * the changed attribute before the change. For characterData, it is the data
      * of the changed node before the change. For childList, it is null.
      *
      * MDN
      */
    def oldValueOpt: Option[String] = Option(value.oldValue)
  }

  /**
    * @see https://w3c.github.io/html/editing.html#the-dragevent-interface
    * @see https://html.spec.whatwg.org/multipage/interaction.html#the-dragevent-interface
    */
  implicit class SaferDragEvent(val value: DragEvent) extends AnyVal {
    def dataTransferOpt: Option[DataTransfer] = Option(value.dataTransfer)
  }

  /**
    * @see https://w3c.github.io/html/webappapis.html#language-preferences
    * @see https://html.spec.whatwg.org/multipage/webappapis.html#navigatorlanguage
    */
  implicit class SaferNavigatorLanguage(val value: NavigatorLanguage) extends AnyVal {
    /**
      * Returns a DOMString representing the preferred language of the user,
      * usually the language of the browser UI. The null value is returned when
      * this is unknown.
      *
      * MDN
      */
    def languageOpt: Option[String] = Option(value.language)
  }

  /**
    * @see https://w3c.github.io/uievents/#interface-uievent
    */
  implicit class SaferUIEvent(val value: UIEvent) extends AnyVal {
    /**
      * A view which generated the event. Read only.
      *
      * MDN
      */
    def viewOpt: Option[Window] = Option(value.view)
  }

  /**
    * @see https://drafts.csswg.org/cssom/#the-stylesheetlist-interface
    */
  implicit class SaferStyleSheetList(val value: StyleSheetList) extends AnyVal {
    def itemOpt(index: Int): Option[StyleSheet] = Option(value.item(index))

    def applyOpt(index: Int): Option[StyleSheet] = Option(value.apply(index))
  }

  /**
    * @see https://dom.spec.whatwg.org/#interface-namednodemap
    */
  implicit class SaferNamedNodeMap(val value: NamedNodeMap) extends AnyVal {
    def itemOpt(index: Int): Option[Attr] = Option(value.item(index))

    def applyOpt(index: Int): Option[Attr] = Option(value.apply(index))

    def getNamedItemOpt(name: String): Option[Attr] = Option(value.getNamedItem(name))

    def setNamedItemOpt(arg: Attr): Option[Attr] = Option(value.setNamedItem(arg))

    def getNamedItemNSOpt(namespaceURI: String, localName: String): Option[Attr] =
      Option(value.getNamedItemNS(namespaceURI, localName))

    def setNamedItemNSOpt(arg: Attr): Option[Attr] = Option(value.setNamedItemNS(arg))
  }

  /**
    * @see https://drafts.csswg.org/cssom/#medialist
    */
  implicit class SaferMediaList(val value: MediaList) extends AnyVal {
    def itemOpt(index: Int): Option[String] = Option(value.item(index))

    def applyOpt(index: Int): Option[String] = Option(value.apply(index))
  }

  /**
    * @see https://drafts.csswg.org/cssom/#stylesheet
    */
  implicit class SaferStyleSheet(val value: StyleSheet) extends AnyVal {
    // TODO: StyleSheet#href needs to be defined.
    /**
      * Returns a DOMString representing the location of the stylesheet.
      *
      * MDN
      */
    def hrefOpt: Option[String] = Option(value.asInstanceOf[js.Dynamic].href.asInstanceOf[String])

    /**
      * ownerNode returns the node that associates this style sheet with the document.
      *
      * MDN
      */
    def ownerNodeOpt: Option[Node] = Option(value.ownerNode)

    /**
      * Returns a StyleSheet including this one, if any; returns null if there aren't any.
      *
      * MDN
      */
    def parentStyleSheetOpt: Option[StyleSheet] = Option(value.parentStyleSheet)

    /**
      * Returns a DOMString representing the advisory title of the current style sheet.
      *
      * MDN
      */
    def titleOpt: Option[String] = Option(value.title)
  }

  implicit class SaferDOMList[T](val value: DOMList[T]) extends AnyVal {
    def applyOpt(index: Int): Option[T] = Option(value.apply(index))

    def itemOpt(index: Int): Option[T] = Option(value.item(index))
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/webstorage.html#the-storageevent-interface
    */
  implicit class SaferStorageEvent(val value: StorageEvent) extends AnyVal {
    /**
      * The original value of the key. The oldValue is null when the change has been invoked
      * by storage clear() method or the key has been newly added and therefor doesn't have
      * any previous value. Read only.
      *
      * MDN
      */
    def oldValueOpt: Option[scalajs.js.Any] = Option(value.oldValue)

    /**
      * The new value of the key. The newValue is null when the change has been invoked by
      * storage clear() method or the key has been removed from the storage. Read only.
      *
      * MDN
      */
    def newValueOpt: Option[scalajs.js.Any] = Option(value.newValue)

    /**
      * Represents the Storage object that was affected. Read only.
      *
      * MDN
      */
    def storageAreaOpt: Option[Storage] = Option(value.storageArea)

    /**
      * Represents the key changed. The key attribute is null when the change is caused by
      * the storage clear() method. Read only.
      *
      * MDN
      */
    def keyOpt: Option[String] = Option(value.key)
  }

  /**
    * @see https://dom.spec.whatwg.org/#interface-attr
    */
  implicit class SaferAttr(val value: Attr) extends AnyVal {
    /**
      * The element holding the attribute.
      *
      * MDN
      */
    def ownerElementOpt: Option[Element] = Option(value.ownerElement)

    def namespaceURIOpt: Option[String] = Option(value.namespaceURI)

    def prefixOpt: Option[String] = Option(value.prefix)
  }

  /**
    * @see https://drafts.csswg.org/cssom/#the-linkstyle-interface
    */
  implicit class SaferLinkStyle(val value: LinkStyle) extends AnyVal {

    /**
      * Returns the StyleSheet object associated with the given element, or null if there
      * is none.
      *
      * MDN
      */
    def sheetOpt: Option[StyleSheet] = Option(value.sheet)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/embedded-content.html#audiotracklist
    */
  implicit class SaferAudioTrackList(val value: AudioTrackList) extends AnyVal {
    def getTrackByIdOpt(id: String): Option[AudioTrack] = Option(value.getTrackById(id))
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/embedded-content.html#texttrackcuelist
    */
  implicit class SaferTextTrackCueList(val value: TextTrackCueList) extends AnyVal {
    def getCueByIdOpt(id: String): Option[TextTrackCue] = Option(value.getCueById(id))
  }

  /**
    * @see https://w3c.github.io/FileAPI/#dfn-filereader
    */
  implicit class SaferFileReader(val value: FileReader) extends AnyVal {
    /**
      * A DOMError representing the error that occurred while reading the file.
      *
      * MDN
      */
    def errorOpt: Option[DOMError] = Option(value.error)

    /**
      * The file's contents. This property is only valid after the read operation is
      * complete, and the format of the data depends on which of the methods was used to
      * initiate the read operation.
      *
      * MDN
      */
    def resultOpt: Option[scalajs.js.Any] = Option(value.result)
  }

}
