class Time (hour: Int, minute: Int) {

  if (hour > 23 || hour < 0 || minute > 59 || minute < 0) throw new IllegalArgumentException()

  private var minutes: Int = hour * 60 + minute

  def getHour: Int = {
    minutes/60
  }

  def setHour(newHour: Int): Unit ={
    if (newHour < 0 || newHour > 23)
      throw new IllegalArgumentException()
    else
      minutes = newHour * 60 + minutes % 60
  }

  def before(other: Time): Boolean = {
    this.minutes < other.minutes
  }

  override def toString = minutes / 60 + ":" + minutes % 60

}

object TestTime {
  def main(args: Array[String]): Unit = {
    val time1 = new Time(12, 30)
    val time2 = new Time(13, 30)
    println(time1.before(time2))
    println(time1)
    println(time1.getHour)
    time1.setHour(15)
    println(time1)
    println(time1.before(time2))
  }
}
