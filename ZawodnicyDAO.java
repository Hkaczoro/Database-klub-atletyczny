package Example.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZawodnicyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ZawodnicyDAO(JdbcTemplate jdbcTemplate){
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Zawodnicy> list() {
        String sql = "SELECT * FROM ZAWODNICY";
        List<Zawodnicy> listZawodnicy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Zawodnicy.class));
        return listZawodnicy;
    }

    public List<String> listcol(String col) {
        String sql = "SELECT" + " " + col + " " + "FROM ZAWODNICY";
        List<String> listZawodnicy = jdbcTemplate.queryForList(sql,String.class);
        return listZawodnicy;
    }

    public void save(Zawodnicy zawodnik) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("ZAWODNICY").usingColumns("nr_Zawodnika","imie","nazwisko","plec", "wzrost", "waga", "data_Urodzenia", "narodowosc", "pesel", "nr_Kategorii", "nr_Adresu");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zawodnik);
        insertActor.execute(param);
    }

    public Zawodnicy get(int nrZawodnika) {
        Object[] args = {nrZawodnika};
        String sql = "SELECT * FROM ZAWODNICY WHERE NR_ZAWODNIKA =" + args[0];
        Zawodnicy zawodnik = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Zawodnicy.class));
        return zawodnik;
    }

    public void update(Zawodnicy zawodnik) {
        String sql = "UPDATE ZAWODNICY SET imie=:imie, nazwisko=:nazwisko, plec=:plec, wzrost=:wzrost, waga=:waga, data_Urodzenia=:data_Urodzenia, narodowosc=:narodowosc, pesel=:pesel, nr_Adresu=:nr_Adresu, nr_Kategorii=:nr_Kategorii  WHERE nr_Zawodnika=:nr_Zawodnika";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(zawodnik);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete (int nrZawodnika) {
        String sql = "DELETE FROM ZAWODNICY WHERE nr_Zawodnika=?";
        jdbcTemplate.update(sql,nrZawodnika);
    }
}
