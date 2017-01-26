package org.danielnixon.saferdom

import scala.scalajs.js
import scala.scalajs.js.typedarray.{ArrayBufferView, ArrayBuffer, Uint8Array}
import scala.scalajs.js.|

import scala.language.implicitConversions

package object crypto {
  val crypto = GlobalCrypto.crypto

  type BigInteger = Uint8Array

  /**
   * According to [[http://www.w3.org/TR/WebCryptoAPI/#algorithm-dictionary ¶11 Algorithm Identifier]]
   * of the WebCryptoAPI an AlgorithmIdentifier is an `object or DOMString`. We make this more precise
   * here and specify an Algorithm.
   * note: it may be that we can do only with KeyAlgorithmIdentifier and HashAlgorithmIdentifier
   */
  type AlgorithmIdentifier = Algorithm | String

  /**
   * According to [[http://www.w3.org/TR/WebCryptoAPI/#algorithm-dictionary ¶11 Algorithm Identifier]]
   * of the WebCryptoAPI an AlgorithmIdentifier is an `object or DOMString`. We make this more precise
   * here and distinguish the non overlapping classes of Key and Hash Algorithms.
   */
  type KeyAlgorithmIdentifier = KeyAlgorithm | String

  /**
   * According to [[http://www.w3.org/TR/WebCryptoAPI/#algorithm-dictionary ¶11 Algorithm Identifier]]
   * a HashAlgorithmIdentifier is an AlgorithmIdentifier. Here we distinguish between Hash and Key
   * Algorithm Identifiers. At the JS layer these have the same structure.
   */
  type HashAlgorithmIdentifier = HashAlgorithm | String

  @js.native
  sealed trait BufferSource extends js.Any

  implicit def arrayBuffer2BufferSource(b: ArrayBuffer): BufferSource =
    b.asInstanceOf[BufferSource]

  implicit def arrayBufferView2BufferSource(b: ArrayBufferView): BufferSource =
    b.asInstanceOf[BufferSource]
}
