package Example.Test;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Trenerzy {

    private int idTrenera;
    private String imie;
    private String nazwisko;
    private String dyscyplina;
    private String pesel;
    private int pensja;

    public Trenerzy() {
    }

    public Trenerzy(int idTrenera, String imie, String nazwisko, String dyscyplina, String pesel, int pensja) {
        this.idTrenera = idTrenera;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dyscyplina = dyscyplina;
        this.pesel = pesel;
        this.pensja = pensja;
    }

    public int getIdTrenera() {
        return idTrenera;
    }

    public void setIdTrenera(int idTrenera) {
        this.idTrenera = idTrenera;
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
