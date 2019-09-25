package functors

import cats.Functor

sealed trait Tree[+A]
final case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
final case class Leaf[A](value: A) extends Tree[A]

object Tree {
  implicit def treeFunctor: Functor[Tree] = new Functor[Tree] {
    def map[A, B](value: Tree[A])(f: A => B): Tree[B] = value match {
      case Branch(left, right) => Branch(map(left)(f), map(right)(f))
      case Leaf(v) => Leaf(f(v))
    }

    override def lift[A, B](f: A => B): Tree[A] => Tree[B] = super.lift(f)
  }
}