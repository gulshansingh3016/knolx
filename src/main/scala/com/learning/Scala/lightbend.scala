package com.learning.Scala

object lightbend extends App {
  println(for {
    n <- 1 to 3 if n % 2 == 1
    m <- 1 to n
  } yield n * m)
}
