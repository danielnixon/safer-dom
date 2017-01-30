package org.danielnixon.saferdom.implicits

import org.danielnixon.saferdom.raw._

package object css {

  /**
    * @see https://drafts.csswg.org/cssom/#the-cssstyledeclaration-interface
    */
  implicit class SaferCSSStyleDeclaration(val value: CSSStyleDeclaration) extends AnyVal {
    def parentRule: Option[CSSRule] = Option(value.parentRule)
  }

  /**
    * @see https://drafts.csswg.org/cssom/#the-stylesheet-interface
    */
  implicit class SaferCSSStyleSheet(val value: CSSStyleSheet) extends AnyVal {
    /**
      * If this style sheet is imported into the document using an `@import` rule, the
      * ownerRule property will return that CSSImportRule, otherwise it returns null.
      *
      * MDN
      */
    def ownerRule: Option[CSSRule] = Option(value.ownerRule)
  }

  /**
    * @see https://drafts.csswg.org/cssom/#the-cssrule-interface
    */
  implicit class SaferCSSRule(val value: CSSRule) extends AnyVal {
    /**
      * parentStyleSheet returns the stylesheet object in which the current rule is
      * defined.
      *
      * MDN
      */
    def parentStyleSheet: Option[CSSStyleSheet] = Option(value.parentStyleSheet)

    /**
      * Returns the containing rule, otherwise null. E.g. if this rule is a style rule
      * inside an `@media` block, the parent rule would be that CSSMediaRule.
      *
      * MDN
      */
    def parentRule: Option[CSSRule] = Option(value.parentRule)
  }

  /**
    * @see https://drafts.csswg.org/css-animations/#interface-csskeyframesrule
    */
  implicit class SaferCSSKeyframesRule(val value: CSSKeyframesRule) extends AnyVal {
    /**
      * Returns a keyframe rule corresponding to the given key. The key is a DOMString
      * containing an index of the keyframe o be returned, resolving to a number between 0
      * and 1. If no such keyframe exists, findRule returns null.
      *
      * MDN
      */
    def findRule(rule: String): Option[CSSKeyframeRule] = Option(value.findRule(rule))
  }
}
