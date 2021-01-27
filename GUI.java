package Example.Test;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class GUI extends JFrame implements ActionListener {

    private JButton ButtonDisplay, Add, Save;
    private JTextField Kategoria, Min_wiek, Max_wiek;
    private JLabel kategoria, min_wiek, maks_wiek;
    private JTable table;
    private JScrollPane sp;
    private Kategorie_wiekoweDAO dao;
    private JPanel inputPanel;
    private DriverManagerDataSource dataSource;
    private DefaultTableModel model;

    public GUI() {
        super("Klub lekkoatletyczny");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(400,200,1500,1000);

        ButtonDisplay = new JButton("Wyświetl");
        ButtonDisplay.setBounds(90,900,150,50);
        add(ButtonDisplay);
        ButtonDisplay.addActionListener(this);

        Add = new JButton("Add");
        Add.setBounds(300,900,150,50);
        add(Add);
        Add.addActionListener(this);

        dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
        dataSource.setUsername("jjanusz");
        dataSource.setPassword("jjanusz");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));


        model = new javax.swing.table.DefaultTableModel(new String[] {"Nr_kategorii", "Kategoria", "Minimalny wiek", "Maksymalny wiek" },0);
        table = new JTable();
        addDataToTable(dao,table,model);
        sp = new JScrollPane(table);
        sp.setBounds(50,50,800,100);
        add(sp);
        table.setEnabled(false);
        sp.setVisible(false);

        kategoria = new JLabel("Kategoria: ");
        min_wiek = new JLabel("Minimalny wiek: ");
        maks_wiek = new JLabel("Maksymalny wiek: ");
        Kategoria = new JTextField();
        Min_wiek = new JTextField();
        Max_wiek = new JTextField();

        //pomocniczy panel do wprowadzania danych
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 4));
        inputPanel.setBounds(500,500,250,90);
        inputPanel.add(kategoria);
        inputPanel.add(Kategoria);
        inputPanel.add(min_wiek);
        inputPanel.add(Min_wiek);
        inputPanel.add(maks_wiek);
        inputPanel.add(Max_wiek);
        //tworzymy przycisk logowania
        Save = new JButton("Save");
        Save.setBounds(100,470,30,80);
        inputPanel.add(Save);
        Save.addActionListener(this);
        this.add(inputPanel);
        inputPanel.setVisible(false);


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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source==ButtonDisplay){
            sp.setVisible(true);
            inputPanel.setVisible(false);
        }

        if(source==Add) {
            sp.setVisible(false);
            inputPanel.setVisible(true);

        }

        if(source==Save){
            Kategorie_wiekowe kategorie_wiekowe = new Kategorie_wiekowe(0,Kategoria.getText(),Integer.parseInt(Min_wiek.getText()),Integer.parseInt(Max_wiek.getText()));
            dao.save(kategorie_wiekowe);
            dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));
            model.getDataVector().removeAllElements();
            addDataToTable(dao,table,model);
            Kategoria.setText("");
            Min_wiek.setText("");
            Max_wiek.setText("");
            inputPanel.setVisible(false);
            sp.setVisible(true);
        }


    }





}
