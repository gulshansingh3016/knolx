package com.learning.Scala

class ThreadExercise {
  def inceptionThreads(maxThread:Int, i:Int = 1):Thread={
    new Thread(()=>{
      if(i< maxThread){
        val newThread = inceptionThreads(maxThread, i+1)
        newThread.start()
        newThread.join()
      }
      println(s"Scala $i")
    })
  }
  def minThread():Unit={
    var x=0
    val thread = (1 to 100).map(_ => new Thread(()=> x+1))
    thread.foreach(_.start())
  }

  def main(args: Array[String]): Unit = {
    val run = new ThreadExercise
    run.inceptionThreads(50)
  }
}
