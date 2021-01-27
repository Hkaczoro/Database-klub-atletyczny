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
public class TrenerzyDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TrenerzyDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Trenerzy> list() {
        String sql = "SELECT * FROM TRENERZY";
        List<Trenerzy> listTrenerzy = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Trenerzy.class));
        return listTrenerzy;
    }

    public List<String> listcol(String col) {
        String sql = "SELECT" + " " + col + " " + "FROM TRENERZY";
        List<String> listTrenerzy = jdbcTemplate.queryForList(sql,String.class);
        return listTrenerzy;
    }

    public void save(Trenerzy trener) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("KATEGORIE_WIEKOWE").usingColumns("nr_trenera", "imie", "nazwisko", "dyscyplina", "pesel", "pensja");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(trener);
        insertActor.execute(param);
    }

    public Trenerzy get(int nrTrenera) {
        Object[] args = {nrTrenera};
        String sql = "SELECT * FROM TRENERZY WHERE nr_trenera =" + args[0];
        Trenerzy trener = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Trenerzy.class));
        return trener;
    }

    public void update(Trenerzy trener) {
        String sql = "UPDATE TRENERZY SET nr_trenera=:nr_trenera, imie=:imie, nazwisko=:nazwisko, dyscyplina=:dyscyplina, pesel=:pesel, pensja=:pensja";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(trener);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql,param);
    }

    public void delete(int nr_trenera) {
        String sql = "DELETE FROM TRENERZY WHERE nr_trenera=?";
        jdbcTemplate.update(sql,nr_trenera);
    }
}
