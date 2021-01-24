package Example.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Kategorie_wiekoweDAOTest {

    private Kategorie_wiekoweDAO dao;

    @BeforeEach
    void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
        dataSource.setUsername("jjanusz");
        dataSource.setPassword("jjanusz");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));
    }

    @Test
    void list() {

        List<Kategorie_wiekowe> listKatwiek = dao.list();
        assertTrue(!listKatwiek.isEmpty());

    }

    @Test
    void save() {
        Kategorie_wiekowe kategorie_wiekowe = new Kategorie_wiekowe(4,"kameleon",20,22);
        dao.save(kategorie_wiekowe);

    }

    @Test
    void get() {
        int nr_kategorii = 29;
        Kategorie_wiekowe kategorie_wiekowe = dao.get(nr_kategorii);
        System.out.println(kategorie_wiekowe);
    }

    @Test
    void update() {
        Kategorie_wiekowe kategorie_wiekowe = new Kategorie_wiekowe();
        kategorie_wiekowe.setNr_kategorii(29);
        kategorie_wiekowe.setKategoria("mucha");
        kategorie_wiekowe.setMinimalny_wiek(3);
        kategorie_wiekowe.setMaksymalny_wiek(5);
        dao.update(kategorie_wiekowe);
    }

    @Test
    void delete() {
        int nr_kategorii = 29;
        dao.delete(nr_kategorii);
    }
}