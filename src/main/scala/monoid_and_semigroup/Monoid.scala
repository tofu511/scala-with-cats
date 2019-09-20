package monoid_and_semigroup

import cats.syntax.monoid

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

trait Monoid[A] extends Semigroup[A] {
  def empty: A
}

object Monoid {
  def apply[A](implicit m: Monoid[A]) = monoid

  implicit val booleanAndMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = true
    override def combine(x: Boolean, y: Boolean): Boolean = x && y
  }

  implicit val booleanOrMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty: Boolean = false
    override def combine(x: Boolean, y: Boolean): Boolean = x || y
  }

  implicit def setUnionMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    override def empty: Set[A] = Set.empty
    override def combine(x: Set[A], y: Set[A]): Set[A] = x.union(y)
  }

  implicit def setIntersectMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    override def empty: Set[A] = Set.empty
    override def combine(x: Set[A], y: Set[A]): Set[A] = x.intersect(y)
  }
}
