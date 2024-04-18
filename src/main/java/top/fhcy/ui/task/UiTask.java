package top.fhcy.ui.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.fhcy.biz.MemoryBiz;
import top.fhcy.entity.Memory;
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
    private MemoryBiz memoryBiz;

    @Scheduled(cron ="0 0/2 * * * ?")
//    @Scheduled(cron ="*/5 * * * * ?")
    public void test() {
        Memory memory = memoryBiz.get();
        SwingJFrame jFrame = SwingJFrame.getInstance();
        MessageDialog.show(memory.getTitle(), memory.getDescription());
        jFrame.setExtendedState(JFrame.NORMAL);
    }
}
