package Example.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LoginListener implements ActionListener {
    //Główna ramka programu
    private final JFrame frame;
    //Panel logowania, potrzebny do pobrania loginu i hasła
    private LoginPanel loginPanel;

    private UserValidator UV;

    public void setPanel(LoginPanel loginPanel) {
        this.loginPanel = loginPanel;
    }

    public LoginListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String name = loginPanel.getName();
        String password = loginPanel.getPassword();
        if (UserValidator.authenticate(name, password)) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    frame.getContentPane().removeAll();
                    frame.setVisible(false);
                    frame.dispose();
                    UV = new UserValidator();
                    boolean a = UV.checkAccess(name, password);
                    new GUI(a);

                }
            });
        }
        if(!UserValidator.authenticate(name,password)){
            JOptionPane.showMessageDialog(frame,"Błędny login lub hasło");
        }
    }
}