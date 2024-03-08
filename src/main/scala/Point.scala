trait Debug {
  def debugVars(): Unit = {
    val fields = this.getClass.getDeclaredFields
    fields.foreach{ field =>
      field.setAccessible(true)
      println("Field: " + field.getName + " => " + field.getType + ", " + field.get(this))}
  }
}

class Point(xv: Int, yv: Int) extends Debug {
  var x: Int = xv
  var y: Int = yv
  var a: String = "test"
}

object Point {
  def main(args: Array[String]): Unit = {
    val point = new Point(3, 4)
    point.debugVars()
  }
}