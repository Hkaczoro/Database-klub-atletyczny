package Example.Test;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;


public class GUI extends JFrame {

    private JButton ButtonDisplay;

    public GUI() {
        super("Klub lekkoatletyczny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(400,400,1500,1000);

        ButtonDisplay = new JButton("Wyświetl");
        ButtonDisplay.setBounds(90,900,150,50);
        add(ButtonDisplay);

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
        dataSource.setUsername("jjanusz");
        dataSource.setPassword("jjanusz");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        Kategorie_wiekoweDAO dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));


        DefaultTableModel model = new javax.swing.table.DefaultTableModel(new String[] {"Nr_kategorii", "Kategoria", "Minimalny wiek", "Maksymalny wiek" },0);
        JTable table = new JTable();
        addDataToTable(dao,table,model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(50,50,800,100);
        add(sp);


        setLayout(null);

    }

    public void addDataToTable(Kategorie_wiekoweDAO dao, JTable table, DefaultTableModel model) {
        List<String> list1 =dao.listcol("NR_KATEGORII");
        List<String> list2 =dao.listcol("KATEGORIA");
        List<String> list3 =dao.listcol("MINIMALNY_WIEK");
        List<String> list4 =dao.listcol("MAKSYMALNY_WIEK");
        System.out.println(list1);
        table.setModel(model);
        for(int i=0;i<list1.size();i++) {
            model.addRow(new Object[] {list1.get(i),list2.get(i),list3.get(i),list4.get(i),});
        }

    }


}
