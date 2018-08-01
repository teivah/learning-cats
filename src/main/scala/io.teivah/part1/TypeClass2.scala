package io.teivah.part1

//sealed trait Result
//
//final case class ResultInt(v: Int) extends Result
//
//trait Computation[A] {
//  def compute(v1: A, v2: A): Json
//}
//
//// Singleton
//object Result {
//  def calculate[A](v1: A, v2: A)(implicit c: Computation[A]): Json = c.compute(v1, v2)
//}
//
//object ResultInstances {
//  implicit val intResult: Computation[Int] =
//    (v1: Int, v2: Int) => ResultInt(v1 + v2)
//}
//
//// Extension method
//object JsonSyntax {
//
//  implicit class JsonWriterOps[A](value: A) {
//    def toJson(implicit w: Computation[A]): Json = w.compute(value)
//  }
//
//}
//
//object TypeClass2 {
//  def main(args: Array[String]): Unit = {
//    import JsonSyntax._
//    import JsonWriterInstancesA._
//    import ResultInstances._
//
//    val person = Json.toJson(Person("teivah", 30))
//    println(person)
//
//    val int = Json.toJson(4)
//    println(int)
//
//    val double = Json.toJson(4.1)
//    println(double)
//
//    val json1 = Person("a", 1).toJson
//    println(json1)
//
//    val json2 = 4.toJson
//    println(json2)
//  }
//}
//
