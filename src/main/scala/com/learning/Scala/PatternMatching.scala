package com.learning.Scala

object PatternMatching extends App {
  sealed class Creatures
  case object x
  case class Animal(name: String, Breed: Option[String]) extends Creatures
  case class Person(name: String, age:Int) extends Creatures

  val Sheru: Creatures = Animal("Sheru", Some("family"))
  val gulshan: Creatures = Person("Gulshan", 28)
  val y = Animal("Sheru", Some("a"))

  val identify = y match {
    case Animal(n, a) => println(s"Name is $n and age is $a")
    //case Person(n,a)=> println(s"Name is $n and age is $a")
    case x => Person("Gulshan", 28)
  }
  println(x)
  println(y)


  // tuples
  val tuples = List((1,2), (2,4))
  val newTuples = for{
    (firstNumber, secondNumber) <- tuples
  } yield  firstNumber * secondNumber
  println(newTuples)
}
