package functors

import org.scalatest.FunSuite
import cats.Functor
import functors.Tree._

class TreeTest extends FunSuite {

  val tree = Branch(Branch(Leaf(2), Leaf(3)), Leaf(5))

  test("map for Tree") {
    val res = Functor[Tree].map(tree)(x => x * 2)

    assert(res === Branch(Branch(Leaf(4), Leaf(6)), Leaf(10)))
  }

  test("lift for Tree") {
    val func = (x: Int) => x * 2
    val func2 = Functor[Tree].lift(func)
    assert(func2(tree) === Branch(Branch(Leaf(4), Leaf(6)), Leaf(10)))
  }
}
