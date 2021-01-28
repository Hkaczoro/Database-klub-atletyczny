package Example.Test;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Trenerzy {

    private int nr_trenera;
    private String imie;
    private String nazwisko;
    private String dyscyplina;
    private String pesel;
    private int pensja;

    public Trenerzy() {
    }

    public Trenerzy(int nr_trenera, String imie, String nazwisko, String dyscyplina, String pesel, int pensja) {
        this.nr_trenera = nr_trenera;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dyscyplina = dyscyplina;
        this.pesel = pesel;
        this.pensja = pensja;
    }

    public int getNr_trenera() {
        return nr_trenera;
    }

    public void setNr_trenera(int nr_trenera) {
        this.nr_trenera = nr_trenera;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getDyscyplina() {
        return dyscyplina;
    }

    public void setDyscyplina(String dyscyplina) {
        this.dyscyplina = dyscyplina;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getPensja() {
        return pensja;
    }

    public void setPensja(int pensja) {
        this.pensja = pensja;
    }
}
