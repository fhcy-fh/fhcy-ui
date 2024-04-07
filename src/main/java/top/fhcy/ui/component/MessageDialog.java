package top.fhcy.ui.component;

import javax.swing.*;
import java.awt.*;

/**
 * @author fenghao
 */
public class MessageDialog {

    private final static String FHCY = "FHCY";

    public static void show(String title, String description) {
        Frame frame = new Frame();
        frame.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(frame, title + " : " + description, FHCY, JOptionPane.PLAIN_MESSAGE);
    }

}
