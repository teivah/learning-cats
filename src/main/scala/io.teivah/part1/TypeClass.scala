package io.teivah.part1

sealed trait Json

final case class JsObject(get: Map[String, Json]) extends Json

final case class JsString(get: String) extends Json

final case class JsInt(get: Int) extends Json

final case class JsDouble(get: Double) extends Json

case object JsNull extends Json

trait JsonWriter[A] {
  def write(value: A): Json
}

// Singleton
object Json {
  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.write(value)
}

final case class Person(name: String, age: Int)

object JsonWriterInstancesA {
  implicit val stringWriter: JsonWriter[String] =
    (value: String) => JsString(value)

  implicit val intWriter: JsonWriter[Int] =
    (value: Int) => JsInt(value)

  implicit val personWriter: JsonWriter[Person] =
    (value: Person) => JsObject(Map(
      "name" -> JsString(value.name),
      "age" -> JsInt(value.age)
    ))
}

object JsonWriterInstancesB {
  implicit val doubleWriter: JsonWriter[Double] =
    (value: Double) => JsDouble(value)
}

// Extension method
object JsonSyntax {

  implicit class JsonWriterOps[A](value: A) {
    def toJson(implicit w: JsonWriter[A]): Json = w.write(value)
  }

}

object TypeClass {
  def main(args: Array[String]): Unit = {
    import JsonSyntax._
    import JsonWriterInstancesA._
    import JsonWriterInstancesB._

    val person = Json.toJson(Person("teivah", 30))
    println(person)

    val int = Json.toJson(4)
    println(int)

    val double = Json.toJson(4.1)
    println(double)

    val json1 = Person("a", 1).toJson
    println(json1)

    val json2 = 4.toJson
    println(json2)
  }
}

