package com.sumdog.addition

import scala.util.Random
import org.scalatra._
// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}
import org.json4s.JsonAST._
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
        assert(min < max)
        assert(min >= 0)
        assert(max <= 1000000)
        val diff = max - min
        val addends = Seq(min + Random.nextInt(diff), min + Random.nextInt(diff))
        val sol = addends(0) + addends(1)
        val incorrect = Seq.fill(3)(Random.nextInt(2*max))
        Addition(addends, sol, incorrect)
      } catch {
        case e : Throwable  =>
          Error("Please include min and max url parameters between 0 and 1,000,000")
      }
  }
  // Sets up automatic case class to JSON output serialization, required by the JValueResult trait
  protected implicit lazy val jsonFormats: Formats = DefaultFormats
}
case class Addition(addends: Seq[Int], sol: Int, incorrect: Seq[Int])
case class Error(message: String)
