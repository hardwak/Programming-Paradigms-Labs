class Pojazd(val producent: String, val model: String, val rokProdukcji: Int = -1, var numerRejestracyjny: String = "") {
  def this(producent: String, model: String) = this(producent, model, -1, "")
  def this(producent: String, model: String, rokProdukcji: Int) = this(producent, model, rokProdukcji, "")
  def this(producent: String, model: String, numerRejestracyjny: String) = this(producent, model, -1, numerRejestracyjny)

  override def toString: String = s"Producent: $producent, Model: $model, Rok produkcji: $rokProdukcji, Numer rejestracyjny: $numerRejestracyjny)"
}

object TestPojzad {
  def main(args: Array[String]): Unit = {
    val pojazd1 = new Pojazd("Toyota", "Camry")
    val pojazd2 = new Pojazd("Ford", "Focus", 2020)
    val pojazd3 = new Pojazd("Honda", "Civic", "DW 12234")
    val pojazd4 = new Pojazd("BMW", "X5", 2015, "WR 32009")

    println(pojazd1)
    println(pojazd2)
    println(pojazd3)
    println(pojazd4)
  }
}