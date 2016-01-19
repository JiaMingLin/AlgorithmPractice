package idv.jiaming.ScoreRank

object ScoreRankScala extends App {
  val scores = List(3, 4,78, 99, 100, 99, 6, 73, 2)
  val juni1 = (Map[Int, Int]() /: scores)(
    (dict, score) => dict ++ Map(score -> (dict.getOrElse(score, 0) + 1)))
  val sortedKey = juni1.keySet.toList.sortWith(_ < _)

  /*
   * def :\[B](z: B)(op: (Int, B) => B): B

		Applies a binary operator to all elements of this list and a start value, going right to left.
    Note: :\ is alternate syntax for foldRight; xs :\ z is the same as xs foldRight z.
    Examples:
    Note that the folding function used to compute b is equivalent to that used to compute c.
    scala> val a = LinkedList(1,2,3,4)
    a: scala.collection.mutable.LinkedList[Int] = LinkedList(1, 2, 3, 4)

    scala> val b = (a :\ 5)(_+_)
    b: Int = 15
   */
  val at = (sortedKey :\ List(1))(
    (score, acct) => (acct.head + juni1(score)) :: acct)

  println(sortedKey)
  println(at)
  
  println(sortedKey.zip(at.tail).toMap)
}