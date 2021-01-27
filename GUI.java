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

    private JButton ButtonDisplay, Add, Save, Update, UpdateButton, Delete, DeleteButton;
    private JTextField Kategoria, Min_wiek, Max_wiek, Nr_Kategorii, Nr_KategoriiD, KategoriaU, Min_wiekU, Max_wiekU;
    private JLabel kategoria, min_wiek, maks_wiek, nr_kategorii, nr_kategoriid, kategoriau, min_wieku, maks_wieku;
    private JTable table;
    private JScrollPane sp;
    private Kategorie_wiekoweDAO dao;
    private JPanel inputPanel, deletePanel, updatePanel;
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

        Update = new JButton("Update");
        Update.setBounds(510,900,150,50);
        add(Update);
        Update.addActionListener(this);

        Delete = new JButton("Delete");
        Delete.setBounds(720,900,150,50);
        add(Delete);
        Delete.addActionListener(this);

        dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
        dataSource.setUsername("jjanusz");
        dataSource.setPassword("jjanusz");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));


        model = new javax.swing.table.DefaultTableModel(new String[] {"Nr_kategorii", "Kategoria", "Minimalny wiek", "Maksymalny wiek" },0);
        table = new JTable();
        table.setSize(500,500);
        addDataToTable(dao,table,model);
        sp = new JScrollPane(table);
        sp.setBounds(50,50,800,200);
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
        inputPanel.setBounds(500,500,400,110);
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
        //Tworzenie Delete Panelu
        nr_kategoriid = new JLabel("Nr_Kategorii do usunięcia: ");
        Nr_KategoriiD = new JTextField();

        //pomocniczy panel do wprowadzania danych
        deletePanel = new JPanel();
        deletePanel.setLayout(new GridLayout(2, 2));
        deletePanel.setBounds(500,500,400,50);
        deletePanel.add(nr_kategoriid);
        deletePanel.add(Nr_KategoriiD);
        //tworzymy przycisk logowania
        DeleteButton = new JButton("Delete");
        DeleteButton.setBounds(100,470,400,80);
        deletePanel.add(DeleteButton);
        DeleteButton.addActionListener(this);
        this.add(deletePanel);
        deletePanel.setVisible(false);

        //Tworzenie Update Panelu
        nr_kategorii = new JLabel("Nr_Kategorii do usunięcia: ");
        kategoriau = new JLabel("Kategoria: ");
        min_wieku = new JLabel("Minimalny wiek: ");
        maks_wieku = new JLabel("Maksymalny wiek: ");
        KategoriaU = new JTextField();
        Min_wiekU = new JTextField();
        Max_wiekU = new JTextField();
        Nr_Kategorii = new JTextField();

        //pomocniczy panel do wprowadzania danych
        updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(5, 5));
        updatePanel.setBounds(500,500,400,110);
        updatePanel.add(nr_kategorii);
        updatePanel.add(Nr_Kategorii);
        updatePanel.add(kategoriau);
        updatePanel.add(KategoriaU);
        updatePanel.add(min_wieku);
        updatePanel.add(Min_wiekU);
        updatePanel.add(maks_wieku);
        updatePanel.add(Max_wiekU);
        //tworzymy przycisk logowania
        UpdateButton = new JButton("Update");
        UpdateButton.setBounds(100,470,400,80);
        updatePanel.add(UpdateButton);
        UpdateButton.addActionListener(this);
        this.add(updatePanel);
        updatePanel.setVisible(false);

        setResizable(false);
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
            deletePanel.setVisible(false);
            updatePanel.setVisible(false);
        }

        if(source==Add) {
            sp.setVisible(true);
            deletePanel.setVisible(false);
            updatePanel.setVisible(false);
            Kategoria.setText("");
            Min_wiek.setText("");
            Max_wiek.setText("");
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
            deletePanel.setVisible(false);
            updatePanel.setVisible(false);
            sp.setVisible(true);
        }

        if(source==Delete){
            inputPanel.setVisible(false);
            updatePanel.setVisible(false);
            deletePanel.setVisible(true);
            sp.setVisible(true);
            Nr_KategoriiD.setText("");
        }

        if(source==DeleteButton){
            System.out.println("Delete");
            //Kategorie_wiekowe kategorie_wiekowe = new Kategorie_wiekowe();
            int nr_kategorii = Integer.parseInt(Nr_KategoriiD.getText());
            System.out.println(Nr_KategoriiD.getText());
            dao.delete(nr_kategorii);
            dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));
            model.getDataVector().removeAllElements();
            addDataToTable(dao,table,model);
            Nr_KategoriiD.setText("");


        }

        if(source==Update){
            inputPanel.setVisible(false);
            deletePanel.setVisible(false);
            updatePanel.setVisible(true);
            sp.setVisible(true);
            Nr_Kategorii.setText("");
            KategoriaU.setText("");
            Min_wiekU.setText("");
            Max_wiekU.setText("");
        }

        if (source==UpdateButton){
            System.out.println("Update");
            Kategorie_wiekowe kategorie_wiekowe = new Kategorie_wiekowe();
            kategorie_wiekowe.setNr_kategorii(Integer.parseInt(Nr_Kategorii.getText()));
            kategorie_wiekowe.setKategoria(KategoriaU.getText());
            kategorie_wiekowe.setMinimalny_wiek(Integer.parseInt(Min_wiekU.getText()));
            kategorie_wiekowe.setMaksymalny_wiek(Integer.parseInt(Max_wiekU.getText()));
            dao.update(kategorie_wiekowe);
            dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));
            model.getDataVector().removeAllElements();
            addDataToTable(dao,table,model);
            Nr_Kategorii.setText("");
            KategoriaU.setText("");
            Min_wiekU.setText("");
            Max_wiekU.setText("");
        }

    }





}
