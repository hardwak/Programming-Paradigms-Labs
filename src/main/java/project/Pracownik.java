package project;

public class Pracownik {
    protected String nazwisko;
    protected String imie;
    protected String pesel;
    protected double placa;

    public Pracownik(String nazwisko, String imie, String pesel, double placa) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.pesel = pesel;
        this.placa = placa;
    }

    public void podwyzka(double procent) {
        this.placa += this.placa * procent / 100.0;
    }

    @Override
    public String toString() {
        return "Pracownik " + imie + " " + nazwisko + ", PESEL: " + pesel + ", placa: " + placa + "\n";
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public String getPesel() {
        return pesel;
    }

    public double getPlaca() {
        return placa;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setPlaca(double placa) {
        this.placa = placa;
    }
}
