package introduction

import org.scalatest.FunSuite
import cats.Eq
import cats.syntax.eq._
import cats.instances.option._
import introduction.CatEq._

class EqTest extends FunSuite {

  test("Cat Eq") {
    val cat1 = Cat("Garfield", 38, "orange and black")
    val cat2 = Cat("Heathcliff", 33, "orange and black")
    assert(Eq.eqv(cat1, cat1))
    assert(Eq.eqv(cat2, cat2))
    assert(cat1 =!= cat2)

    val optCat1 = Option(cat1)
    val optCat2 = Option.empty[Cat]
    assert(Eq.eqv(optCat1, optCat1))
    assert(Eq.eqv(optCat2, optCat2))
    assert(optCat1 =!= optCat2)
  }
}
