package Example.Test;

import org.w3c.dom.events.Event;

import java.awt.*;

public class GUIRUN {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}
