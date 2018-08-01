package io.teivah.part1

case class Person1(firstName: String, lastName: String)

case class Person2(name: String)

object ImplicitConversion {
  implicit def person1ToPerson2(p1: Person1): Person2 =
    Person2(p1.firstName + " " + p1.lastName)

  def printP2(p2: Person2) = println(p2)

  def main(args: Array[String]): Unit = {
    printP2(Person1("a", "b"))
  }
}
