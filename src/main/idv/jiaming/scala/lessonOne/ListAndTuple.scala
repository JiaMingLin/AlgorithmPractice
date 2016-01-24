package idv.jiaming.scala.lessonOne

/**
 * <b>List</b>
 * <ol>
 * <li>Constructing List with Type</li>
 * <li>Printing elements in List</li>
 * <li>Comparing the Lists</li>
 * <li>Concatenating Lists</li>
 * <li>Adding element to list</li>
 * <li>Deleting elements</li>
 * </ol>
 *
 * <b>Tuple</b>
 * <ol>
 * <li>Creating Tuple</li>
 * <li>Functions return Tuples</li>
 * <li>Printing elements in Tuple</li>
 * </ol>
 */
object ListAndTuple extends App {

  // List instance
  var list = List[String]("str1", "str2", "str3")

  // Print elements in list
  prettyPrint(list) // str1, str2, str3

  // Comparing the Lists
  val listComp1 = List(1, 2, 3)
  val listComp2 = List(1, 2, 3)
  val listComp3 = List(2, 3, 4)
  println(listComp1 == listComp2) // true
  println(listComp2 == listComp3) // false  
  println(List() == Nil) // true  

  // Concatenating Lists
  val listConcat = listComp3 ::: listComp2
  prettyPrint(listConcat) // 2,3,4,1,2,3

  // Adding elements to list
  val listAdding = (9) :: (7) :: listConcat 
  prettyPrint(listAdding) //9, 7, 2, 3, 4, 1, 2, 3

  // Deleting elements in list
  val listDel = listAdding.filter(x => x != 3)
  prettyPrint(listDel) //9, 7, 2, 4, 1, 2

  // Creating Tuples    
  val tupleCreating2 = (1,"robin")
  val tupleCreating3 = (2,"Jiaming", true)
  println(tupleCreating3) // (2,Jiaming,true)
  
  val (id, name) = (1,"robin")
  println(id) // 1
  println(name) // robin
  
  // Functions return Tuples
  def info(data:String)={
    // do something...
    val id = 2
    val name = "Jiaming"
    (id, name)
  }
  val (id2, name2) = info("some information.")
  println(id2) // 2
  println(name2) // Jiaming
  
  def prettyPrint(list: List[Any]) {
    var strArray = ""
    list.foreach { x => if (strArray == "") strArray = x.toString() else strArray += ", " + x }
    println(strArray)
  }
}