package Example.Test;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;


public class GUI extends JFrame implements ActionListener {

    private JButton ButtonDisplay, Add, Save, SaveZ, Update, UpdateButton, UpdateButtonZ, Delete, DeleteButton, DeleteButtonZ, DeleteAll, Refresh, exit;
    private JTextField Kategoria, Min_wiek, Max_wiek, Nr_Kategorii, Nr_KategoriiD, KategoriaU, Min_wiekU, Max_wiekU;
    private JTextField Nr_Zawodnika, Imie, Nazwisko, Plec, Wzrost, Waga, Data_Urodzenia, Narodowosc, Pesel, Nr_KategoriiZ, Nr_Adresu;
    private JTextField Nr_ZawodnikaD, ImieU, NazwiskoU, PlecU, WzrostU, WagaU, Data_UrodzeniaU, NarodowoscU, PeselU, Nr_KategoriiZU, Nr_AdresuU;
    private JLabel nr_zawodnika, imie, nazwisko, plec, wzrost, waga, data_urodzenia, narodowosc, pesel, nr_kategoriiz, nr_adresu;
    private JLabel nr_zawodnikad, imieu, nazwiskou, plecu, wzrostu, wagau, data_urodzeniau, narodowoscu, peselu, nr_kategoriizu, nr_adresuu;
    private JLabel kategoria, min_wiek, maks_wiek, nr_kategorii, nr_kategoriid, kategoriau, min_wieku, maks_wieku;
    private JTable table;
    private JScrollPane sp;
    private Kategorie_wiekoweDAO dao;
    private ZawodnicyDAO daozaw;
    private TrenerzyDAO daotre;
    private JPanel inputPanel, deletePanel, updatePanel;
    private JPanel inputPanelZ, deletePanelZ, updatePanelZ;
    private DriverManagerDataSource dataSource;
    private DefaultTableModel model;
    private JComboBox changeTable;
    private int pom;

    public GUI(boolean a) {
        super("Klub lekkoatletyczny");
        int pom = 0;
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

        Refresh = new JButton("Refresh");
        Refresh.setBounds(930,900,150,50);
        add(Refresh);
        Refresh.addActionListener(this);

        DeleteAll = new JButton("DeleteAll");
        DeleteAll.setBounds(1140,900,150,50);
        add(DeleteAll);
        DeleteAll.addActionListener(this);

        dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@ora3.elka.pw.edu.pl:1521:ora3inf");
        dataSource.setUsername("jjanusz");
        dataSource.setPassword("jjanusz");
        dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));
        daozaw = new ZawodnicyDAO(new JdbcTemplate(dataSource));
        daotre = new TrenerzyDAO((new JdbcTemplate(dataSource)));

        String[] tables = {"Kategorie wiekowe", "Zawodnicy", "Trenerzy"};
        changeTable = new JComboBox(tables);
        changeTable.setBounds(50, 20, 200, 30);
        changeTable.setSelectedIndex(0);
        add(changeTable);
        changeTable.addActionListener(this);


        model = new javax.swing.table.DefaultTableModel(new String[] {"Nr_kategorii", "Kategoria", "Minimalny wiek", "Maksymalny wiek" },0);
        table = new JTable();
        table.setSize(500,500);
        addDataToTable(dao,table,model);
        sp = new JScrollPane(table);
        sp.setBounds(50,50,800,300);
        table.setBackground(Color.WHITE);
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


