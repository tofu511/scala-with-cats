package introduction

object PrintableInstances {
  implicit val stringPrinter: Printable[String] =
    new Printable[String] {
      override def format(value: String): String = value
    }

  implicit val intPrinter: Printable[Int] =
    new Printable[Int] {
      override def format(value: Int): String = value.toString
    }

  implicit val catPrinter: Printable[Cat] =
    new Printable[Cat] {
      override def format(value: Cat): String = s"${value.name} is a ${value.age} year-old ${value.color} cat."
    }

}
