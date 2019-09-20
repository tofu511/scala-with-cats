package monoid_and_semigroup

import org.scalatest.FunSuite
import cats.instances.int._
import cats.instances.option._
import monoid_and_semigroup.SuperAdder.orderMonoid

class SuperAdderTest extends FunSuite {

  test("list adder") {
    val data = List(1,2,3,4,5)
    assert(SuperAdder.add(data) === 15)
  }

  test("option adder") {
    val data = List(Some(1), Some(2), Some(3), None)
    assert(SuperAdder.add(data) === Some(6))
  }

  test("order adder") {
    val data = List(Order(2, 4), Order(1, 5))
    assert(SuperAdder.add(data) === Order(3, 9))
  }
}