//////////
        imie = new JLabel("Imię: ");
        nazwisko = new JLabel("Nazwisko: ");
        plec = new JLabel("Plec: ");
        wzrost = new JLabel("Wzrost: ");
        waga = new JLabel("Waga: ");
        data_urodzenia = new JLabel("Data urodzenia: ");
        narodowosc = new JLabel("Narodowość: ");
        pesel = new JLabel("Pesel: ");
        nr_kategoriiz = new JLabel("Nr Kategorii: ");
        nr_adresu = new JLabel("Nr Adresu: ");
        //
        Imie = new JTextField();
        Nazwisko = new JTextField();
        Plec = new JTextField();
        Wzrost = new JTextField();
        Waga = new JTextField();
        Data_Urodzenia = new JTextField();
        Narodowosc = new JTextField();
        Pesel = new JTextField();
        Nr_KategoriiZ = new JTextField();
        Nr_Adresu = new JTextField();

        //pomocniczy panel do wprowadzania danych
        inputPanelZ = new JPanel();
        inputPanelZ.setLayout(new GridLayout(11, 2));
        inputPanelZ.setBounds(1000,300,300,300);
        inputPanelZ.add(imie);
        inputPanelZ.add(Imie);
        inputPanelZ.add(nazwisko);
        inputPanelZ.add(Nazwisko);
        inputPanelZ.add(plec);
        inputPanelZ.add(Plec);
        inputPanelZ.add(wzrost);
        inputPanelZ.add(Wzrost);
        inputPanelZ.add(waga);
        inputPanelZ.add(Waga);
        inputPanelZ.add(data_urodzenia);
        inputPanelZ.add(Data_Urodzenia);
        inputPanelZ.add(narodowosc);
        inputPanelZ.add(Narodowosc);
        inputPanelZ.add(pesel);
        inputPanelZ.add(Pesel);
        inputPanelZ.add(nr_kategoriiz);
        inputPanelZ.add(Nr_KategoriiZ);
        inputPanelZ.add(nr_adresu);
        inputPanelZ.add(Nr_Adresu);
        //tworzymy przycisk logowania
        SaveZ = new JButton("Save");
        SaveZ.setBounds(100,470,30,80);
        inputPanelZ.add(SaveZ);
        SaveZ.addActionListener(this);
        this.add(inputPanelZ);
        inputPanelZ.setVisible(false);

        //Tworzenie Delete Panelu
        nr_kategoriid = new JLabel("Nr_Kategorii do usunięcia: ");
        Nr_KategoriiD = new JTextField();
        //pomocniczy panel do wprowadzania danych
        deletePanelZ = new JPanel();
        deletePanelZ.setLayout(new GridLayout(2, 2));
        deletePanelZ.setBounds(500,500,400,50);
        deletePanelZ.add(nr_kategoriid);
        deletePanelZ.add(Nr_KategoriiD);
        //tworzymy przycisk logowania
        DeleteButtonZ = new JButton("Delete");
        DeleteButtonZ.setBounds(100,470,400,80);
        deletePanelZ.add(DeleteButtonZ);
        DeleteButtonZ.addActionListener(this);
        this.add(deletePanelZ);
        deletePanelZ.setVisible(false);

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
        updatePanelZ = new JPanel();
        updatePanelZ.setLayout(new GridLayout(5, 5));
        updatePanelZ.setBounds(500,500,400,110);
        updatePanelZ.add(nr_kategorii);
        updatePanelZ.add(Nr_Kategorii);
        updatePanelZ.add(kategoriau);
        updatePanelZ.add(KategoriaU);
        updatePanelZ.add(min_wieku);
        updatePanelZ.add(Min_wiekU);
        updatePanelZ.add(maks_wieku);
        updatePanelZ.add(Max_wiekU);
        //tworzymy przycisk logowania
        UpdateButton = new JButton("Update");
        UpdateButton.setBounds(100,470,400,80);
        updatePanel.add(UpdateButton);
        UpdateButton.addActionListener(this);
        this.add(updatePanel);
        updatePanel.setVisible(false);


