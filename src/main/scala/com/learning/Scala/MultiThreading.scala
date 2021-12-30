package com.learning.Scala

import java.util.concurrent.Executors

object MultiThreading extends App {
  val aThread = new Thread(new Runnable {
    override def run(): Unit = println("Running in Parallel")
  })

  val runnable = new Runnable {
    override def run(): Unit = println("Running")
  }
  val aThread2 = new Thread(runnable)
  aThread2.start()
  aThread.join()

  val aThread3 = new Thread(() => (1 to 100).foreach(_ => println("Scala")))
  val aThread4 = new Thread(() => (1 until 100).foreach(_ => println("Akka")))
  aThread3.start()
  aThread4.start()

  val pools = Executors.newFixedThreadPool(10)
  pools.execute(()=> println("Scala There"))

  pools.execute(()=>{
    Thread.sleep(40)
    println("Functional")
  })

  pools.execute(()=>{
    Thread.sleep(20)
    println("Scala Functional")
  })
}
