package project;

public class Main {
    public static void main(String[] args) {
        Firma firma = new Firma();

        System.out.println("-----------------------------------------------------");
        System.out.println(firma);
        System.out.println("-----------------------------------------------------");

        Pracownik pracownik1 = new Pracownik("kowalski", "jan", "12345678901", 3000.0);
        Pracownik pracownik2 = new Pracownik("verstapen", "max", "22334455667", 300.0);
        Pracownik pracownik3 = new Pracownik("grochowska", "ania", "00110011001", 4230.0);
        Pracownik pracownik4 = new Pracownik("kowalinski", "jaroslaw", "10101010100", 1000.0);
        Specjalista specjalista1 = new Specjalista("nowak", "mateusz", "11223344556", 15000.0, 5000.0);
        Specjalista specjalista2 = new Specjalista("vettel", "basia", "00000000001", 10.0, 27000.0);
        Specjalista specjalista3 = new Specjalista("graham", "benjamin", "00000000002", 8000.0, 9000.0);


        firma.dodajPracownika(pracownik1);
        firma.dodajPracownika(pracownik2);
        firma.dodajPracownika(pracownik3);
        firma.dodajPracownika(pracownik4);
        firma.dodajPracownika(specjalista1);
        firma.dodajPracownika(specjalista2);
        firma.dodajPracownika(specjalista3);

        Zadanie zadanie1 = new Zadanie("strona github.com", true);
        Zadanie zadanie2 = new Zadanie("przedzial czasu", false);
        Zadanie zadanie3 = new Zadanie("f1 controls", false);
        Zadanie zadanie4 = new Zadanie("fitness app", true);
        Zadanie zadanie5 = new Zadanie("render engine", false);
        Zadanie zadanie6 = new Zadanie("parkometr", false);
        Zadanie zadanie7 = new Zadanie("face recognition", true);
        Zadanie zadanie8 = new Zadanie("zegar", false);

        firma.dodajZadanie(zadanie1);
        firma.dodajZadanie(zadanie2);
        firma.dodajZadanie(zadanie3);
        firma.dodajZadanie(zadanie4);
        firma.dodajZadanie(zadanie5);
        firma.dodajZadanie(zadanie6);
        firma.dodajZadanie(zadanie7);
        firma.dodajZadanie(zadanie8);

        System.out.println("-----------------------------------------------------");
        System.out.println(firma);
        System.out.println("-----------------------------------------------------");

        pracownik1.podwyzka(10);
        pracownik4.podwyzka(100);
        specjalista1.podwyzka(10);
        specjalista3.podwyzkaPremii(200);
        pracownik2.podwyzka(50);
        specjalista2.podwyzkaPremii(34);

        System.out.println("-----------------------------------------------------");
        System.out.println(firma);
        System.out.println("-----------------------------------------------------");

        zadanie1.uruchomZadanie(pracownik1);
        zadanie1.zakonczZadanie();
        zadanie2.uruchomZadanie(specjalista1);
        zadanie4.uruchomZadanie(specjalista3);
        zadanie4.zakonczZadanie();
        zadanie5.uruchomZadanie(pracownik1);
        zadanie6.uruchomZadanie(pracownik4);
        zadanie6.zakonczZadanie();
        zadanie8.uruchomZadanie(pracownik2);

        try {
            zadanie3.zakonczZadanie();
        } catch (IllegalStateException e){
            e.printStackTrace();
        }

        System.out.println("-----------------------------------------------------");
        System.out.println(firma);
        System.out.println("-----------------------------------------------------");

        System.out.println("-----------------------------------------------------");
        System.out.println(firma.filtrujZadania(null, null, null));
        System.out.println("-----------------------------------------------------");

        System.out.println("-----------------------------------------------------");
        System.out.println(firma.filtrujZadania(null, Zadanie.Status.ZAKONCZONE, null));
        System.out.println("-----------------------------------------------------");

        System.out.println("-----------------------------------------------------");
        System.out.println(firma.filtrujZadania(null, null, pracownik1));
        System.out.println("-----------------------------------------------------");

        System.out.println("-----------------------------------------------------");
        System.out.println(firma.filtrujZadania(null, Zadanie.Status.W_TOKU, pracownik1));
        System.out.println("-----------------------------------------------------");

        System.out.println("-----------------------------------------------------");
        System.out.println(firma.filtrujZadania("zegar", null, null));
        System.out.println("-----------------------------------------------------");

    }
}

