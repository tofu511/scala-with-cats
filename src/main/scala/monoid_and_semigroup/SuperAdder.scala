package monoid_and_semigroup

import cats.syntax.semigroup._

case class Order(totalCost: Double, quality: Double)

object SuperAdder {

  def add[A](items: List[A])(implicit m: cats.Monoid[A]): A = items.foldLeft(m.empty)(_ |+| _)

  implicit val orderMonoid: cats.Monoid[Order] = new cats.Monoid[Order] {
    override def empty: Order = Order(0, 0)
    override def combine(x: Order, y: Order): Order = Order(x.totalCost + y.totalCost, x.quality + y.quality)
  }


}
