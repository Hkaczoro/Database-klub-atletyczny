package Example.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Kategorie_wiekowe_Manage {

    public static void main(String[] args) {
        SpringApplication.run(Kategorie_wiekowe_Manage.class, args);
        Kategorie_wiekowe katwiek = new Kategorie_wiekowe();
        System.out.println(katwiek.toString());
    }

}
