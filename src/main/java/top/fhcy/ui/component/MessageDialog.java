package top.fhcy.ui.component;

import javax.swing.*;
import java.awt.*;

/**
 * @author fenghao
 */
public class MessageDialog {

    private final static String FHCY = "FHCY";

    public static void show(String title, String description) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        Frame frame = new Frame();
        frame.setFont(new Font("宋体",Font.BOLD,100));
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        JOptionPane.showMessageDialog(frame, title + "\n" + description, FHCY, JOptionPane.PLAIN_MESSAGE);
    }

}
