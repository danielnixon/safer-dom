package org.danielnixon.saferdom

/**
 * Short aliases of all the saferdom.WebGLThing classes
 */
object webgl {
  type ActiveInfo = raw.WebGLActiveInfo
  type Buffer = raw.WebGLBuffer
  type ContextAttributes = raw.WebGLContextAttributes
  type Framebuffer = raw.WebGLFramebuffer
  type Program = raw.WebGLProgram
  type Renderbuffer = raw.WebGLRenderbuffer
  type RenderingContext = raw.WebGLRenderingContext
  type Shader = raw.WebGLShader
  type ShaderPrecisionFormat = raw.WebGLShaderPrecisionFormat
  type Texture = raw.WebGLTexture
  type UniformLocation = raw.WebGLUniformLocation
  @inline def RenderingContext = raw.WebGLRenderingContext
}
