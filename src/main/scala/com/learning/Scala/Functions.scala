package com.learning.Scala

object Functions extends App {
  def concatString:((String, String) => String) = new Function2[String,String,String]{
    override def apply(string1: String, string2: String ): String = string1  +  string2
  }
 println(concatString("Scala", "Akka"))



  val superAdder:Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
     override def apply(number1:Int):Function1[Int,Int]= new Function1[Int,Int] {
       override def apply(number2:Int):Int = number1+number2
      }

  }
 println(superAdder(3)(4))

  //anonymous function

  val doubler:Int=>Int= a => a*2

  //multiple parameter in anonymous function
  val multiple:(Int,Int) =>Int = (a:Int, b:Int)=> a+b

  //string to Int
  val stringToInt ={ (str:String)=>
    str.toInt
  }

  val anonymous = (x: Int)=>(y:Int) =>x+y
    println(anonymous(12)(6))

  def nTimes(f: Int=>Int, num:Int, x:Int):Int ={
    if(num<= 0)x
    else nTimes(f, num-1, f(x))
  }
  val fun=(x:Int) => x*2
  println(nTimes(fun,10,1))

  def nTimesBetter(f:Int=>Int, n:Int):(Int=>Int)= {
    if(n<=0)(x:Int)=> x
    else (x:Int)=> nTimesBetter(f,n-1) (f(x))
  }

  val plusOne = nTimesBetter(fun,10)
  println(plusOne(1))
}


