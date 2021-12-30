package com.learning.Scala

object Synchronize extends App{
  case class BankAccount(var amount: Int)
   class Bank {
     def buyAccount(bankaccount: BankAccount, thing: String, price: Int ):Unit={
       bankaccount.amount -= price
     }
     def buySafeAccout(bankAccount: BankAccount, thing: String, price:Int):Unit={
       bankAccount.synchronized{
         bankAccount.amount -= price
       }
     }
     def demoBankingProblem():Unit={
       (1 to 10).foreach { _ =>
         val bankamount = BankAccount(500000)
         val thread1 = new Thread(()=> buyAccount(bankamount,"CreditCard",1000))
         val thread2 = new Thread(() => buyAccount(bankamount, "DebitCard", 2000))
         thread1.start()
         thread2.start()
         Thread.sleep(1000)
         thread1.join()
         thread2.join()
         if (bankamount.amount != 480000) println(s"Bank thread are not synchronized ${bankamount.amount}")

       }
     }
   }

}
