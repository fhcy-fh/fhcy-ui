package top.fhcy.ui.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.fhcy.biz.MemoryEnWordBiz;
import top.fhcy.entity.MemoryEnWord;
import top.fhcy.ui.SwingJFrame;
import top.fhcy.ui.component.MessageDialog;

import javax.annotation.Resource;
import javax.swing.*;

/**
 * @author fenghao
 */
@Component
public class UiTask {

    @Resource
    private MemoryEnWordBiz memoryEnWordBiz;

    @Scheduled(cron ="0 0/3 * * * ?")
//    @Scheduled(cron ="*/5 * * * * ?")
    public void test() {
        MemoryEnWord enWord = memoryEnWordBiz.getEnWord();
        SwingJFrame jFrame = SwingJFrame.getInstance();
        MessageDialog.show(enWord.getEnWord(), enWord.getDescription());
        jFrame.setExtendedState(JFrame.NORMAL);
    }
}
