object lab3 {
  def main(args: Array[String]): Unit = {
    println(accumulateL((a, b) => a + b, List(1, 2, 3, 4, 5, 15), 0))
    println(accumulateR((a, b) => a + b, List(1, 2, 3, 4, 5), 0))
    println(changePairs(List((1.0f, 1.0f), (2.0f, 2.0f)), List(
      (x: Float, y: Float) => (x + 2.0f, x - 2.0f),
      (x: Float, y: Float) => (x * -1.0f, y * -1.0f),
      (x: Float, y: Float) => (x * 5.0f, y - 10.0f)
    )))
  }

  def accumulateL(func: (Int, Int) => Int, list: List[Int], acc: Int): Int = {
    list.foldLeft(acc)((accum, element) => func(accum, element))
  }

  def accumulateR(func: (Int, Int) => Int, list: List[Int], acc: Int): Int = {
    list.foldRight(acc)((element, accum) => func(element, accum))
  }

  def changePairs(list: List[(Float, Float)], funcs: List[(Float, Float) => (Float, Float)]): List[(Float, Float)] = {
    list.map(point => funcs.foldLeft(point) {
      (acc, fun) => fun(acc._1, acc._2)
    })
  }
}
