package com.knoldus.json

import org.json4s._
import org.json4s.native.JsonMethods.{parse => jParser}
import org.json4s.native.Serialization.{write => jWrite}

trait JsonHelper {

  val EMPTY_STRING = ""

  implicit val formats = DefaultFormats

  protected def write[T <: AnyRef](value: T): String = jWrite(value)

  protected def parse(value: String): JValue = jParser(value)

  implicit protected def extractOrEmptyString(json: JValue): String = json match {
    case JNothing => EMPTY_STRING
    case data => data.extract[String]
  }

}

