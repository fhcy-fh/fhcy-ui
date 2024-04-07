package top.fhcy.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Objects;

/**
 * @author fenghao
 */
public class SwingJFrame extends JFrame {

    private static SwingJFrame instance = null;

    private SwingJFrame() {
    }

    public static SwingJFrame getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (SwingJFrame.class) {
                if (Objects.isNull(instance)) {
                    instance = new SwingJFrame();
                    return instance;
                }
                return instance;
            }
        } else {
            return instance;
        }
    }

    public void init() {
        Image image = new ImageIcon(SwingJFrame.class.getResource("/logo.png")).getImage();

        // Setting the width and height of frame
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /* 创建面板，这个类似于 HTML 的 div 标签
         * 我们可以创建多个面板并在 JFrame 中指定位置
         * 面板中我们可以添加文本字段，按钮及其他组件。
         */
        JPanel panel = new JPanel();
        // 添加面板
        this.add(panel);
        /*
         * 调用用户定义的方法并添加组件到面板
         */
        placeComponents(panel);

        // 设置界面可见
        this.setVisible(true);

//		设置托盘图标
        TrayIcon trayIcon = new TrayIcon(image);
//		创建托盘图标对象
        SystemTray systemTray = SystemTray.getSystemTray();

        SwingJFrame jFrame = SwingJFrame.getInstance();
        jFrame.setVisible(false);
        try {
            systemTray.add(trayIcon);
        } catch (AWTException e1) {
            e1.printStackTrace();
        }
// 		窗口监听
        jFrame.addWindowListener(new WindowAdapter() {
            // 			窗口最小化事件
            public void windowIconified(WindowEvent e) {
                try {
//					窗口最小化时显示托盘图标
                    systemTray.add(trayIcon);
                } catch (AWTException e1) {
                    e1.printStackTrace();
                }
//				设置窗口不可见
                jFrame.setVisible(false);
            }
        });

//		鼠标监听
        trayIcon.addMouseListener(new MouseAdapter() {
            //			鼠标点击事件
            @Override
            public void mouseClicked(MouseEvent e) {
//				鼠标点击次数
                int clt = e.getClickCount();
                if (clt == 1) {
//					鼠标点击托盘图标一次，恢复原窗口
                    jFrame.setExtendedState(NORMAL);
                }
//				托盘图标消失
                systemTray.remove(trayIcon);
//				设置窗口可见
                jFrame.setVisible(true);
            }
        });

    }



    private static void placeComponents(JPanel panel) {

        /* 布局部分我们这边不多做介绍
         * 这边设置布局为 null
         */
        panel.setLayout(null);
    }
}
