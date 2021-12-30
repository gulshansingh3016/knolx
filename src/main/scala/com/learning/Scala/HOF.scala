package com.learning.Scala

object HOF extends App {
  val list = List(1,6,5,8,9,12)
  println(list.map(_ + 1))
  println(list.map(_ + " is a memeber"))

  val toPair = (x:Int) => List(x, x+1)
  println(list.flatMap(toPair))

  val numbers = List(1,2,3,4)
  val char = List('a','b','c','d')
  val colors = List("Blue", "Yellow")

 val combinators =  for{
    num <- numbers if(num % 2 == 0)
    c <- char
   co <- colors
  } yield   " " + num + c + co
  println(combinators)

  val combinator = numbers.filter(_ % 2 == 0).flatMap(n => char.flatMap(co => colors.map(c=> " "+ n + c + co)))
  println(combinator)
}
