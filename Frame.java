package Example.Test;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Frame extends JFrame {
    public Frame() {
        super("Komponenty tekstowe");
        LoginListener listener = new LoginListener(this);
        JPanel loginPanel = new LoginPanel(listener);
        add(loginPanel);
        setLocation(800,500);
        setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }
}
