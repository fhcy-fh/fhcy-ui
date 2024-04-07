package top.fhcy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import top.fhcy.ui.SwingJFrame;

/**
 * @author fenghao
 */
@EnableScheduling
@MapperScan("top.fhcy.mapper")
@SpringBootApplication(scanBasePackages = "top.fhcy")
public class FhcyApplication {

    public static void main(String[] args) {
        SwingJFrame.getInstance().init();
        SpringApplication.run(FhcyApplication.class, args);
    }
}
