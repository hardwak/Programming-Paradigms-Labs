object lab1 {
  def main(args: Array[String]): Unit = {
    println(zad2(List("To", "jest", "napis")))
    println(zad2(List("", "", "napisgeg")))
    println(zad2(List("To")))
    println(zad2(List()))
    println(zad2(List("To", "jest", "napis", "ktory", "sprawdzam")))
  }

  def zad2(array: List[String]): List[Int] = {
    array.map(x => x.length)
  }
}
