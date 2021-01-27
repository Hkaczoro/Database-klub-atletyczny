package Example.Test;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class LoginPanel extends JPanel {
    private JTextField nameField; //pole na nazwę
    private JPasswordField passField; //pole na hasło
    private JButton loginButton; //przycisk logowania
    private LoginListener listener; //słuchacz przycisku

    /**
     * @return wprowadzona nazwa użytkownika
     */
    public String getName() {
        return nameField.getText();
    }

    /**
     * @return wprowadzone przez użytkownika hasło
     */
    public String getPassword() {
        String password = "";
        char[] pass = passField.getPassword();
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }
        return password;
    }

    public LoginPanel(LoginListener listener) {
        super();
        // ustawiamy layout
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        // tworzymy komponenty logowania
        this.listener = listener;
        this.listener.setPanel(this);
        createComponents();
    }

    /**
     * Metoda, która tworzy etykiety i pola do wprowadzania danych.
     */



    private void createComponents() {
        JLabel name = new JLabel("Name: ");
        JLabel password = new JLabel("Password: ");
        nameField = new JTextField();
        passField = new JPasswordField();

        //pomocniczy panel do wprowadzania danych
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(name);
        inputPanel.add(nameField);
        inputPanel.add(password);
        inputPanel.add(passField);
        //tworzymy przycisk logowania
        loginButton = new JButton("Zaloguj");
        loginButton.addActionListener(listener);

        //pomocniczy panel do wyśrodkowania elementów
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(inputPanel, BorderLayout.CENTER);
        parentPanel.add(loginButton, BorderLayout.SOUTH);

        // dodajemy do głównego panelu
        this.add(parentPanel);
    }
}
