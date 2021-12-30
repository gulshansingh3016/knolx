package com.learning.Scala

import scala.util.Random

object ListSequence extends App {
  val seq: Seq[Int]= 1 until 10
  seq.foreach(println)

  val aList = List(1,2,3,4,5)
  val newList = 42 :: aList
  println(newList)

  val fill = List.fill(5)("Apples")
  println(fill)

  val array = Array(1,5,9,4,6)
  val definedLength = Array.ofDim[Int](5)
  definedLength.foreach(println)
  println(array.mkString("Scala"))

  val maxRuns = 100
  val maxcapacity = 10

  def getWriteTime(collection: Seq[Int]): Double ={
  val r = new Random
  val times = for{
    it <- 1 to maxRuns
  } yield {
    val currentTime = System.nanoTime()
    collection.updated(r.nextInt(maxcapacity), r.nextInt())
    System.nanoTime() - currentTime
  }
    times.sum * 1.0 / maxRuns
  }
  val numberList = (1 to maxcapacity).toList
  val numberVector = (1 to maxcapacity).toVector

  println(getWriteTime(newList))
  println(getWriteTime(numberVector))

}


