package com.sumdog.addition

import org.scalatra._
// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}
//
// JSON handling support from Scalatra
import org.scalatra.json._


class AdditionServlet extends ScalatraServlet with JacksonJsonSupport {
  // Before every action runs, set the content type to be in JSON format.
  before() {
    contentType = formats("json")
  }

  get("/") {
    Error("Please send GET requests to /question")
  }
  get("/question") {
      val minParam = params.get("min")
      val maxParam = params.get("max")
      try {
        val min = minParam.get.toInt
        val max = maxParam.get.toInt
        Error("Query parameters are " + min + " and " + max)
      } catch {
        case e : Exception =>
          Error("Please include min and max url parameters between 0 and 1,000,000")
      }
  }
  // Sets up automatic case class to JSON output serialization, required by the JValueResult trait
  protected implicit lazy val jsonFormats: Formats = DefaultFormats
}
case class Error(message: String)
