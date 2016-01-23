package idv.jiaming.scala.lessonOne

/**
 * 
 * Requesting services
 * Singleton
 */

class Resources{
  private var svcList:List[String] = List()  
  def service(svcName:String) = {
       
    svcList = svcName::svcList
    println("request "+svcName+" is in processing...")
    
  }
  
  def getSvc() = {
    svcList
  }
}

object Resources {
  
  private val resuorce = new Resources()
  def apply() = resuorce
}


object ResourceMain extends App{
  val svc1 = Resources().service("svc1")  
  val svc2 = Resources().service("svc2")
  
  println(Resources().getSvc())
  
}