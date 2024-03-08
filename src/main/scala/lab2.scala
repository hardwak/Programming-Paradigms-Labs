object lab2 {
  def main(args: Array[String]): Unit = {
    println(cut(List(5, 6, 7, 8)))
    println(group(List("1","1","1","1","2","3","3","1","1","4","4")))
  }
  def cut[A](array: List[A]): List[A] = array match {
    case Nil | _ :: Nil => Nil //pusta lub 1 elementowa
    case _ :: tail => tail.init
  }

  def group(array: List[String]): List[(String, Int)] = {
    def helper(result: List[(String, Int)], actual: String, counter: Int, rest: List[String]): List[(String, Int)] = rest match {
      case Nil => result.appended((actual, counter))
      case hd :: tl =>
        if (hd == actual)
          helper(result, hd, counter + 1, tl)
        else
          helper(result.appended((actual, counter)), hd, 1, tl)
    }

    if (array == Nil) Nil
    else helper(Nil, array.head, 1, array.tail)

  }
}
