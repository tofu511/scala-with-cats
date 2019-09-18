package introduction

import org.scalatest.FunSuite
import cats.syntax.show._
import introduction.CatShow._

class ShowTest extends FunSuite {

  test("CatShow") {
    val res = Cat("tama", 2, "black").show
    assert(res === "tama is a 2 year-old black cat.")
  }
}
