package project;

public class Specjalista extends Pracownik {
    private double premia;

    public Specjalista(String nazwisko, String imie, String pesel, double placa, double premia) {
        super(nazwisko, imie, pesel, placa);
        this.premia = premia;
    }

    public void podwyzkaPremii(double premia) {
        this.premia += premia;
    }

    @Override
    public String toString() {
        return "Specjalista " + imie + " " + nazwisko + ", PESEL: " + pesel + ", placa: " + placa + ", premia: " + premia + "\n";
    }

    public double getPremia() {
        return premia;
    }

    public void setPremia(double premia) {
        this.premia = premia;
    }
}
