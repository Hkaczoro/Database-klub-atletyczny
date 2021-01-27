package Example.Test;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Zawodnicy {

    private int nrZawodnika;
    private String imie;
    private String nazwisko;
    private String plec;
    private float wzrost;
    private float waga;
    private String dataUrodzenia;
    private String narodowosc;
    private String pesel;
    private String numerAdresu;
    private String numerKategorii;

    public Zawodnicy(int nrZawodnika, String imie, String nazwisko, String plec, float wzrost, float waga, String dataUrodzenia, String narodowosc, String pesel, String numerAdresu, String numerKategorii) {
        this.nrZawodnika = nrZawodnika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.wzrost = wzrost;
        this.waga = waga;
        this.dataUrodzenia = dataUrodzenia;
        this.narodowosc = narodowosc;
        this.pesel = pesel;
        this.numerAdresu = numerAdresu;
        this.numerKategorii = numerKategorii;
    }

    public Zawodnicy(){

    }

    public int getNrZawodnika() {
        return nrZawodnika;
    }

    public void setNrZawodnika(int nrZawodnika) {
        this.nrZawodnika = nrZawodnika;
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

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public float getWzrost() {
        return wzrost;
    }

    public void setWzrost(float wzrost) {
        this.wzrost = wzrost;
    }

    public float getWaga() {
        return waga;
    }

    public void setWaga(float waga) {
        this.waga = waga;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getNarodowosc() {
        return narodowosc;
    }

    public void setNarodowosc(String narodowosc) {
        this.narodowosc = narodowosc;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getNumerAdresu() {
        return numerAdresu;
    }

    public void setNumerAdresu(String numerAdresu) {
        this.numerAdresu = numerAdresu;
    }

    public String getNumerKategorii() {
        return numerKategorii;
    }

    public void setNumerKategorii(String numerKategorii) {
        this.numerKategorii = numerKategorii;
    }
}
