package Example.Test;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Zawodnicy {

    private int nr_zawodnika;
    private String imie;
    private String nazwisko;
    private String plec;
    private float wzrost;
    private float waga;
    private String data_urodzenia;
    private String narodowosc;
    private String pesel;
    private int numer_kategorii;
    private int numer_adresu;
    // Constructor of superclass

    // Constructor


    public Zawodnicy(int nr_zawodnika, String imie, String nazwisko, String plec, float wzrost, float waga, String data_urodzenia, String narodowosc, String pesel, int numer_kategorii, int numer_adresu) {
        super();
        this.nr_zawodnika = nr_zawodnika;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.plec = plec;
        this.wzrost = wzrost;
        this.waga = waga;
        this.data_urodzenia = data_urodzenia;
        this.narodowosc = narodowosc;
        this.pesel = pesel;
        this.numer_kategorii = numer_kategorii;
        this.numer_adresu = numer_adresu;
    }

    public int getNr_zawodnika() {
        return nr_zawodnika;
    }

    public void setNr_zawodnika(int nr_zawodnika) {
        this.nr_zawodnika = nr_zawodnika;
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

    public String getData_urodzenia() {
        return data_urodzenia;
    }

    public void setData_urodzenia(String data_urodzenia) {
        this.data_urodzenia = data_urodzenia;
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

    public int getNumer_kategorii() {
        return numer_kategorii;
    }

    public void setNumer_kategorii(int numer_kategorii) {
        this.numer_kategorii = numer_kategorii;
    }

    public int getNumer_adresu() {
        return numer_adresu;
    }

    public void setNumer_adresu(int numer_adresu) {
        this.numer_adresu = numer_adresu;
    }

    @Override
    public String toString() {
        return "Zawodnicy{" +
                "nr_zawodnika=" + nr_zawodnika +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", plec='" + plec + '\'' +
                ", wzrost=" + wzrost +
                ", waga=" + waga +
                ", data_urodzenia='" + data_urodzenia + '\'' +
                ", narodowosc='" + narodowosc + '\'' +
                ", pesel='" + pesel + '\'' +
                ", numer_kategorii=" + numer_kategorii +
                ", numer_adresu=" + numer_adresu +
                '}';
    }
}
