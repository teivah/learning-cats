package io.teivah.part1

sealed trait Result

final case class ResultInt(v: Int) extends Result

trait Computation[A] {
  def compute(v1: A)(v2: A): Result
}

// Singleton
object Result {
  def calculate[A](v1: A, v2: A)(implicit c: Computation[A]): Result = c.compute(v1)(v2)
}

object ResultInstances {
  implicit val intResult: Computation[Int] =
    new Computation[Int] {
      override def compute(v1: Int)(v2: Int): Result = ResultInt(v1 + v2)
    }
}


// Extension method
object CalculationSyntax {

  implicit class CalculationImpl[A](v1: A) {
    def |+(v2: A)(implicit c: Computation[A]) = c.compute(v1)(v2)
  }

  implicit class Pow(v1: Int) {

    import scala.math.pow

    def **(v2: Int): Int = pow(v1, v2).toInt
  }

}

object TypeClass2 {
  def main(args: Array[String]): Unit = {
    import CalculationSyntax._
    import ResultInstances._

    val x = 1 |+ 3
    println(x)

    val y = 2 ** 4
    println(y)
  }
}

