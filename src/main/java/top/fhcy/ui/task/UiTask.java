package top.fhcy.ui.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.fhcy.biz.MemoryEnWordBiz;
import top.fhcy.entity.MemoryEnWord;
import top.fhcy.ui.SwingJFrame;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;

/**
 * @author fenghao
 */
@Component
public class UiTask {

    @Resource
    private MemoryEnWordBiz memoryEnWordBiz;

    @Scheduled(cron ="0 0/5 * * * ?")
//    @Scheduled(cron ="*/5 * * * * ?")
    public void test() {
        MemoryEnWord enWord = memoryEnWordBiz.getEnWord();
        SwingJFrame jFrame = SwingJFrame.getInstance();
        Frame frame = new Frame();
        frame.setAlwaysOnTop(true);
        JOptionPane.showMessageDialog(frame, enWord.getEnWord(), "FHCY", JOptionPane.PLAIN_MESSAGE);
        jFrame.setExtendedState(JFrame.NORMAL);
    }
}
