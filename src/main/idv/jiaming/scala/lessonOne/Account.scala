package idv.jiaming.scala.lessonOne


/**
 * Initializing an Account instance
 * Specifying account ID and Name
 * Deposit
 * Withdraw
 * Check the balance 
 *
 */
class Account(acctID: Int, acctName: String) {
  val id = acctID
  val name = acctName
  
  private var bal :Int = _
  def deposit(amount: Int){
    require(amount>0)
    bal += amount
  }
  
  def withdraw(amount: Int){
    require(amount>0)
    if(amount <= bal){
      bal -= amount
    }else{
      throw new RuntimeException("No enough balance...")
    }
  }
  
  def balance = bal
}