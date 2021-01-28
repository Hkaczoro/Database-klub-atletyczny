package Example.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Kategorie_wiekowe {

	private int nr_kategorii;
	private String kategoria;
	private int minimalny_wiek;
	private int maksymalny_wiek;

	// Constructor fos superclass
	public Kategorie_wiekowe() {
	}
	// Constructor
	public Kategorie_wiekowe(int nr_kategorii, String kategoria, int minimalny_wiek, int maksymalny_wiek) {
		super();
		this.nr_kategorii = nr_kategorii;
		this.kategoria = kategoria;
		this.minimalny_wiek = minimalny_wiek;
		this.maksymalny_wiek = maksymalny_wiek;
	}
	// Getters and Setters
	public int getNr_kategorii() {
		return nr_kategorii;
	}

	public void setNr_kategorii(int nr_kategorii) {
		this.nr_kategorii = nr_kategorii;
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public int getMinimalny_wiek() {
		return minimalny_wiek;
	}

	public void setMinimalny_wiek(int minimalny_wiek) {
		this.minimalny_wiek = minimalny_wiek;
	}

	public int getMaksymalny_wiek() {
		return maksymalny_wiek;
	}

	public void setMaksymalny_wiek(int maksymalny_wiek) {
		this.maksymalny_wiek = maksymalny_wiek;
	}

	@Override
	public String toString() {
		return "Kategorie_wiekowe{" +
				"nr_kategorii=" + nr_kategorii +
				", kategoria='" + kategoria + '\'' +
				", minimalny_wiek=" + minimalny_wiek +
				", maksymalny_wiek=" + maksymalny_wiek +
				'}';
	}

	/*public static void main(String[] args) {
		SpringApplication.run(Kategorie_wiekowe.class, args);
	}*/

}
