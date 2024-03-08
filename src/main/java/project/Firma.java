package project;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Firma {
    private ArrayList<Pracownik> pracownicy;
    private ArrayList<Zadanie> zadania;

    public Firma(){
        this.pracownicy = new ArrayList<>();
        this.zadania = new ArrayList<>();
    }

    public void dodajPracownika(Pracownik pracownik) {
        pracownicy.add(pracownik);
    }

    public void dodajZadanie(Zadanie zadanie) {
        zadania.add(zadanie);
    }

    public Pracownik znajdzPracownikaPoPesel(String pesel) {
        for (Pracownik pracownik : pracownicy) {
            if (pracownik.getPesel().equals(pesel))
                return pracownik;
        }
        return null;
    }

    public void podwyzkaWszystkim(double procent) {
        for (Pracownik pracownik : pracownicy) {
            pracownik.podwyzka(procent);
        }
    }

    public void ustawicPremieSpecjaliscie(Specjalista specjalista, double premia) {
        specjalista.setPremia(premia);
    }

    //przekaz null jezeli chcesz nie szukac z tym parametrem zadania
    public ArrayList<Zadanie> filtrujZadania(String nazwa, Zadanie.Status status, Pracownik pracownik) {

        return zadania.stream()
                .filter(zadanie -> nazwa == null || zadanie.getNazwa().equals(nazwa))
                .filter(zadanie -> status == null || zadanie.getStatus().equals(status))
                .filter(zadanie -> pracownik == null || zadanie.getWykonujacy() == pracownik)
                .sorted(Comparator.comparing(zadanie -> !zadanie.isPilny())).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() { // \n potrzebny dla czytelnosci
        return "Firma.\npracownicy:\n" + pracownicy + "\nzadania:\n" + zadania;
    }
}
