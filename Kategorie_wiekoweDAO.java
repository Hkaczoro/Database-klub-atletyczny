package Example.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.beans.BeanProperty;
import java.util.List;

@Repository
public class Kategorie_wiekoweDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Constructor for jdbcTemplate
    public Kategorie_wiekoweDAO(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Kategorie_wiekowe> list() {
        String sql = "SELECT * FROM KATEGORIE_WIEKOWE";
        List<Kategorie_wiekowe> listKatwiek = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Kategorie_wiekowe.class));
        return listKatwiek;
    }

    // Create
    public void save(Kategorie_wiekowe katwiek) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("KATEGORIE_WIEKOWE").usingColumns("nr_kategorii","kategoria","minimalny_wiek","maksymalny_wiek");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(katwiek);
        insertActor.execute(param);
    }

    // Read
    public Kategorie_wiekowe get(int nr_kategorii) {
        Object[] args = {nr_kategorii};
        String sql = "SELECT * FROM KATEGORIE_WIEKOWE WHERE nr_kategorii =" + args[0];
        Kategorie_wiekowe katwiek = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Kategorie_wiekowe.class));
        return katwiek;
    }

    // Update
    public void update(Kategorie_wiekowe katwiek) {
        String sql = "UPDATE KATEGORIE_WIEKOWE SET kategoria=:kategoria, minimalny_wiek=:minimalny_wiek, maksymalny_wiek=:maksymalny_wiek WHERE nr_kategorii=:nr_kategorii";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(katwiek);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }


    // Delete
    public void delete (int nr_kategorii) {
        String sql = "DELETE FROM KATEGORIE_WIEKOWE WHERE nr_kategorii=?";
        jdbcTemplate.update(sql,nr_kategorii);
    }
}
