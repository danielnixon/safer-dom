package org.danielnixon.saferdom.impl

import org.scalajs.dom.raw._

import scala.scalajs.js

package object html {

  /**
    * @see https://html.spec.whatwg.org/multipage/dom.html#the-document-object
    * @see https://dom.spec.whatwg.org/#interface-document
    */
  implicit class SaferHTMLDocument(val value: HTMLDocument) extends AnyVal {
    /**
      * In browsers returns the window object associated with the document or null if none
      * available.
      *
      * MDN
      */
    def defaultViewOpt: Option[Window] = Option(value.defaultView)

    /**
      * Returns the &lt;head&gt; element of the current document. If there are more than one
      * &lt;head&gt; elements, the first one is returned.
      *
      * MDN
      */
    def headOpt: Option[HTMLHeadElement] = Option(value.head)

    /**
      * Returns the &lt;body&gt; or &lt;frameset&gt; node of the current document, or null if no such
      * element exists.
      *
      * MDN
      */
    def bodyOpt: Option[HTMLElement] = Option(value.body)

    /**
      * Returns the currently focused element, that is, the element that will get
      * keystroke events if the user types any. This attribute is read only.
      *
      * MDN
      */
    def activeElementOpt: Option[Element] = Option(value.activeElement)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/tables.html#the-table-element
    */
  implicit class SaferHTMLTableElement(val value: HTMLTableElement) extends AnyVal {
    /**
      * Is an HTMLTableSectionElement representing the first &lt;tfoot&gt; that is a child of
      * the element, or null if none is found. When set, if the object doesn't represent a
      * &lt;tfoot&gt;, a DOMException with the HierarchyRequestError name is thrown. If a
      * correct object is given, it is inserted in the tree immediately before the first
      * element that is neither a &lt;caption&gt;, a &lt;colgroup&gt;, nor a &lt;thead&gt;, or as the last
      * child if there is no such element, and the first &lt;tfoot&gt; that is a child of this
      * element is removed from the tree, if any.
      *
      * MDN
      */
    def tFootOpt: Option[HTMLTableSectionElement] = Option(value.tFoot)

    /**
      * Is an HTMLTableCaptionElement representing the first &lt;caption&gt; that is a child of
      * the element, or null if none is found. When set, if the object doesn't represent a
      * &lt;caption&gt;, a DOMException with the HierarchyRequestError name is thrown. If a
      * correct object is given, it is inserted in the tree as the first child of this element
      * and the first &lt;caption&gt; that is a child of this element is removed from the tree, if
      * any.
      *
      * MDN
      */
    def captionOpt: Option[HTMLTableCaptionElement] = Option(value.caption)

    /**
      * Is an HTMLTableSectionElement representing the first &lt;thead&gt; that is a child of
      * the element, or null if none is found. When set, if the object doesn't represent a
      * &lt;thead&gt;, a DOMException with the HierarchyRequestError name is thrown. If a
      * correct object is given, it is inserted in the tree immediately before the first
      * element that is neither a &lt;caption&gt;, nor a &lt;colgroup&gt;, or as the last child if there
      * is no such element, and the first &lt;thead&gt; that is a child of this element is removed
      * from the tree, if any.
      *
      * MDN
      */
    def tHeadOpt: Option[HTMLTableSectionElement] = Option(value.tHead)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/forms.html#htmlselectelement
    */
  implicit class SaferHTMLSelectElement(val value: HTMLSelectElement) extends AnyVal {
    /**
      * The form that this element is associated with. If this element is a descendant of a
      * form element, then this attribute is the ID of that form element. If the element is
      * not a descendant of a form element, then: HTML5 The attribute can be the ID of any form
      * element in the same document. HTML 4 The attribute is null. Read only.
      *
      * MDN
      */
    def formOpt: Option[HTMLFormElement] = Option(value.form)

    // TODO: Fix underlying types in HTMLSelectElement.
    def itemOpt(index: Int): Option[Element] = {
      Option(value.asInstanceOf[js.Dynamic].item(index).asInstanceOf[Element])
    }

    // TODO: Fix underlying types in HTMLSelectElement.
    def namedItemOpt(name: String): Option[HTMLOptionElement] = {
      Option(value.namedItem(name).asInstanceOf[HTMLOptionElement])
    }

    // TODO: Fix underlying types in HTMLSelectElement.
    def applyOpt(index: Int): Option[Element] = {
      Option(value.asInstanceOf[js.Dynamic].apply(index).asInstanceOf[Element])
    }
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/forms.html#the-option-element
    */
  implicit class SaferHTMLOptionElement(val value: HTMLOptionElement) extends AnyVal {
    /**
      * If the option is a descendant of a &lt;select&gt; element, then this property has the same
      * value as the form property of the corresponding HTMLSelectElement object;
      * otherwise, it is null.
      *
      * MDN
      */
    def formOpt: Option[HTMLFormElement] = Option(value.form)
  }

  /**
    * @see https://dom.spec.whatwg.org/#htmlcollection
    */
  implicit class SaferHTMLCollection(val value: HTMLCollection) extends AnyVal {
    /**
      * Returns the specific node whose ID or, as a fallback, name matches the string
      * specified by name. Matching by name is only done as a last resort, only in HTML, and
      * only if the referenced element supports the name attribute. Returns null if no node
      * exists by the given name.
      *
      * MDN
      */
    def namedItemOpt(name: String): Option[Element] = Option(value.namedItem(name))
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/forms.html#the-button-element
    */
  implicit class SaferHTMLButtonElement(val value: HTMLButtonElement) extends AnyVal {
    /**
      * The form that this button is associated with. If the button is a descendant of a form
      * element, then this attribute is the ID of that form element. If the button is not a
      * descendant of a form element, then the attribute can be the ID of any form element in
      * the same document it is related to, or the null value if none matches.
      *
      * MDN
      */
    def formOpt: Option[HTMLFormElement] = Option(value.form)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/forms.html#the-label-element
    */
  implicit class SaferHTMLLabelElement(val value: HTMLLabelElement) extends AnyVal {
    def form: Option[HTMLFormElement] = Option(value.form)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/forms.html#the-legend-element
    */
  implicit class SaferHTMLLegendElement(val value: HTMLLegendElement) extends AnyVal {
    def formOpt: Option[HTMLFormElement] = Option(value.form)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/embedded-content.html#the-iframe-element
    */
  implicit class SaferHTMLIFrameElement(val value: HTMLIFrameElement) extends AnyVal {
    /**
      * The window proxy for the nested browsing context.
      *
      * MDN
      */
    def contentWindowOpt: Option[Window] = Option(value.contentWindow)

    /**
      * The active document in the inline frame's nested browsing context.
      *
      * MDN
      */
    def contentDocumentOpt: Option[Document] = Option(value.contentDocument)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/forms.html#the-input-element
    */
  implicit class SaferHTMLInputElement(val value: HTMLInputElement) extends AnyVal {
    /**
      * The containing form element, if this element is in a form. If this element is not
      * contained in a form element: HTML5 this can be the id attribute of any &lt;form&gt; element
      * in the same document. Even if the attribute is set on &lt;input&gt;, this property will be
      * null, if it isn't the id of a &lt;form&gt; element. HTML 4 this must be null.
      *
      * MDN
      */
    def formOpt: Option[HTMLFormElement] = Option(value.form)

    def filesOpt: Option[FileList] = Option(value.files)

    /**
      * Identifies a list of pre-defined options to suggest to the user. The value must be
      * the id of a &lt;datalist&gt; element in the same document. The browser displays only
      * options that are valid values for this input element. This attribute is ignored
      * when the type attribute's value is hidden, checkbox, radio, file, or a button type.
      *
      * MDN
      */
    def listOpt: Option[HTMLElement] = Option(value.list)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/forms.html#the-textarea-element
    */
  implicit class SaferHTMLTextAreaElement(val value: HTMLTextAreaElement) extends AnyVal {
    /**
      * The containing form element, if this element is in a form. If this element is not
      * contained in a form element, it can be the id attribute of any &lt;form&gt; element in the
      * same document or the value null.
      *
      * MDN
      */
    def formOpt: Option[HTMLFormElement] = Option(value.form)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/embedded-content.html#htmlmediaelement
    */
  implicit class SaferHTMLMediaElement(val value: HTMLMediaElement) extends AnyVal {
    /**
      * The MediaError object for the most recent error, or null if there has not been an
      * error.
      *
      * MDN
      */
    def errorOpt: Option[MediaError] = Option(value.error)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/forms.html#the-fieldset-element
    */
  implicit class SaferHTMLFieldSetElement(val value: HTMLFieldSetElement) extends AnyVal {
    /**
      * The containing form element, if this element is in a form. If the button is not a
      * descendant of a form element, then the attribute can be the ID of any form element in
      * the same document it is related to, or the null value if none matches.
      *
      * MDN
      */
    def formOpt: Option[HTMLFormElement] = Option(value.form)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/dom.html#htmlelement
    */
  implicit class SaferHTMLElement(val value: HTMLElement) extends AnyVal {

    /**
      * Returns an Element that is the parent of this node. If the node has no parent, or if
      * that parent is not an Element, this property returns null.
      *
      * MDN
      */
    def parentElementOpt: Option[Element] = Option(value.parentElement)

    /**
      * Returns the Document that this node belongs to. If no document is associated with
      * it, returns null.
      *
      * MDN
      *
      * This is defined on Node; we override it here because we know (from the fact that this
      * is an HTMLElement) that we are getting an HTMLDocument here.
      */
    def ownerDocumentOpt: Option[HTMLDocument] = Option(value.ownerDocument)
  }

  /**
    * @see https://html.spec.whatwg.org/multipage/embedded-content.html#the-object-element
    */
  implicit class SaferHTMLObjectElement(val value: HTMLObjectElement) extends AnyVal {
    /**
      * The object element's form owner, or null if there isn't one.
      *
      * MDN
      */
    def formOpt: Option[HTMLFormElement] = Option(value.form)

    /**
      * The active document of the object element's nested browsing context, if any;
      * otherwise null.
      *
      * MDN
      */
    def contentDocumentOpt: Option[Document] = Option(value.contentDocument)
  }
}