/////////////////////




        setResizable(false);
        setLayout(null);

        if (!a){
            Add.setVisible(false);
            Delete.setVisible(false);
            Update.setVisible(false);
            DeleteAll.setVisible(false);
        }
        exit = new JButton("Log out");
        exit.setBounds(1350, 10, 90, 50);
        add(exit);
        exit.addActionListener(this);


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

    public void addDataZawToTable(ZawodnicyDAO daozaw, JTable table, DefaultTableModel model) {
        List<String> listZ1 =daozaw.listcol("NR_ZAWODNIKA");
        List<String> listZ2 =daozaw.listcol("IMIE");
        List<String> listZ3 =daozaw.listcol("NAZWISKO");
        List<String> listZ4 =daozaw.listcol("PLEC");
        List<String> listZ5 =daozaw.listcol("WZROST");
        List<String> listZ6 =daozaw.listcol("WAGA");
        List<String> listZ7 =daozaw.listcol("DATA_URODZENIA");
        List<String> listZ8 =daozaw.listcol("NARODOWOSC");
        List<String> listZ9 =daozaw.listcol("PESEL");
        List<String> listZ10 =daozaw.listcol("NR_KATEGORII");
        List<String> listZ11 =daozaw.listcol("NR_ADRESU");
        System.out.println(listZ1);
        table.setModel(model);
        for(int i=0;i<listZ1.size();i++) {
            model.addRow(new Object[] {listZ1.get(i),listZ2.get(i),listZ3.get(i),listZ4.get(i),listZ5.get(i),listZ6.get(i),listZ7.get(i),listZ8.get(i),listZ9.get(i),listZ10.get(i),listZ11.get(i),});
        }
    }

    public void addDataTreToTable(TrenerzyDAO daotre, JTable table, DefaultTableModel model){
        List<String> listT1 =daotre.listcol("NR_TRENERA");
        List<String> listT2 =daotre.listcol("IMIE");
        List<String> listT3 =daotre.listcol("NAZWISKO");
        List<String> listT4 =daotre.listcol("DYSCYPLINA");
        List<String> listT5 =daotre.listcol("PESEL");
        List<String> listT6 =daotre.listcol("PENSJA");
        table.setModel(model);
        for(int i=0;i<listT1.size();i++) {
            model.addRow(new Object[] {listT1.get(i),listT2.get(i),listT3.get(i),listT4.get(i),listT5.get(i),listT6.get(i)});
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == exit){
            dispose();
            Frame frame = new Frame();
        }


        if (changeTable.getSelectedIndex() == 0){
            pom = 0;
            model = new javax.swing.table.DefaultTableModel(new String[] {"Nr_kategorii", "Kategoria", "Minimalny wiek", "Maksymalny wiek" },0);
            dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));
            model.getDataVector().removeAllElements();
            addDataToTable(dao,table,model);
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

            if(source==Refresh){
                dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));
                model.getDataVector().removeAllElements();
                addDataToTable(dao,table,model);
            }

            if(source==DeleteAll){
                List<String> listD1 =dao.listcol("NR_KATEGORII");
                List<String> listD2 =daozaw.listcol("NR_KATEGORII");
                table.setModel(model);
                for(int i=0;i<listD1.size();i++) {
                    for(int j=0;j<listD2.size();j++){
                        if(!listD1.get(i).equals(listD2.get(j))){
                            dao.delete(Integer.parseInt(listD1.get(i)));
                            j=listD2.size();
                        }
                    }
                }
                dao = new Kategorie_wiekoweDAO(new JdbcTemplate(dataSource));
                model.getDataVector().removeAllElements();
                addDataToTable(dao,table,model);
            }

        }
        if (changeTable.getSelectedIndex() == 1){
            inputPanel.setVisible(false);
            deletePanel.setVisible(false);
            updatePanel.setVisible(false);
            if(pom==0){
                sp.setSize(900,500);
                table.setSize(900,500);
                model.getDataVector().removeAllElements();
                model.setColumnIdentifiers(new String[] {"Nr_zawodnika", "Imie", "Nazwisko", "Płeć", "Wzrost", "Waga", "Data_urodzenia", "Narodowość", "Pesel", "Nr_kategorii", "Nr_adresu"});
                table.getColumnModel().getColumn(2).setPreferredWidth(100);
                table.getColumnModel().getColumn(6).setPreferredWidth(130);
                table.getColumnModel().getColumn(8).setPreferredWidth(100);
                daozaw = new ZawodnicyDAO(new JdbcTemplate(dataSource));
                addDataZawToTable(daozaw,table,model);
                pom += 1;
            }
            if(source==ButtonDisplay){
                sp.setVisible(true);
                inputPanelZ.setVisible(false);
                deletePanelZ.setVisible(false);
                updatePanelZ.setVisible(false);
            }
            if (source==Add){
                inputPanelZ.setVisible(true);
                /*
                Imie.setText("");
                Nazwisko.setText("");
                Plec.setText("");
                Wzrost.setText("");
                Waga.setText("");
                Data_Urodzenia.setText("");
                Narodowosc.setText("");
                Pesel.setText("");
                Nr_KategoriiZ.setText("");
                Nr_Adresu.setText("");*/
            }

            if (source==SaveZ){
                Zawodnicy zawodnicy = new Zawodnicy(0, Imie.getText(), Nazwisko.getText(), Plec.getText(), Float.parseFloat(Wzrost.getText()), Float.parseFloat(Waga.getText()), Data_Urodzenia.getText(), Narodowosc.getText(), Pesel.getText(), Integer.parseInt(Nr_Kategorii.getText()), Integer.parseInt(Nr_Adresu.getText()));
                daozaw.save(zawodnicy);
                Trenerzy trenerzy = new Trenerzy(0,Imie.getText(), Imie.getText(), Imie.getText(), Imie.getText(), Integer.parseInt(Imie.getText()));
                daozaw = new ZawodnicyDAO(new JdbcTemplate(dataSource));
                model.getDataVector().removeAllElements();
                addDataZawToTable(daozaw,table,model);
                Imie.setText("");
                Nazwisko.setText("");
                Plec.setText("");
                Wzrost.setText("");
                Waga.setText("");
                Data_Urodzenia.setText("");
                Narodowosc.setText("");
                Pesel.setText("");
                Nr_KategoriiZ.setText("");
                Nr_Adresu.setText("");
            }

        }
        if (changeTable.getSelectedIndex() == 2){
            pom = 0;
            model.getDataVector().removeAllElements();
            model.setColumnIdentifiers(new String[] {"Nr_trenera", "Imie", "Nazwisko", "Dyscyplina", "Pesel", "Pensja"});
            daotre = new TrenerzyDAO(new JdbcTemplate(dataSource));
            addDataTreToTable(daotre,table,model);
            if(source==ButtonDisplay){
                sp.setVisible(true);
                inputPanel.setVisible(false);
                deletePanel.setVisible(false);
                updatePanel.setVisible(false);
            }

        }


    }


}






