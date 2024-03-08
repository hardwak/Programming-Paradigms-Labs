package project;

public class Zadanie {

    enum Status{PRZYGOTOWANIE, W_TOKU, ZAKONCZONE}
    private String nazwa;
    private boolean pilny;
    private Status status;
    private Pracownik wykonujacy = null;

    public Zadanie(String nazwa, boolean pilny) {
        this.nazwa = nazwa;
        this.pilny = pilny;
        this.status = Status.PRZYGOTOWANIE;
    }

    public void uruchomZadanie(Pracownik wykonujacy) {
        if (!status.equals(Status.PRZYGOTOWANIE)) {
            throw new IllegalStateException("Zadanie nie jest w przygotowaniu");
        }
        this.wykonujacy = wykonujacy;
        this.status = Status.W_TOKU;
    }

    public void zakonczZadanie() {
        if (!status.equals(Status.W_TOKU)) {
            throw new IllegalStateException("Zadanie nie jest w toku");
        }
        this.status = Status.ZAKONCZONE;
    }

    @Override
    public String toString() {
        return "Zadanie: " + nazwa + ", wykonujacy: " + (wykonujacy == null ? null : wykonujacy.getNazwisko()) + ", tryb: " + (pilny ? "pilny" : "mormalny") + ", status: " + status +"\n";
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public boolean isPilny() {
        return pilny;
    }

    public void setPilny(boolean pilny) {
        this.pilny = pilny;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Pracownik getWykonujacy() {
        return wykonujacy;
    }

    public void setWykonujacy(Pracownik wykonujacy) {
        this.wykonujacy = wykonujacy;
    }
}
