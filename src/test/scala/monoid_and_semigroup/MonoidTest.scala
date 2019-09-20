package monoid_and_semigroup

import org.scalatest.FunSuite
import monoid_and_semigroup.Monoid._

class MonoidTest extends FunSuite {

  test("booleanAndMonoid") {
    assert(booleanAndMonoid.combine(true, true) === true)
    assert(booleanAndMonoid.combine(true, false) === false)
    assert(booleanAndMonoid.combine(false, true) === false)
    assert(booleanAndMonoid.combine(false, false) === false)
  }

  test("booleanOrMonoid") {
    assert(booleanOrMonoid.combine(true, true) === true)
    assert(booleanOrMonoid.combine(true, false) === true)
    assert(booleanOrMonoid.combine(false, true) === true)
    assert(booleanOrMonoid.combine(false, false) === false)
  }

  test("setUnionMonoid") {
    val data1 = Set(1, 2, 3, 4, 5)
    val data2 = Set(3, 4, 5, 6, 7)
    assert(setUnionMonoid.combine(data1, data2) === Set(1,2,3,4,5,6,7))
  }

  test("setIntersectMonoid") {
    val data1 = Set(1, 2, 3, 4, 5)
    val data2 = Set(3, 4, 5, 6, 7)
    assert(setIntersectMonoid.combine(data1, data2) === Set(3, 4, 5))
  }
}
