package com.sumdog.addition

import org.scalatra.test.scalatest._

class AdditionServletTests extends ScalatraFunSuite {

  addServlet(classOf[AdditionServlet], "/*")

  test("GET / on AdditionServlet should return status 200"){
    get("/"){
      status should equal (200)
    }
  }

}
