package Example.Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@SpringBootApplication
public class Kategorie_wiekowe_Manage {

    public static void main(String[] args) {
        SpringApplication.run(Kategorie_wiekowe.class, args);
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
        dataSource.setUsername("jjanusz");
        dataSource.setPassword("jjanusz");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");

        Kategorie_wiekoweDAO dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));
        System.out.println(dao.list());
    }

}
