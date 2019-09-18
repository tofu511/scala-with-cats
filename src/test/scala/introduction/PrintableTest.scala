package introduction

import org.scalatest.FunSuite
import introduction.PrintableInstances._
import introduction.PrintableSyntax._

class PrintableTest extends FunSuite {

  test("Printable String") {
    val res = Printable.format("this is string")
    assert(res === "this is string")
  }

  test("Printable Int") {
    val res = Printable.format(123)
    assert(res === "123")
  }

  test("Printable Cat") {
    val res = Printable.format(Cat("tama", 2, "black"))
    assert(res === "tama is a 2 year-old black cat.")
  }

//  test("Printable String syntax") {
//    val res = "this is string".format
//    assert(res === "this is string")
//  }

  test("Printable Int syntax") {
    val res = 123.format
    assert(res === "123")
  }

  test("Printable Cat syntax") {
    val res = Cat("tama", 2, "black").format
    assert(res === "tama is a 2 year-old black cat.")
  }
}
